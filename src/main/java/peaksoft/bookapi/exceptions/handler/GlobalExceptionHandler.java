package peaksoft.bookapi.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import peaksoft.bookapi.exceptions.BookNotFoundException;
import peaksoft.bookapi.exceptions.ExceptionResponse;
import peaksoft.bookapi.models.Book;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //500
    //400
    //401
    //403
    //404
    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleBookNotFoundException(BookNotFoundException e){
        return new ExceptionResponse(
                HttpStatus.NOT_FOUND,
                e.getClass().getSimpleName(),
                e.getMessage()
        );
    }

    //405


}
