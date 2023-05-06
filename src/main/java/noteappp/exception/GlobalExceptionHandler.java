package noteappp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException ex) {
        log.error("Data not found :{}", ex.getMessage());
        ErrorDTO errorDTO = ErrorDTO.builder().statusCode(HttpStatus.NOT_FOUND.value()).message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

}
