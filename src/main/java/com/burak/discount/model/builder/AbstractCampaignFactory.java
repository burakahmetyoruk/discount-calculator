package com.burak.discount.model.builder;

import com.burak.discount.entity.Campaign;
import com.burak.discount.model.campaign.CampaignData;

/**
 * Created by byoruk on 12.04.2018.
 */
public abstract class AbstractCampaignFactory {

    public abstract Campaign makeCampaign(CampaignData campaignData);
}
