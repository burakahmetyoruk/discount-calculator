package com.burak.discount.service.calculator;

import com.burak.discount.model.calculator.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DiscountCalculatorServiceTest {

    @InjectMocks
    private DiscountCalculatorService discountCalculatorService;

    @Mock
    private CategoryDiscountCalculatorService categoryDiscountCalculatorService;

    @Mock
    private ProductDiscountCalculatorService productDiscountCalculatorService;

    @Test
    public void should_calculate_item_discount_correctly() throws Exception {

        Long productId = 1L;
        Long categoryId = 2L;

        Item item = new Item();
        item.setProductId(productId);
        item.setCategoryId(categoryId);
        item.setPrice(BigDecimal.valueOf(100));

        when(productDiscountCalculatorService.calculateDiscount(item.getPrice(),productId)).thenReturn(BigDecimal.TEN);
        when(categoryDiscountCalculatorService.calculateDiscount(item.getPrice(),categoryId)).thenReturn(BigDecimal.TEN);

        Item item1 = discountCalculatorService.calculateItemDiscount(item, new HashMap<>());

        assertNotNull(item1);
        assertEquals(BigDecimal.valueOf(80),item1.getDiscountedPrice());
    }

    @Test
    public void should_not_apply_category_discount_to_item_when_category_discount_already_applied_other() throws Exception {
        Long productId = 1L;
        Long categoryId = 2L;

        Item item = new Item();
        item.setProductId(productId);
        item.setCategoryId(categoryId);
        item.setPrice(BigDecimal.valueOf(100));

        Map<Long, Boolean> categoryDiscountMap = new HashMap<>();
        categoryDiscountMap.put(categoryId, true);

        when(productDiscountCalculatorService.calculateDiscount(item.getPrice(),productId)).thenReturn(BigDecimal.TEN);

        Item item1 = discountCalculatorService.calculateItemDiscount(item, categoryDiscountMap);

        assertNotNull(item1);
        assertEquals(BigDecimal.valueOf(90),item1.getDiscountedPrice());
    }

}