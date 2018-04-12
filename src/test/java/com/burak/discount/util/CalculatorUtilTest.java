package com.burak.discount.util;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by byoruk on 13.04.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class CalculatorUtilTest {

    private CalculatorUtil calculatorUtil;

    @Before
    public void setup() {
        calculatorUtil = new CalculatorUtil();
    }

    @Test
    public void should_calculate_percentage_successfully() throws Exception {

        BigDecimal base = BigDecimal.valueOf(100);
        BigDecimal pct = BigDecimal.TEN;

        BigDecimal result = calculatorUtil.percentage(base, pct);

        assertNotNull(result);
        assertEquals(BigDecimal.TEN, result);
    }

}