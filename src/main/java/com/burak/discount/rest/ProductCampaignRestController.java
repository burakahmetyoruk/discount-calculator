package com.burak.discount.rest;

import com.burak.discount.entity.Campaign;
import com.burak.discount.exception.InputValidationException;
import com.burak.discount.model.campaign.ProductCampaignData;
import com.burak.discount.service.ProductCampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by byoruk on 12.04.2018.
 */
@RestController
@RequiredArgsConstructor
public class ProductCampaignRestController {

    private final ProductCampaignService productCampaignService;

    @PostMapping(value = "/add/product-campaign")
    public ResponseEntity<Campaign> addProductCampaign(@RequestBody @Valid ProductCampaignData productCampaign) {

        try {
            Campaign campaign = productCampaignService.saveOrUpdateCampaign(productCampaign);
            return ResponseEntity.ok(campaign);
        } catch (InputValidationException e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping(value = "/get/product-campaign/{id}")
    public ResponseEntity<Campaign> getProductCampaign(@PathVariable("id") Long id) {
            Campaign campaign = productCampaignService.getCampaign(id);

            return ResponseEntity.ok(campaign);

    }

    @PutMapping(value = "/update/product-campaign")
    public ResponseEntity<Campaign> updateProductCampaign(@RequestBody @Valid ProductCampaignData productCampaignData) {
        try {
            Campaign campaign = productCampaignService.saveOrUpdateCampaign(productCampaignData);
            return ResponseEntity.ok(campaign);
        } catch (InputValidationException e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping(value = "/delete")
    public void deleteCampaign() {

    }
}
