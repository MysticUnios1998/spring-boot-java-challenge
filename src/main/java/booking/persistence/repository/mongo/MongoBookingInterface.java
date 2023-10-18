package booking.persistence.repository.mongo;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;

import booking.model.entity.mongo.BookingEntity;

public interface MongoBookingInterface extends MongoRepository<BookingEntity, String> {
    
    Collection<BookingEntity> findAllByEmail(String email);

}
