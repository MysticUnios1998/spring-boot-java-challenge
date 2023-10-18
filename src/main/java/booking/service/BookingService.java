package booking.service;

import java.util.Collection;

import booking.exception.BookingException;
import booking.model.dto.BookingDto;
import booking.util.ServiceResponse;

public interface BookingService {
    
    ServiceResponse<Collection<BookingDto>> getAllByUser(String email) throws BookingException;
    ServiceResponse<BookingDto> getById(String bookingId) throws BookingException;
    ServiceResponse<String> saveNewBooking(BookingDto newBooking) throws BookingException;
    ServiceResponse<String> modifyBooking(String bookingId, BookingDto booking, boolean completeChange) throws BookingException;
    ServiceResponse<BookingDto> deleteBooking(String bookingId) throws BookingException;

}
