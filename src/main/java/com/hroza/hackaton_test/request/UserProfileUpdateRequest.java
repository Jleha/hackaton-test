package com.hroza.hackaton_test.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserProfileUpdateRequest {
    private String username;
    private String email;

}
