package com.burak.discount.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * Created by byoruk on 12.04.2018.
 */
@Getter
@Setter
@Entity
public class ProductCampaign extends Campaign {

    private String productName;

    private Long productId;
}
