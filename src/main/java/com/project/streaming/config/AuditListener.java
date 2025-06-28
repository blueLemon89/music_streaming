package com.project.streaming.config;

import com.project.streaming.constant.AuditConstant;
import com.project.streaming.constant.DateTimeFormat;
import com.project.streaming.entity.Audit;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditListener {

    private static String ADMIN = AuditConstant.ADMIN.name();
    private static DateTimeFormatter ddMMyyyy = DateTimeFormat.ddMMyyyy.getFormatter();

    @PrePersist
    public void setAuditFiledsCreated(Object entity) {
        if(entity instanceof Audit audit) {
            audit.setCreatedAt(LocalDateTime.now().format(ddMMyyyy));
            audit.setUpdatedAt(LocalDateTime.now().format(ddMMyyyy));
            audit.setCreatedBy(ADMIN);
            audit.setUpdatedBy(ADMIN);
        }
    }

    @PreUpdate
    public void setAuditFieldUpdated(Object entity) {
        if (entity instanceof Audit audit) {
            audit.setUpdatedAt(LocalDateTime.now().format(ddMMyyyy));
            audit.setUpdatedBy("system");
        }
    }
}


