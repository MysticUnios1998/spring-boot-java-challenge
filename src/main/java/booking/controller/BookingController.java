package booking.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import booking.model.dto.BookingDto;
import booking.util.ServiceResponse;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse<BookingDto>> getAllBookginsByUser(
        @RequestParam("user") String email
    ) {
        return null;
    }
    
}
