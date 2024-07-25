package com.example.analyzeFXDeal;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.example.analyzeFXDeal.entity.fxDealsEntity;
import com.example.analyzeFXDeal.rest.FXDealController;

import com.example.analyzeFXDeal.service.FXDealServiceImp;
import com.example.analyzeFXDeal.service.FxDealService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.ResourceUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class FxDealControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private FXDealServiceImp fxDealService;

    @InjectMocks
    private FXDealController fxDealController;

    private fxDealsEntity fxDeal;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(fxDealController).build();
    }

    @Test
    void ImportFxDeal_ShouldReturnSavedDeal_WhenValidRequest() throws Exception {
        Path dealPath = ResourceUtils.getFile("classpath:fxDeal.json").toPath();
        String dealJson = new String(Files.readAllBytes(dealPath));

        fxDealsEntity savedDeal = new fxDealsEntity();

        when(fxDealService.addFXDeal(any(fxDealsEntity.class))).thenReturn(savedDeal);
        mockMvc.perform(post("/api/add/fxdeal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dealJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dealUniqueId").value(savedDeal.getDealUniqueId()));

        verify(fxDealService, times(1)).addFXDeal(any(fxDealsEntity.class));
    }


}

