package com.burak.discount.service;

import com.burak.discount.entity.Campaign;
import com.burak.discount.entity.CategoryCampaign;
import com.burak.discount.entity.ProductCampaign;
import com.burak.discount.exception.InputValidationException;
import com.burak.discount.model.builder.ProductCampaignFactory;
import com.burak.discount.model.campaign.CampaignData;
import com.burak.discount.repository.ProductCampaignRepository;
import com.burak.discount.util.InputValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by byoruk on 12.04.2018.
 */
@Service
public class ProductCampaignService extends CampaignService {

    private final ProductCampaignRepository productCampaignRepository;
    private final ProductCampaignFactory productCampaignFactory;

    public ProductCampaignService(ProductCampaignRepository productCampaignRepository, ProductCampaignFactory productCampaignFactory, InputValidator inputValidator) {
        super(inputValidator);
        this.productCampaignRepository = productCampaignRepository;
        this.productCampaignFactory = productCampaignFactory;
    }

    public Campaign saveOrUpdateCampaign(CampaignData campaignData) throws InputValidationException {

        validateInput(campaignData);

        ProductCampaign campaign = productCampaignFactory.makeCampaign(campaignData);

        return productCampaignRepository.save(campaign);
    }

    public Campaign getCampaign(Long id) {
        Optional<ProductCampaign> campaign = productCampaignRepository.findById(id);

        return campaign.orElse(null);
    }

}
