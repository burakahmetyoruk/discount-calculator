package com.burak.discount.service;

import com.burak.discount.entity.Campaign;
import com.burak.discount.entity.CategoryCampaign;
import com.burak.discount.exception.InputValidationException;
import com.burak.discount.model.builder.CategoryCampaignFactory;
import com.burak.discount.model.campaign.CampaignData;
import com.burak.discount.model.campaign.CategoryCampaignData;
import com.burak.discount.repository.CategoryCampaignRepository;
import com.burak.discount.util.InputValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by byoruk on 12.04.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoryCampaignServiceTest {

    @InjectMocks
    private CategoryCampaignService categoryCampaignService;

    @Mock
    private InputValidator inputValidator;

    @Mock
    private CategoryCampaignRepository categoryCampaignRepository;

    @Mock
    private CategoryCampaignFactory categoryCampaignFactory;


    @Test
    public void should_save_category_campaign_successfully() throws InputValidationException {

        CampaignData campaignData = new CategoryCampaignData();
        CategoryCampaign categoryCampaign = new CategoryCampaign();

        when(inputValidator.isInputValid(campaignData)).thenReturn(true);
        when(categoryCampaignFactory.makeCampaign(campaignData)).thenReturn(categoryCampaign);
        when(categoryCampaignRepository.save(categoryCampaign)).thenReturn(categoryCampaign);

        Campaign campaign = categoryCampaignService.saveOrUpdateCampaign(campaignData);

        assertNotNull(campaign);

        verify(categoryCampaignRepository,times(1)).save(categoryCampaign);
    }

    @Test(expected = InputValidationException.class)
    public void should_throw_input_validation_exception_when_input_invalid() throws InputValidationException {
        CampaignData campaignData = new CategoryCampaignData();

        when(inputValidator.isInputValid(campaignData)).thenReturn(false);

        categoryCampaignService.saveOrUpdateCampaign(campaignData);
    }

    @Test
    public void should_get_product_campaign_successfully() {
        long id = 1;

        CategoryCampaign categoryCampaign = new CategoryCampaign();

        when(categoryCampaignRepository.findById(id)).thenReturn(Optional.of(categoryCampaign));

        Campaign campaign = categoryCampaignService.getCampaign(id);

        assertNotNull(campaign);
    }

}