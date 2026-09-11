package com.herenca.spring.heranca_spring.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

        var erros = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> Map.of(
                        "campo", fieldError.getField(),
                        "mensagem", fieldError.getDefaultMessage()
                ));

        return criarProblemDetail(HttpStatus.BAD_REQUEST, "Um ou mais campos inválidos",
                "Erro de validação", URI.create(request.getRequestURI()),
                URI.create("https://heranca.spring.erros"), erros);
    }


    public ProblemDetail criarProblemDetail(HttpStatusCode httpStatusCode,
                                            String detail, String title, URI instance,
                                            URI type, Object value) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                httpStatusCode,
                detail
        );
        problemDetail.setTitle(title);
        problemDetail.setInstance(instance);
        problemDetail.setType(type);
        problemDetail.setProperty("erros", value);
        return problemDetail;
    }

}
