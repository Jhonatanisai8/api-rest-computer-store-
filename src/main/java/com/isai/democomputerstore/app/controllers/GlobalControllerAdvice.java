package com.isai.democomputerstore.app.controllers;

import com.isai.democomputerstore.app.exceptions.ErrorReponse;
import com.isai.democomputerstore.app.exceptions.MakerNotFoundException;
import com.isai.democomputerstore.app.exceptions.ProductNotFoundException;

import static com.isai.democomputerstore.app.utils.ErrorCatalog.*;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;


@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorReponse handlerExceptionProductNotFound() {
        return ErrorReponse.builder()
                .codeError(PRODUCT_NOT_FOUND.getCodeError())
                .statusHttpError(HttpStatus.NOT_FOUND)
                .messageError(PRODUCT_NOT_FOUND.getMessageError())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MakerNotFoundException.class)
    public ErrorReponse handlerExceptionMakerNotFound() {
        return ErrorReponse.builder()
                .codeError(MAKER_NOT_FOUND.getCodeError())
                .statusHttpError(HttpStatus.NOT_FOUND)
                .messageError(MAKER_NOT_FOUND.getMessageError())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorReponse handlerExceptionArgumentNotValid(MethodArgumentNotValidException argumentNotValidException) {
        BindingResult bindingResult = argumentNotValidException.getBindingResult();
        return ErrorReponse.builder()
                .codeError(INVALID_PRODUCT.getCodeError())
                .statusHttpError(HttpStatus.NOT_FOUND)
                .messageError(INVALID_PRODUCT.getMessageError())
                .detailsMessagesErrors(bindingResult.getAllErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorReponse handlerExceptionInternalServer(Exception exception) {
        return ErrorReponse.builder()
                .codeError(GENERIC_ERROR.getCodeError())
                .statusHttpError(HttpStatus.INTERNAL_SERVER_ERROR)
                .messageError(GENERIC_ERROR.getMessageError())
                .detailsMessagesErrors(Collections.singletonList(exception.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AccessDeniedException.class)
    public ErrorReponse handlerExceptionUnauthorized(Exception exception) {
        return ErrorReponse.builder()
                .codeError(UNAUTHORIZED_ERROR.getCodeError())
                .statusHttpError(HttpStatus.UNAUTHORIZED)
                .messageError(UNAUTHORIZED_ERROR.getMessageError())
                .detailsMessagesErrors(Collections.singletonList(exception.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }
}
