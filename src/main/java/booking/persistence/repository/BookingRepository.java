package booking.persistence.repository;

import java.util.Collection;
import java.util.Optional;

import booking.exception.BookingException;
import booking.model.entity.mongo.BookingEntity;

public interface BookingRepository {
    
    Collection<BookingEntity> getAllByUser(String email) throws BookingException;
    Optional<BookingEntity> getById(String bookingId) throws BookingException;
    String saveNewBooking(BookingEntity newBooking) throws BookingException;
    void deleteBooking(String bookingId) throws BookingException;

}
