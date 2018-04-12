package com.burak.discount.repository;

import com.burak.discount.entity.Campaign;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by byoruk on 12.04.2018.
 */
@NoRepositoryBean
public interface CampaignRepository<T extends Campaign> extends CrudRepository<T,Long> {

}
