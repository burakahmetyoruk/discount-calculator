package com.burak.discount.rest;

import com.burak.discount.entity.Campaign;
import com.burak.discount.exception.InputValidationException;
import com.burak.discount.model.campaign.CategoryCampaignData;
import com.burak.discount.service.campaign.CategoryCampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by byoruk on 12.04.2018.
 */
@RestController
@RequiredArgsConstructor
public class CategoryCampaignRestController {

    private final CategoryCampaignService categoryCampaignService;

    @PutMapping(value = "/category-campaign")
    public ResponseEntity<Campaign> updateCategoryCampaign(@RequestBody @Valid CategoryCampaignData categoryCampaignData) throws InputValidationException {
        Campaign campaign = categoryCampaignService.saveOrUpdateCampaign(categoryCampaignData);
        return ResponseEntity.ok(campaign);
    }

    @PostMapping(value = "/category-campaign")
    public ResponseEntity<Campaign> addCategoryCampaign(@RequestBody @Valid CategoryCampaignData categoryCampaign) throws InputValidationException {
        Campaign campaign =  categoryCampaignService.saveOrUpdateCampaign(categoryCampaign);
        return ResponseEntity.ok(campaign);
    }

    @GetMapping(value = "/category-campaign/{id}")
    public ResponseEntity<Campaign> getCategoryCampaign(@PathVariable("id") Long id) {
        Campaign campaign = categoryCampaignService.getCampaign(id);
        return ResponseEntity.ok(campaign);
    }
}
