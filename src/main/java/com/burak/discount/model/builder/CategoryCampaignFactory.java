package com.burak.discount.model.builder;

import com.burak.discount.entity.CategoryCampaign;
import com.burak.discount.model.campaign.CampaignData;
import org.springframework.stereotype.Component;

/**
 * Created by byoruk on 12.04.2018.
 */
@Component
public class CategoryCampaignFactory extends AbstractCampaignFactory {

    @Override
    public CategoryCampaign makeCampaign(CampaignData campaignData)
    {
        CategoryCampaign categoryCampaign = new CategoryCampaign();

        if (campaignData.getId() != null) {
            categoryCampaign.setId(campaignData.getId());
        }
        categoryCampaign.setCategoryId(campaignData.getRelatedId());
        categoryCampaign.setCategoryName(campaignData.getRelatedName());
        categoryCampaign.setCampaignName(campaignData.getCampaignName());
        categoryCampaign.setDiscount(campaignData.getDiscount());
        categoryCampaign.setDiscountType(campaignData.getDiscountType());
        categoryCampaign.setMaxDiscountAmount(campaignData.getMaxDiscountAmount());
        return categoryCampaign;
    }
}
