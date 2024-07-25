package com.example.analyzeFXDeal.service;


import com.example.analyzeFXDeal.dao.fxdealsRepositry;
import com.example.analyzeFXDeal.entity.fxDealsEntity;
import com.example.analyzeFXDeal.handelException.FxDealSameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FXDealServiceImp implements FxDealService {

    private fxdealsRepositry fxdealsRepositry;

    @Autowired
    public FXDealServiceImp(fxdealsRepositry fxdealsRepositry){
        this.fxdealsRepositry=fxdealsRepositry;
    }
    @Override
    public fxDealsEntity addFXDeal(fxDealsEntity fxdeal) {
        if(fxdealsRepositry.existsByDealUniqueId(fxdeal.getDealUniqueId())){
            throw new FxDealSameRequest("fx deal has same request twice" + fxdeal.getDealUniqueId() );
        }

        return fxdealsRepositry.save(fxdeal);
    }
}
