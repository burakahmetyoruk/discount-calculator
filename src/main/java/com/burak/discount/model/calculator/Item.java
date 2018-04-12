package com.burak.discount.model.calculator;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by byoruk on 12.04.2018.
 */
@Getter
@Setter
public class Item {

    private Long productId;
    private Long categoryId;
    private BigDecimal price;
    private BigDecimal discountedPrice;
}
