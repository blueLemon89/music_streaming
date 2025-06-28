package com.project.streaming.entity;

import com.project.streaming.config.AuditListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@MappedSuperclass
@EntityListeners(AuditListener.class)
public class Audit {
    @Column(name = "created_at")
    String createdAt;
    @Column(name = "created_by")
    String createdBy;
    @Column(name = "updated_at")
    String updatedAt;
    @Column(name = "updated_by")
    String updatedBy;
}
