package com.burak.discount.service.calculator;

import com.burak.discount.entity.Campaign;
import com.burak.discount.entity.ProductCampaign;
import com.burak.discount.model.DiscountType;
import com.burak.discount.repository.ProductCampaignRepository;
import com.burak.discount.util.CalculatorUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by byoruk on 13.04.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class AbstractCalculatorTest {

    private AbstractCalculator abstractCalculator;

    @Mock
    private ProductCampaignRepository productCampaignRepository;

    @Mock
    private CalculatorUtil calculatorUtil;

    @Before
    public void setup() {
        abstractCalculator = new ProductDiscountCalculatorService(productCampaignRepository, calculatorUtil);
    }


    @Test
    public void should_calculate_discount_amount_correctly_for_discountType_price() throws Exception {

        Campaign campaign = new ProductCampaign();
        campaign.setDiscount(15);
        campaign.setDiscountType(DiscountType.PRICE);

        BigDecimal price = BigDecimal.valueOf(100);

        BigDecimal result = abstractCalculator.getDiscountAmount(price, campaign);

        assertNotNull(result);
        assertEquals(BigDecimal.valueOf(15), result);
    }

    @Test
    public void should_calculate_discount_amount_correctly_for_discountType_rate() throws Exception {

        Campaign campaign = new ProductCampaign();
        campaign.setDiscount(20);
        campaign.setDiscountType(DiscountType.RATE);
        campaign.setMaxDiscountAmount(25);

        BigDecimal price = BigDecimal.valueOf(100);

        when(calculatorUtil.percentage(price, BigDecimal.valueOf(20))).thenReturn(BigDecimal.valueOf(20));

        BigDecimal result = abstractCalculator.getDiscountAmount(price, campaign);

        assertNotNull(result);
        assertEquals(BigDecimal.valueOf(20), result);
    }

    @Test
    public void should_get_max_discount_amount_when_rate_discount_price_is_bigger_than_for_discountType_rate() throws Exception {

        Campaign campaign = new ProductCampaign();
        campaign.setDiscount(20);
        campaign.setDiscountType(DiscountType.RATE);
        campaign.setMaxDiscountAmount(10);

        BigDecimal price = BigDecimal.valueOf(100);

        when(calculatorUtil.percentage(price, BigDecimal.valueOf(20))).thenReturn(BigDecimal.valueOf(20));

        BigDecimal result = abstractCalculator.getDiscountAmount(price, campaign);

        assertNotNull(result);
        assertEquals(BigDecimal.valueOf(10), result);
    }

}