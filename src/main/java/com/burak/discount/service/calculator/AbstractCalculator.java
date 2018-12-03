package com.burak.discount.service.calculator;

import com.burak.discount.entity.Campaign;
import com.burak.discount.model.DiscountType;
import com.burak.discount.util.CalculatorUtil;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by byoruk on 12.04.2018.
 */
@RequiredArgsConstructor
public abstract class AbstractCalculator {

    private final CalculatorUtil calculatorUtil;

    BigDecimal getDiscountAmount(BigDecimal price, Campaign campaign) {
        BigDecimal discountAmount = BigDecimal.ZERO;
        if (campaign != null) {
            if (campaign.getDiscountType() == DiscountType.PRICE) {
                discountAmount = BigDecimal.valueOf(campaign.getDiscount());
            } else {
                BigDecimal maxDiscount = BigDecimal.valueOf(campaign.getMaxDiscountAmount());
                //Calculate Discount Amount
                discountAmount = calculatorUtil.percentage(price,BigDecimal.valueOf(campaign.getDiscount()));
                //Max Discount Amount Control
                discountAmount = discountAmount.compareTo(maxDiscount) <= 0 ? discountAmount : maxDiscount;
            }
        }
        return discountAmount;
    }
}
