package com.javaacademy.demo.service;

import com.javaacademy.demo.dto.BookingDto;
import com.javaacademy.demo.dto.BookingDtoResponse;
import com.javaacademy.demo.dto.ClientDto;
import com.javaacademy.demo.entity.Advert;
import com.javaacademy.demo.entity.Booking;
import com.javaacademy.demo.entity.Client;
import com.javaacademy.demo.exception.ClientAlreadyExistsException;
import com.javaacademy.demo.exception.EntityNotFoundException;
import com.javaacademy.demo.exception.FilledIdException;
import com.javaacademy.demo.exception.IntersectionDateException;
import com.javaacademy.demo.exception.NotActiveAdvertException;
import com.javaacademy.demo.mapper.BookingMapperMapstruct;
import com.javaacademy.demo.repository.AdvertRepository;
import com.javaacademy.demo.repository.BookingRepository;
import com.javaacademy.demo.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Optional;
import static java.math.BigDecimal.valueOf;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapperMapstruct bookingMapperMapstruct;
    private final ClientService clientService;
    private final AdvertRepository advertRepository;
    private final ClientRepository clientRepository;
    private static final int PAGE_SIZE = 20;

    @Transactional
    public BookingDtoResponse saveBooking(BookingDto bookingDto) {
        if (bookingDto.getId() != null) {
            throw new FilledIdException("ID бронирования должен быть null");
        }
        ClientDto clientDto = bookingDto.getClientDto();
        if (clientDto.getId() == null) {
            checkClient(clientDto);
            clientDto = clientService.save(clientDto);
            bookingDto.setClientDto(clientDto);
        }
        if (!clientRepository.existsById(clientDto.getId())) {
            throw new EntityNotFoundException("Клиента с ID = %s не существует."
                    .formatted(clientDto.getId()));
        }
        checkAdvert(bookingDto);
        checkDates(bookingDto);
        Booking booking = bookingMapperMapstruct.toEntityWithRelation(bookingDto);
        booking.setBookingPrice(calculateResultPrice(booking));
        booking = bookingRepository.save(booking);
        log.trace("Бронирование сохранено.");
        return bookingMapperMapstruct.toDto(booking);
    }

    @Transactional(readOnly = true)
    public Page<BookingDtoResponse> findAllByEmail(Integer pageNumber, String email) {
        PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE);
        Page<Booking> bookings = bookingRepository.findAllByClientEmail(email, pageRequest);
        log.trace("Выполнен поиск бронирований по email.");
        return bookings.map(bookingMapperMapstruct::toDto);
    }

    private BigDecimal calculateResultPrice(Booking booking) {
        //long period = DAYS.between(booking.getStartBookingDate(), booking.getFinishBookingDate());
        long period = booking.getStartBookingDate().until(booking.getFinishBookingDate(), ChronoUnit.DAYS);
        return booking.getAdvert().getPrice().multiply(valueOf(period));
    }

    private void checkDates(BookingDto bookingDto) {
        if (bookingDto.getStartBookingDate().isAfter(bookingDto.getFinishBookingDate())) {
            throw new IntersectionDateException("Дата начала должна быть раньше даты окончания");
        }
        if (!bookingRepository.canBook(
                bookingDto.getAdvertId(),
                bookingDto.getStartBookingDate(),
                bookingDto.getFinishBookingDate())) {
            throw new IntersectionDateException("Невозможно забронировать в эти даты.");
        }
        log.trace("Выполнена проверка дат.");
    }

    private void checkAdvert(BookingDto bookingDto) {
        int id = bookingDto.getAdvertId();
        Advert advert = advertRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Объявление с ID = %s не найдено."
                        .formatted(id)));
        if (!advert.getIsActive()) {
            throw new NotActiveAdvertException("Объявление с ID = %s не активно"
                    .formatted(id));
        }
    }

    private void checkClient(ClientDto clientDto) {
        Optional<Client> optional = clientRepository.findByEmail(clientDto.getEmail());
        if (optional.isPresent()) {
            Client client = optional.get();
            if (Objects.equals(client.getEmail(), clientDto.getEmail())) {
                throw new ClientAlreadyExistsException("Клиент с такой почтой уже существует.");
            }
        }
    }
}
