package com.burak.discount.util;

import com.burak.discount.model.DiscountType;
import com.burak.discount.model.campaign.CampaignData;
import com.burak.discount.model.campaign.ProductCampaignData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by byoruk on 12.04.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class InputValidatorTest {

    private InputValidator inputValidator;


    @Before
    public void setup() {
        inputValidator = new InputValidator();
    }
    @Test
    public void should_input_valid_when_discount_smaller_than_100_and_max_discount_amount_is_not_null() throws Exception {

        CampaignData campaignData = new ProductCampaignData();
        campaignData.setDiscountType(DiscountType.RATE);
        campaignData.setDiscount(100);
        campaignData.setMaxDiscountAmount(125);

        boolean result = inputValidator.isInputValid(campaignData);

        assertTrue(result);
    }

    @Test
    public void should_input_valid_max_discount_amount_is__null_with_discount_type_price() throws Exception {

        CampaignData campaignData = new ProductCampaignData();
        campaignData.setDiscountType(DiscountType.PRICE);
        campaignData.setDiscount(100);

        boolean result = inputValidator.isInputValid(campaignData);

        assertTrue(result);
    }

    @Test
    public void should_input__not_valid_max_discount_amount_is__null_with_discount_type_rate() throws Exception {

        CampaignData campaignData = new ProductCampaignData();
        campaignData.setDiscountType(DiscountType.RATE);
        campaignData.setDiscount(100);

        boolean result = inputValidator.isInputValid(campaignData);

        assertFalse(result);
    }

}