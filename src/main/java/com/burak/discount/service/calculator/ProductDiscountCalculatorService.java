package com.burak.discount.service.calculator;

import com.burak.discount.entity.ProductCampaign;
import com.burak.discount.repository.ProductCampaignRepository;
import com.burak.discount.util.CalculatorUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductDiscountCalculatorService extends AbstractCalculator {

    private final ProductCampaignRepository productCampaignRepository;

    public ProductDiscountCalculatorService(ProductCampaignRepository productCampaignRepository, CalculatorUtil calculatorUtil) {
        super(calculatorUtil);
        this.productCampaignRepository = productCampaignRepository;
    }

    public BigDecimal calculateDiscount(BigDecimal price, Long productId) {
        ProductCampaign productCampaign = productCampaignRepository.findByProductId(productId);
        return getDiscountAmount(price, productCampaign);
    }
}
