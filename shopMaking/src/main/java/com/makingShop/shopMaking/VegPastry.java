package com.makingShop.shopMaking;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
// import org.springframework.context.annotation.Primary;  // when we want to use @primary
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "Deciding.pastry" , havingValue = "Veg")
public class VegPastry implements PastryInterface{
    @Override
    public String getPastry(){
        return "egg-less pastry";
    }
}
