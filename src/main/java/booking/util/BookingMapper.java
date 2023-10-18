package booking.util;

import org.springframework.stereotype.Component;

import booking.model.Booking;
import booking.model.dto.BookingDto;
import booking.model.entity.mongo.BookingEntity;

@Component
public class BookingMapper {

    public BookingDto toBookingDto(Booking booking) {
        return BookingDto.builder()
            .id(booking.getId())
            .name(null)
            .email(booking.getEmail())
            .origin(booking.getOrigin())
            .destination(booking.getDestination())
            .departure(booking.getDeparture())
            .duration(booking.getDuration())
            .build();
    }

    public BookingDto toBookingDto(BookingEntity bookingEntity) {
        return BookingDto.builder()
            .id(bookingEntity.getId())
            .name(bookingEntity.getName())
            .email(bookingEntity.getEmail())
            .origin(bookingEntity.getOrigin())
            .destination(bookingEntity.getDestination())
            .departure(bookingEntity.getDeparture())
            .duration(bookingEntity.getDuration())
            .build();
    }

    public Booking toBooking(BookingDto bookingDto) {
        return new Booking(
            bookingDto.getId(),
            bookingDto.getName(),
            bookingDto.getEmail(),
            bookingDto.getOrigin(),
            bookingDto.getDestination(),
            bookingDto.getDeparture(),
            bookingDto.getDuration()
        );
    }

    public BookingEntity toBookingEntity(BookingDto bookingDto) {
        return new BookingEntity(
            bookingDto.getId(),
            bookingDto.getName(),
            bookingDto.getEmail(),
            bookingDto.getOrigin(),
            bookingDto.getDestination(),
            bookingDto.getDeparture(),
            bookingDto.getDuration()
        );
    }
    
}
