package com.burak.discount.service.campaign;

import com.burak.discount.entity.Campaign;
import com.burak.discount.entity.CategoryCampaign;
import com.burak.discount.exception.InputValidationException;
import com.burak.discount.model.builder.CategoryCampaignFactory;
import com.burak.discount.model.campaign.CampaignData;
import com.burak.discount.repository.CategoryCampaignRepository;
import com.burak.discount.util.InputValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by byoruk on 12.04.2018.
 */
@Service
public class CategoryCampaignService extends CampaignService {

    private final CategoryCampaignRepository categoryCampaignRepository;
    private final CategoryCampaignFactory categoryCampaignFactory;

    public CategoryCampaignService(CategoryCampaignRepository categoryCampaignRepository, CategoryCampaignFactory categoryCampaignFactory, InputValidator inputValidator) {
        super(inputValidator);
        this.categoryCampaignFactory = categoryCampaignFactory;
        this.categoryCampaignRepository = categoryCampaignRepository;
    }

    public Campaign saveOrUpdateCampaign(CampaignData campaignData) throws InputValidationException {

        validateInput(campaignData);

        CategoryCampaign campaign = categoryCampaignFactory.makeCampaign(campaignData);

        return categoryCampaignRepository.save(campaign);
    }

    public Campaign getCampaign(Long id) {
        Optional<CategoryCampaign> campaign = categoryCampaignRepository.findById(id);

        return campaign.orElse(null);
    }

}
