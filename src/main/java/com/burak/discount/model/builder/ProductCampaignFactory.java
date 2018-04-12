package com.burak.discount.model.builder;

import com.burak.discount.entity.Campaign;
import com.burak.discount.entity.CategoryCampaign;
import com.burak.discount.entity.ProductCampaign;
import com.burak.discount.model.builder.AbstractCampaignFactory;
import com.burak.discount.model.campaign.CampaignData;
import org.springframework.stereotype.Component;

/**
 * Created by byoruk on 12.04.2018.
 */
@Component
public class ProductCampaignFactory extends AbstractCampaignFactory {

    @Override
    public ProductCampaign makeCampaign(CampaignData campaignData) {
        ProductCampaign productCampaign = new ProductCampaign();

        if (campaignData.getId() != null) {
            productCampaign.setId(campaignData.getId());
        }
        productCampaign.setProductId(campaignData.getRelatedId());
        productCampaign.setProductName(campaignData.getRelatedName());
        productCampaign.setCampaignName(campaignData.getCampaignName());
        productCampaign.setDiscount(campaignData.getDiscount());
        productCampaign.setDiscountType(campaignData.getDiscountType());
        productCampaign.setMaxDiscountAmount(campaignData.getMaxDiscountAmount());
        return productCampaign;
    }
}
