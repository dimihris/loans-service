package com.dimihris.loansservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class LoanDto {

    private String mobileNumber;

    private String loanNumber;

    private String loanType;

    private Integer totalLoan;

    private Integer paidAmount;

    private Integer outstandingAmount;
}
