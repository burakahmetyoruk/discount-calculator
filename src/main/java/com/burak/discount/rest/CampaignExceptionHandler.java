package com.burak.discount.rest;

import com.burak.discount.entity.Campaign;
import com.burak.discount.exception.InputValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by byoruk on 12.04.2018.
 */
@ControllerAdvice(annotations = RestController.class)
public class CampaignExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InputValidationException.class)
    public String handleInputValidationException(final InputValidationException e) {
        return e.getMessage();
    }
}
