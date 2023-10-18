package booking.service;

import java.util.Collection;

import booking.exception.BookingException;
import booking.model.dto.BookingDto;

public interface BookingService {
    
    Collection<BookingDto> getAllByUser(String email) throws BookingException;
    BookingDto getById(String bookingId) throws BookingException;
    void saveNewBooking(BookingDto newBooking) throws BookingException;
    void modifyBooking(String bookingId, BookingDto booking, boolean completeChange) throws BookingException;
    void deleteBooking(String bookingId) throws BookingException;

}
