package com.deltatech.Deltatech_EMS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidErrorResponse {
    private String field;
    private String errorMessage;
}
