package com.makingShop.shopMaking;

import org.springframework.stereotype.Component;

@Component
public class configuringItems {
    private final PastryInterface pst;
    private final PatiezInterface ptz;

    public configuringItems(PastryInterface pst , PatiezInterface ptz){
        this.pst=pst;
        this.ptz=ptz;
    }

    public String deciding(){
        return (" i am deciding to bought :" + pst.getPastry() + " and "+ ptz.getPatiez());
    }
}
