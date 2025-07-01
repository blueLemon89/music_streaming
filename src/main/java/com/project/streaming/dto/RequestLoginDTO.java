package com.project.streaming.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestLoginDTO {
    private String username;
    private String password;
}
