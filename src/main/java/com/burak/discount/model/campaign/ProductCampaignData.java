package com.burak.discount.model.campaign;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by byoruk on 12.04.2018.
 */
@Setter
@Getter
@NoArgsConstructor
public class ProductCampaignData extends CampaignData {

    @NotNull(message = "Product Id must not be empty")
    private Long productId;

    @NotBlank(message = "Product Name must not be empty")
    private String productName;

    @Override
    public Long getRelatedId() {
        return productId;
    }

    @Override
    public String getRelatedName() {
        return productName;
    }
}
