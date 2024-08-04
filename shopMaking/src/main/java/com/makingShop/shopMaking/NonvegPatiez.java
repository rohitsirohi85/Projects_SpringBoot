package com.makingShop.shopMaking;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "Deciding.patiez" , havingValue = "Nonveg")
public class NonvegPatiez implements PatiezInterface {
    @Override
    public String getPatiez(){
        return " egg-patiez ";
    }
}
