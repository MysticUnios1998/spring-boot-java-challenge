package booking.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import booking.exception.BookingException;
import booking.model.dto.BookingDto;
import booking.service.BookingService;
import booking.util.ServiceResponse;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse<Collection<BookingDto>>> getAllBookginsByUser(
        @RequestParam("user") String email
    ) throws BookingException {
        return ResponseEntity.ok().body(bookingService.getAllByUser(email));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse<BookingDto>> getById(
        @PathVariable("id") String bookingId
    ) throws BookingException {
        return ResponseEntity.ok().body(bookingService.getById(bookingId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse<String>> saveNewBooking(
        @RequestBody BookingDto newBooking
    ) throws BookingException {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.saveNewBooking(newBooking));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse<String>> modifyBooking(
        @RequestBody BookingDto booking,
        @PathVariable("id") String bookingId,
        @RequestParam(value="complete", required=false) boolean completeChange
    ) throws BookingException {
        return ResponseEntity.ok().body(bookingService.modifyBooking(bookingId, booking, completeChange));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse<BookingDto>> deleteBooking(
        @PathVariable("id") String bookingId
    ) throws BookingException {
        return ResponseEntity.ok().body(bookingService.deleteBooking(bookingId));
    }

    
}
