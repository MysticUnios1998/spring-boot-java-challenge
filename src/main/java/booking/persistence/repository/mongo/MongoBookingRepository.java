package booking.persistence.repository.mongo;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import booking.exception.BookingException;
import booking.model.entity.mongo.BookingEntity;
import booking.persistence.repository.BookingRepository;

public class MongoBookingRepository implements BookingRepository {

    private final MongoBookingInterface mongoInterface;

    @Autowired
    public MongoBookingRepository(MongoBookingInterface mongoBookingInterface) {
        this.mongoInterface = mongoBookingInterface;
    }

    @Override
    public Collection<BookingEntity> getAllByUser(String email) throws BookingException {
        return mongoInterface.findAllByEmail(email);
    }

    @Override
    public Optional<BookingEntity> getById(String bookingId) throws BookingException {
        return mongoInterface.findById(bookingId);
    }

    @Override
    public String saveNewBooking(BookingEntity newBooking) throws BookingException {
        return mongoInterface.save(newBooking).getId();
    }

    @Override
    public void deleteBooking(String bookingId) throws BookingException {
        mongoInterface.deleteById(bookingId);
    }
    
}
