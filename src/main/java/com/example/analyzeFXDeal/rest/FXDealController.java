package com.example.analyzeFXDeal.rest;

import com.example.analyzeFXDeal.entity.fxDealsEntity;
import com.example.analyzeFXDeal.service.FxDealService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FXDealController {
    private static final Logger logger = LoggerFactory.getLogger(FXDealController.class);
    private FxDealService fxDealService;

    @Autowired
    public FXDealController(FxDealService fxDealService){
        this.fxDealService=fxDealService;
    }
    @PostMapping("/add/fxdeal")
    public ResponseEntity<fxDealsEntity> ImportFxDeal(@Valid @RequestBody fxDealsEntity fxdeal){
        logger.info("Received request to import FX deal with unique ID{}  ", fxdeal.getDealUniqueId());

        fxDealsEntity SavedDeal= fxDealService.addFXDeal(fxdeal);
        logger.info("Successfully saved FX deal with unique ID {} ", SavedDeal.getDealUniqueId());
        return  ResponseEntity.ok(SavedDeal);
    }

}
