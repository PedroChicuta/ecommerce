package com.compassUol.e_commerce.dto;

import com.compassUol.e_commerce.entities.Enums.SaleStatus;
import com.compassUol.e_commerce.entities.Sale;

import java.time.Instant;

public class SaleDTO {
    private Instant lastUpdate;
    private SaleStatus status;

    public SaleDTO(Instant lastUpdate, SaleStatus status){
        this.lastUpdate = lastUpdate;
        this.status = status;
    }

    public SaleDTO(Sale sale){
        lastUpdate = sale.getLastUpdate();
        status = sale.getStatus();
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public void setStatus(SaleStatus status) {
        this.status = status;
    }
}
