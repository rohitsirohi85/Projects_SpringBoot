package com.makingShop.shopMaking;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
// import org.springframework.context.annotation.Primary;  // when we want to use @primary
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "Deciding.patiez" , havingValue = "Veg")

public class VegPatiez implements PatiezInterface {
    @Override
    public String getPatiez(){
        return " egg-less patiez";
    }
}
