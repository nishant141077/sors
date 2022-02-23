package com.github.nishant141077.sors.db.impl;

import com.github.nishant141077.sors.db.StoredInvestment;
import com.github.nishant141077.sors.db.StoredInvestmentVisitor;
import com.github.nishant141077.sors.models.investment.InvestmentState;
import com.github.nishant141077.sors.models.investment.InvestmentType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("LIFE_INSURANCE")
public class StoredLifeInsuranceInvestment extends StoredInvestment {

  @Column(name = "company")
  private String company;

  @Column(name = "last_four_digits")
  private String policyLastFourDigits;

  @Builder
  public StoredLifeInsuranceInvestment(String investmentId, String name, InvestmentState state,
      String company, String policyLastFourDigits) {
    super(InvestmentType.LIFE_INSURANCE, investmentId, name, state);

    this.company = company;
    this.policyLastFourDigits = policyLastFourDigits;
  }

  @Override
  public <T> T accept(StoredInvestmentVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
