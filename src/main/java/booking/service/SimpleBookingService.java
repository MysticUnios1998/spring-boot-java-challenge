package booking.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import booking.exception.BookingException;
import booking.model.dto.BookingDto;
import booking.persistence.repository.BookingRepository;
import booking.util.BookingMapper;

public class SimpleBookingService implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Autowired
    public SimpleBookingService(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public Collection<BookingDto> getAllByUser(String email) throws BookingException {
        return bookingRepository.getAllByUser(email).stream()
            .map(bookingMapper::toBookingDto)
            .toList();
    }

    @Override
    public BookingDto getById(String bookingId) throws BookingException {
        return bookingRepository.getById(bookingId)
            .map(bookingMapper::toBookingDto)
            .orElseThrow();
    }

    @Override
    public void saveNewBooking(BookingDto newBooking) throws BookingException {
        bookingRepository.saveNewBooking(bookingMapper.toBookingEntity(newBooking));
    }

    @Override
    public void modifyBooking(String bookingId, BookingDto booking, boolean completeChange) throws BookingException {
        var bookingToSave = completeChange ? booking : this.partialChange(bookingId, booking);
        this.saveNewBooking(bookingToSave);
    }

    @Override
    public void deleteBooking(String bookingId) throws BookingException {
        bookingRepository.deleteBooking(bookingId);
    }

    private BookingDto partialChange(String bookingId, BookingDto booking) throws BookingException {
        var bookingSaved = this.getById(bookingId);

        if (booking.getEmail() != null) {
            bookingSaved.setEmail(booking.getEmail());
        }

        if (booking.getName() != null) {
            bookingSaved.setName(booking.getName());
        }

        if (booking.getDestination() != null) {
            bookingSaved.setDestination(booking.getDestination());
        }

        if (booking.getDeparture() != null) {
            bookingSaved.setDeparture(booking.getDeparture());
        }

        if (booking.getOrigin() != null) {
            bookingSaved.setOrigin(booking.getOrigin());
        }

        if (booking.getDuration() != null) {
            bookingSaved.setDuration(booking.getDuration());
        }

        return bookingSaved;
    }
    
}
