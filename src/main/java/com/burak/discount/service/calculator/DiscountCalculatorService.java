package com.burak.discount.service.calculator;

import com.burak.discount.model.calculator.BasketData;
import com.burak.discount.model.calculator.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by byoruk on 12.04.2018.
 */
@Service
@RequiredArgsConstructor
public class DiscountCalculatorService {

    private final ProductDiscountCalculatorService productDiscountCalculatorService;
    private final CategoryDiscountCalculatorService categoryDiscountCalculatorService;


    public BasketData calculateDiscount(BasketData basketData) {
        List<Item> itemList = basketData.getItemList();
        List<Item> discountedItemList = new ArrayList<>();

        Map<Long,Boolean> categoryDiscountMap = new HashMap<>();
        for (Item item : itemList) {
            Item item1 = calculateItemDiscount(item, categoryDiscountMap);

            discountedItemList.add(item1);
        }

        basketData.setItemList(discountedItemList);
        return basketData;

    }

    Item calculateItemDiscount(Item item, Map<Long,Boolean> categoryDiscountMap) {
        Long categoryId = item.getCategoryId();
        Long productId = item.getProductId();
        BigDecimal discountAmount;
        BigDecimal discountedAmount;

        discountAmount = productDiscountCalculatorService.calculateDiscount(item.getPrice(), productId);

        Boolean isApplied = categoryDiscountMap.get(categoryId);
        if (isApplied == null || !isApplied) {
            discountAmount = discountAmount.add(categoryDiscountCalculatorService.calculateDiscount(item.getPrice(), categoryId));
        }

        discountedAmount = item.getPrice().subtract(discountAmount);
        item.setDiscountedPrice(discountedAmount);
        return item;
    }
}
