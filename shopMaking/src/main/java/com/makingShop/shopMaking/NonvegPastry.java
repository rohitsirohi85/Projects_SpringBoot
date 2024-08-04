package com.makingShop.shopMaking;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "Deciding.pastry" , havingValue = "Nonveg")
public class NonvegPastry implements PastryInterface {
    @Override
    public String getPastry(){
        return " egg-pastry ";
    }
}
