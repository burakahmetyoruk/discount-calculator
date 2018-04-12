package com.burak.discount.service;

import com.burak.discount.entity.Campaign;
import com.burak.discount.entity.ProductCampaign;
import com.burak.discount.exception.InputValidationException;
import com.burak.discount.model.builder.ProductCampaignFactory;
import com.burak.discount.model.campaign.CampaignData;
import com.burak.discount.model.campaign.ProductCampaignData;
import com.burak.discount.repository.ProductCampaignRepository;
import com.burak.discount.service.campaign.ProductCampaignService;
import com.burak.discount.util.InputValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Created by byoruk on 12.04.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductCampaignServiceTest {

    @InjectMocks
    private ProductCampaignService productCampaignService;

    @Mock
    private ProductCampaignRepository productCampaignRepository;

    @Mock
    private  InputValidator inputValidator;

    @Mock
    private ProductCampaignFactory productCampaignFactory;

    @Test
    public void should_save_product_campaign_successfully() throws InputValidationException {

        CampaignData campaignData = new ProductCampaignData();
        ProductCampaign productCampaign = new ProductCampaign();

        when(inputValidator.isInputValid(campaignData)).thenReturn(true);
        when(productCampaignFactory.makeCampaign(campaignData)).thenReturn(productCampaign);
        when(productCampaignRepository.save(productCampaign)).thenReturn(productCampaign);

        Campaign campaign = productCampaignService.saveOrUpdateCampaign(campaignData);

        assertNotNull(campaign);

        verify(productCampaignRepository,times(1)).save(productCampaign);
    }

    @Test(expected = InputValidationException.class)
    public void should_throw_input_validation_exception_when_input_invalid() throws InputValidationException {

        CampaignData campaignData = new ProductCampaignData();

        when(inputValidator.isInputValid(campaignData)).thenReturn(false);

        productCampaignService.saveOrUpdateCampaign(campaignData);

    }

    @Test
    public void should_get_product_campaign_successfully() {
        long id  = 1;
        ProductCampaign productCampaign = new ProductCampaign();

        when(productCampaignRepository.findById(id)).thenReturn(Optional.of(productCampaign));

        Campaign campaign = productCampaignService.getCampaign(id);

        assertNotNull(campaign);

    }

}