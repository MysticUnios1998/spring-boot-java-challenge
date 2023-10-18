package booking.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.NonFinal;

@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Booking {

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
