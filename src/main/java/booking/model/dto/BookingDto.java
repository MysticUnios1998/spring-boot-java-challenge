package booking.model.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingDto {
    
    private String id;
    private String name;
    private String email;
    private String origin;
    private String destination;
    private LocalDateTime departure;
    private String duration;

}
