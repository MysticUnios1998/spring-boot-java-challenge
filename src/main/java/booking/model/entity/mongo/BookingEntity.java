package booking.model.entity.mongo;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.NonFinal;

@Getter
@AllArgsConstructor
@Document(collection="bookings")
public class BookingEntity {

    @Id
    private String id;

    private String name;
    private String email;

    @NonNull
    private String origin;

    @NonNull
    private String destination;

    @NonNull
    private LocalDateTime departure;

    @NonFinal
    private String duration;
    
}
