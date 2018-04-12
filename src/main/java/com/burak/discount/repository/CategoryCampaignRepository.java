package com.burak.discount.repository;

import com.burak.discount.entity.CategoryCampaign;

/**
 * Created by byoruk on 12.04.2018.
 */
public interface CategoryCampaignRepository extends CampaignRepository<CategoryCampaign>{

    CategoryCampaign findByCategoryId(Long categoryId);
}
