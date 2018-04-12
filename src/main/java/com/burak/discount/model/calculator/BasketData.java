package com.burak.discount.model.calculator;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by byoruk on 12.04.2018.
 */
@Getter
@Setter
public class BasketData {

    @JsonProperty(value = "items")
    private List<Item> itemList;
}
