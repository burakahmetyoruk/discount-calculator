package com.burak.discount.entity;

import com.burak.discount.model.DiscountType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by byoruk on 12.04.2018.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String campaignName;

    @Enumerated(EnumType.ORDINAL)
    private DiscountType discountType;

    private Integer discount;

    private Integer maxDiscountAmount;
}
