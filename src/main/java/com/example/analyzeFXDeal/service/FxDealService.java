package com.example.analyzeFXDeal.service;

import com.example.analyzeFXDeal.entity.fxDealsEntity;
import org.springframework.stereotype.Service;

@Service
public interface FxDealService {

     fxDealsEntity addFXDeal(fxDealsEntity fxdeal);
}
