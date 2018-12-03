package com.burak.discount.util;

import com.burak.discount.model.DiscountType;
import com.burak.discount.model.campaign.CampaignData;
import org.springframework.stereotype.Component;

/**
 * Created by byoruk on 12.04.2018.
 */
@Component
public class InputValidator {

    public static final int MAX_DISCOUNT = 100;

    public boolean isInputValid(CampaignData campaignData) {
        DiscountType discountType = campaignData.getDiscountType();
        return discountType != DiscountType.RATE || campaignData.getMaxDiscountAmount() != null && campaignData.getDiscount() <= MAX_DISCOUNT;
    }
}
