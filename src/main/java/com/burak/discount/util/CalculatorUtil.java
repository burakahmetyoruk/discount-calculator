package com.burak.discount.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by byoruk on 12.04.2018.
 */
@Component
public class CalculatorUtil {

    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    public  BigDecimal percentage(BigDecimal base, BigDecimal pct){
        return base.multiply(pct).divide(ONE_HUNDRED);
    }
}
