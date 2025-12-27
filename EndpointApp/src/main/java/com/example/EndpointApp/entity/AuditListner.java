package com.example.EndpointApp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class AuditListner {
    @PrePersist
    public void setCreatedAt(Product product) {
        product.setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void setUpdatedAt(Product product) {
        product.setUpdatedAt(LocalDateTime.now());
    }

}
