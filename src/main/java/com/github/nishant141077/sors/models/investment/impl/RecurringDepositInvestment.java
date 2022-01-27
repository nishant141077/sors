package com.github.nishant141077.sors.models.investment.impl;

import com.github.nishant141077.sors.models.investment.Investment;
import com.github.nishant141077.sors.models.investment.InvestmentState;
import com.github.nishant141077.sors.models.investment.InvestmentType;
import java.util.Date;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RecurringDepositInvestment extends Investment {

  @NotBlank
  private String bankName;

  @Size(min = 4, max = 4)
  private String lastFourDigits;

  private double interestRate;

  @NotBlank
  private String accountHolder;

  @Builder
  public RecurringDepositInvestment(String name, String investmentId, InvestmentState state,
      String bankName, String lastFourDigits, double interestRate, String accountHolder,
      Date createdAt, Date updatedAt) {
    super(InvestmentType.RECURRING_DEPOSIT, name, investmentId, state, createdAt, updatedAt);

    this.bankName = bankName;
    this.lastFourDigits = lastFourDigits;
    this.interestRate = interestRate;
    this.accountHolder = accountHolder;
  }
}
