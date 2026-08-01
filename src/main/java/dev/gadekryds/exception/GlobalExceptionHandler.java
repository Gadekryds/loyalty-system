package dev.gadekryds.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ProblemDetail handleException(Exception ex) {
        var problem = ProblemDetail
                .forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
                        ex.getMessage());
        problem.setTitle("Unhandled exception");
        return problem;
    }

    @ExceptionHandler(exception = InvalidInputException.class)
    public ProblemDetail handleInvalidInputException(InvalidInputException ex) {
        var problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );
        problem.setTitle("Invalid input");
        return problem;
    }
}
