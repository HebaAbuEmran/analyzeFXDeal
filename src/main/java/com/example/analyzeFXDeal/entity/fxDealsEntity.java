package com.example.analyzeFXDeal.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.time.LocalDateTime;


@Entity
@Table(name="fxdeals")
public class fxDealsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="id")
    private int id;

    @NotNull(message = "Deal Unique ID cannot be null")
    @Column(name="deal_Unique_Id")
    private int dealUniqueId;

    @NotBlank(message = "from Currency ISO Code cannot be null")
    @Size(min = 3, max = 3, message = "Currency ISO Code must be 3 characters")
    @Column(name="from_Currency_ISO_Code")
    private String fromCurrencyISOCode;

    @NotBlank(message = "to Currency ISO Code cannot be null")
    @Size(min = 3, max = 3, message = "Currency ISO Code must be 3 characters")
    @Column(name="to_Currency_ISO_Code")
    private String toCurrencyISOCode;

    @Column(name="deal_Timestamp")
    private LocalDateTime dealTimestamp;

    @Column(name="deal_Amount")
    private double dealAmount;


    public fxDealsEntity(int dealUniqueId, String fromCurrencyISOCode, String toCurrencyISOCode, LocalDateTime dealTimestamp, double dealAmount) {
        this.dealUniqueId = dealUniqueId;
        this.fromCurrencyISOCode = fromCurrencyISOCode;
        this.toCurrencyISOCode = toCurrencyISOCode;
        this.dealTimestamp = dealTimestamp;
        this.dealAmount = dealAmount;
    }
    public fxDealsEntity(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDealUniqueId() {
        return dealUniqueId;
    }

    public void setDealUniqueId(int dealUniqueId) {
        this.dealUniqueId = dealUniqueId;
    }

    public String getFromCurrencyISOCode() {
        return fromCurrencyISOCode;
    }

    public void setFromCurrencyISOCode(String fromCurrencyISOCode) {
        this.fromCurrencyISOCode = fromCurrencyISOCode;
    }

    public String getToCurrencyISOCode() {
        return toCurrencyISOCode;
    }

    public void setToCurrencyISOCode(String toCurrencyISOCode) {
        this.toCurrencyISOCode = toCurrencyISOCode;
    }

    public LocalDateTime getDealTimestamp() {
        return dealTimestamp;
    }

    public void setDealTimestamp(LocalDateTime dealTimestamp) {
        this.dealTimestamp = dealTimestamp;
    }

    public double getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(double dealAmount) {
        this.dealAmount = dealAmount;
    }

    @Override
    public String toString() {
        return "fxDealsEntity{" +
                "id=" + id +
                ", dealUniqueId=" + dealUniqueId +
                ", fromCurrencyISOCode='" + fromCurrencyISOCode + '\'' +
                ", toCurrencyISOCode='" + toCurrencyISOCode + '\'' +
                ", dealTimestamp=" + dealTimestamp +
                ", dealAmount=" + dealAmount +
                '}';
    }
}
