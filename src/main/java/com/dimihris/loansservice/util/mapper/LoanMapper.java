package com.dimihris.loansservice.util.mapper;

import com.dimihris.loansservice.dto.LoanDto;
import com.dimihris.loansservice.entity.Loan;

public class LoanMapper {

    public static LoanDto mapToLoanDto(Loan loan, LoanDto loanDto) {
        loanDto.setMobileNumber(loan.getMobileNumber());
        loanDto.setLoanNumber(loan.getLoanNumber());
        loanDto.setLoanType(loan.getLoanType());
        loanDto.setTotalLoan(loan.getTotalLoan());
        loanDto.setPaidAmount(loan.getPaidAmount());
        loanDto.setOutstandingAmount(loan.getOutstandingAmount());

        return loanDto;
    }
}
