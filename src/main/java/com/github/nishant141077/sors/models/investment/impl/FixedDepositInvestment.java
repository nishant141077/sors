package com.github.nishant141077.sors.models.investment.impl;

import com.github.nishant141077.sors.models.investment.Investment;
import com.github.nishant141077.sors.models.investment.InvestmentState;
import com.github.nishant141077.sors.models.investment.InvestmentType;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FixedDepositInvestment extends Investment {

  @NotBlank
  private String bankName;

  @Size(min = 4, max = 4)
  private String lastFourDigits;

  private double interestRate;

  @NotBlank
  private String accountHolder;

  @Min(1)
  @Max(120)
  private int duration; //in months

  @Builder
  public FixedDepositInvestment(String name, String investmentId, InvestmentState state,
      String bankName, String lastFourDigits, double interestRate, String accountHolder,
      int duration, Date createdAt, Date updatedAt) {
    super(InvestmentType.FIXED_DEPOSIT, name, investmentId, state, createdAt, updatedAt);

    this.bankName = bankName;
    this.lastFourDigits = lastFourDigits;
    this.interestRate = interestRate;
    this.accountHolder = accountHolder;
    this.duration = duration;
  }
}
