package com.herenca.spring.heranca_spring.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.util.Map;
@RestControllerAdvice
public class ApiGlobalExceptionHandler {

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
        public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
                HttpServletRequest request) {

//        var erros = ex.getBindingResult().
//                        getFieldErrors().
//                        stream().
//                        map(error -> new FieldErrorResponse()

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                        HttpStatus.BAD_REQUEST,
                    "Um ou mais campos inválidos"
        );
          problemDetail.setTitle("Erro de validação");
          problemDetail.setInstance(URI.create(request.getRequestURI()));
          problemDetail.setType(URI.create("https://heranca.spring.erros"));
          var erros = ex.getBindingResult().getFieldErrors().stream()
                  .map(fieldError -> Map.of(
                       "campo", fieldError.getField(),
                       "mensagem", fieldError.getDefaultMessage()
                  ));
        problemDetail.setProperty("erros", erros);
        return problemDetail;
        }

}
