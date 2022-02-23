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
@DiscriminatorValue("EQUITY")
public class StoredEquityInvestment extends StoredInvestment {

  @Column(name = "company")
  private String company;

  @Builder
  public StoredEquityInvestment(String investmentId, String name, InvestmentState state,
      String company) {
    super(InvestmentType.EQUITY, investmentId, name, state);

    this.company = company;
  }

  @Override
  public <T> T accept(StoredInvestmentVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
