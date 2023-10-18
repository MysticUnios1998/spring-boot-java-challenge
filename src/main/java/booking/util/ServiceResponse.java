package booking.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ServiceResponse <T> {
    
    private String code;
    private String errorMessage;
    private T response;

}
