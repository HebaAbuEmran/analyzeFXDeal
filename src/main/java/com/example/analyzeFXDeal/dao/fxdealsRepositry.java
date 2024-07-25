package com.example.analyzeFXDeal.dao;

import com.example.analyzeFXDeal.entity.fxDealsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface fxdealsRepositry extends JpaRepository<fxDealsEntity, Integer> {
    boolean existsByDealUniqueId(int dealUniqueId);
}
