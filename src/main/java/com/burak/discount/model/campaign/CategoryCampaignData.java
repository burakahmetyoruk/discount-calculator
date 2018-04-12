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
public class CategoryCampaignData extends CampaignData {

    @NotNull(message = "Category Id must not be empty")
    private Long categoryId;

    @NotBlank(message = "Category Name must not be empty")
    private String categoryName;

    @Override
    public Long getRelatedId() {
        return categoryId;
    }

    @Override
    public String getRelatedName() {
        return categoryName;
    }
}
