package com.burak.discount.service.campaign;

import com.burak.discount.exception.InputValidationException;
import com.burak.discount.model.campaign.CampaignData;
import com.burak.discount.util.InputValidator;
import lombok.RequiredArgsConstructor;

/**
 * Created by byoruk on 12.04.2018.
 */
@RequiredArgsConstructor
abstract class CampaignService {

    private final InputValidator inputValidator;

    void validateInput(CampaignData campaignData) throws InputValidationException {
        if (!inputValidator.isInputValid(campaignData)) {
            throw new InputValidationException("Input Not Valid For Rate Campaign!");
        }
    }
}
