package com.isai.democomputerstore.app.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List; 

@Getter
@Setter
@Builder
public class ErrorReponse {

    private String codeError;
    private HttpStatus statusHttpError;
    private String messageError;
    private List<String> detailsMessagesErrors;
    private LocalDateTime timestamp;
}

