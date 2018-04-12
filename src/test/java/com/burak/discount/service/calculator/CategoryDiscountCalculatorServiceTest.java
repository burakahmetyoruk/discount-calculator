package com.burak.discount.service.calculator;

import com.burak.discount.entity.CategoryCampaign;
import com.burak.discount.model.DiscountType;
import com.burak.discount.repository.CategoryCampaignRepository;
import com.burak.discount.util.CalculatorUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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
public class CategoryDiscountCalculatorServiceTest {
    @InjectMocks
    private CategoryDiscountCalculatorService categoryDiscountCalculatorService;

    @Mock
    private CalculatorUtil calculatorUtil;

    @Mock
    private CategoryCampaignRepository categoryCampaignRepository;


    @Test
    public void should_calculate_discount_amount_correctly_for_discountType_price() throws Exception {

        Long categoryId = 1L;

        CategoryCampaign campaign = new CategoryCampaign();
        campaign.setDiscount(15);
        campaign.setDiscountType(DiscountType.PRICE);

        BigDecimal price = BigDecimal.valueOf(100);

        when(categoryCampaignRepository.findByCategoryId(categoryId)).thenReturn(campaign);

        BigDecimal result = categoryDiscountCalculatorService.calculateDiscount(price,categoryId );

        assertNotNull(result);
        assertEquals(BigDecimal.valueOf(15), result);
    }

    @Test
    public void should_calculate_discount_amount_correctly_for_discountType_rate() throws Exception {

        Long categoryId = 1L;

        CategoryCampaign campaign = new CategoryCampaign();
        campaign.setDiscount(20);
        campaign.setDiscountType(DiscountType.RATE);
        campaign.setMaxDiscountAmount(25);

        BigDecimal price = BigDecimal.valueOf(100);

        when(categoryCampaignRepository.findByCategoryId(categoryId)).thenReturn(campaign);
        when(calculatorUtil.percentage(price, BigDecimal.valueOf(20))).thenReturn(BigDecimal.valueOf(20));

        BigDecimal result = categoryDiscountCalculatorService.calculateDiscount(price, categoryId);

        assertNotNull(result);
        assertEquals(BigDecimal.valueOf(20), result);
    }

}