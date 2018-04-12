package com.burak.discount.util;

import com.burak.discount.model.DiscountType;
import com.burak.discount.model.campaign.CampaignData;
import org.springframework.stereotype.Component;

/**
 * Created by byoruk on 12.04.2018.
 */
@Component
public class InputValidator {

    public boolean isInputValid(CampaignData campaignData) {

        DiscountType discountType = campaignData.getDiscountType();

        if (discountType == DiscountType.RATE) {
            return campaignData.getMaxDiscountAmount() != null && campaignData.getDiscount() <= 100;
        }
        return true;
    }
}
