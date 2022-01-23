package com.github.nishant141077.sors.models.investment.impl;

import com.github.nishant141077.sors.models.investment.Investment;
import com.github.nishant141077.sors.models.investment.InvestmentState;
import com.github.nishant141077.sors.models.investment.InvestmentType;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LifeInsuranceInvestment extends Investment {

  @NotBlank
  private String company;
  @Size(min = 4, max = 4)
  private String policyLastFourDigits;

  public LifeInsuranceInvestment(String name, String investmentId, InvestmentState state,
      String company, String policyLastFourDigits) {
    super(InvestmentType.LIFE_INSURANCE, name, investmentId, state);

    this.company = company;
    this.policyLastFourDigits = policyLastFourDigits;
  }
}
