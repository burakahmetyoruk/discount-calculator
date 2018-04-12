package com.burak.discount.model.campaign;

import com.burak.discount.model.DiscountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by byoruk on 12.04.2018.
 */
@Getter
@Setter
@NoArgsConstructor
public abstract class CampaignData {

    private Long id;

    @NotBlank(message = "CampaignName must not be empty")
    private String campaignName;

    @NotNull
    private DiscountType discountType;

    @NotNull(message = "Discount must not be empty")
    private Integer discount;

    private Integer maxDiscountAmount;


    public abstract Long getRelatedId();
    public abstract String getRelatedName();

}
