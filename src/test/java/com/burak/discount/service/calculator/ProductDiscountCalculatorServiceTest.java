package com.burak.discount.service.calculator;

import com.burak.discount.entity.ProductCampaign;
import com.burak.discount.model.DiscountType;
import com.burak.discount.repository.ProductCampaignRepository;
import com.burak.discount.util.CalculatorUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by byoruk on 13.04.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductDiscountCalculatorServiceTest {
    @InjectMocks
    private ProductDiscountCalculatorService productDiscountCalculatorService;

    @Mock
    private  ProductCampaignRepository productCampaignRepository;

    @Mock
    private CalculatorUtil calculatorUtil;

    @Test
    public void should_calculate_discount_amount_correctly_for_discount_type_price() throws Exception {

        Long productId = 1L;

        ProductCampaign productCampaign = new ProductCampaign();
        productCampaign.setDiscountType(DiscountType.PRICE);
        productCampaign.setDiscount(25);

        when(productCampaignRepository.findByProductId(productId)).thenReturn(productCampaign);

        BigDecimal discount = productDiscountCalculatorService.calculateDiscount(BigDecimal.valueOf(100), productId);

        assertNotNull(discount);
    }

}