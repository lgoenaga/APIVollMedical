package med.voll.api.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class TracerExceptions {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> entity404NotFound() {
        return ResponseEntity.status(404).body("Entity not found");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> illegalArgument(MethodArgumentNotValidException e) {
        
        var errors = e.getFieldErrors().stream().map(error -> error.getField() + ": " + error.getDefaultMessage()).reduce("", (a, b) -> a + "\n" + b);

        return ResponseEntity.status(406).body("Illegal argumentation's\n"+errors);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> dataIntegrityViolation(DataIntegrityViolationException e) {
        return ResponseEntity.status(409).body("Data integrity violation\n"+ e.getMostSpecificCause()+"\n");
    }

}
