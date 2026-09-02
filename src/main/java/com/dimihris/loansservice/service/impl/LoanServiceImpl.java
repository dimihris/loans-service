package com.dimihris.loansservice.service.impl;

import com.dimihris.loansservice.constant.LoanConstants;
import com.dimihris.loansservice.entity.Loan;
import com.dimihris.loansservice.exception.LoanAlreadyExistsException;
import com.dimihris.loansservice.repository.LoanRepository;
import com.dimihris.loansservice.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@AllArgsConstructor
@Service
public class LoanServiceImpl implements LoanService {

    private LoanRepository loanRepository;

    @Override
    public void createLoan(String mobileNumber) {

        Optional<Loan> loan = loanRepository.findByMobileNumber(mobileNumber);

        if (loan.isPresent()) {
            throw new LoanAlreadyExistsException("A loan is already present on the given mobile number " + mobileNumber);
        }

        loanRepository.save(createNewLoan(mobileNumber));
    }

    public Loan createNewLoan(String mobileNumber) {

        Loan newLoan = new Loan();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);

        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setLoanType(LoanConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoanConstants.NEW_LOAN_LIMIT);
        newLoan.setPaidAmount(0);
        newLoan.setOutstandingAmount(LoanConstants.NEW_LOAN_LIMIT);

        return newLoan;
    }
}
