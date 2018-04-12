package com.burak.discount.service.calculator;

import com.burak.discount.entity.CategoryCampaign;
import com.burak.discount.repository.CategoryCampaignRepository;
import com.burak.discount.util.CalculatorUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by byoruk on 12.04.2018.
 */
@Service
public class CategoryDiscountCalculatorService extends AbstractCalculator {

    private final CategoryCampaignRepository categoryCampaignRepository;

    public CategoryDiscountCalculatorService(CalculatorUtil calculatorUtil, CategoryCampaignRepository categoryCampaignRepository) {
        super(calculatorUtil);
        this.categoryCampaignRepository = categoryCampaignRepository;
    }

    public BigDecimal calculateDiscount(BigDecimal price, Long categoryId) {
        CategoryCampaign categoryCampaign = categoryCampaignRepository.findByCategoryId(categoryId);
        return getDiscountAmount(price, categoryCampaign);
    }
}
