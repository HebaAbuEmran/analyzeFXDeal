package com.example.analyzeFXDeal;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.analyzeFXDeal.entity.fxDealsEntity;
import com.example.analyzeFXDeal.handelException.FxDealSameRequest;
import com.example.analyzeFXDeal.service.FXDealServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;
import com.example.analyzeFXDeal.dao.fxdealsRepositry;

public class FxDealserviceTest {
    @Mock
    private fxdealsRepositry fxdealsRepositry;

    @InjectMocks
    private FXDealServiceImp fxDealService;

    private fxDealsEntity fxDeal;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        fxDeal = new fxDealsEntity(123, "USD", "EUR", LocalDateTime.now(), 1000.00);
    }

    @Test
    void testAddFXDeal_Success() {
        when(fxdealsRepositry.existsByDealUniqueId(fxDeal.getDealUniqueId())).thenReturn(false);
        when(fxdealsRepositry.save(fxDeal)).thenReturn(fxDeal);

        fxDealsEntity savedDeal = fxDealService.addFXDeal(fxDeal);

assertEquals(fxDeal.getDealUniqueId(), savedDeal.getDealUniqueId());
        }

@Test
void testAddFXDeal_Failure_DuplicateDeal() {
    when(fxdealsRepositry.existsByDealUniqueId(fxDeal.getDealUniqueId())).thenReturn(true);

    assertThrows(FxDealSameRequest.class, () -> fxDealService.addFXDeal(fxDeal));
}
}
