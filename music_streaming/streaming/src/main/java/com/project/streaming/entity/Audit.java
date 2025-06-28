package com.project.streaming.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Audit {
    String createdAt;
    String createdBy;
    String updatedAt;
    String updatedBy;
}
