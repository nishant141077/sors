package com.github.nishant141077.sors.models.investment.impl;

import com.github.nishant141077.sors.models.investment.Investment;
import com.github.nishant141077.sors.models.investment.InvestmentState;
import com.github.nishant141077.sors.models.investment.InvestmentType;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PPFInvestment extends Investment {

  @NotBlank
  private String managingEntityName; //bank name or post office
  @Size(min = 4, max = 4)
  private String lastFourDigits;
  private double interestRate;
  @NotBlank
  private String accountHolder;

  @Builder
  public PPFInvestment(String name, String investmentId, InvestmentState state,
      String managingEntityName, String lastFourDigits, double interestRate, String accountHolder) {
    super(InvestmentType.PUBLIC_PROVIDENT_FUND, name, investmentId, state);

    this.managingEntityName = managingEntityName;
    this.lastFourDigits = lastFourDigits;
    this.interestRate = interestRate;
    this.accountHolder = accountHolder;
  }
}
