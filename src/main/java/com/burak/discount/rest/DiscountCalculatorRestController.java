package com.burak.discount.rest;

import com.burak.discount.model.calculator.BasketData;
import com.burak.discount.service.calculator.DiscountCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by byoruk on 12.04.2018.
 */
@RestController
@RequiredArgsConstructor
public class DiscountCalculatorRestController {

    private final DiscountCalculatorService discountCalculatorService;

    @PostMapping(value = "/calculate-discount")
    public ResponseEntity<BasketData> calculateDiscount(@RequestBody @Valid BasketData basketData) {
        BasketData result = discountCalculatorService.calculateDiscount(basketData);
        return ResponseEntity.ok(result);
    }
}
