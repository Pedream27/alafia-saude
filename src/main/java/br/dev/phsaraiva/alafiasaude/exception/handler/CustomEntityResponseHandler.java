package br.dev.phsaraiva.alafiasaude.exception.handler;

import br.dev.phsaraiva.alafiasaude.exception.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

   @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExcepitonResponse> handleAllExceptions(Exception ex, WebRequest request) {
        ExcepitonResponse response = new ExcepitonResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExcepitonResponse> handleBadRequiestException(Exception ex, WebRequest request) {
        ExcepitonResponse response = new ExcepitonResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public final ResponseEntity<ExcepitonResponse> FileNotFoundException(Exception ex, WebRequest request) {
        ExcepitonResponse response = new ExcepitonResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(FileStorageException.class)
    public final ResponseEntity<ExcepitonResponse> FileStorageException(Exception ex, WebRequest request) {
        ExcepitonResponse response = new ExcepitonResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ExcepitonResponse> handleRequireObjectException(Exception ex, WebRequest request) {
        ExcepitonResponse response = new ExcepitonResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }



}
