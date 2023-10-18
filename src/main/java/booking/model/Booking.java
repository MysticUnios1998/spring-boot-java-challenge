package booking.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.NonFinal;

@Getter
@ToString
@RequiredArgsConstructor
public class Booking {

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
