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
@DiscriminatorValue("GOLD")
public class StoredGoldInvestment extends StoredInvestment {

  @Column(name = "provider")
  private String provider;

  @Column(name = "purity")
  private double purity;

  @Builder
  public StoredGoldInvestment(String investmentId, String name, InvestmentState state,
      String provider, double purity) {
    super(InvestmentType.GOLD, investmentId, name, state);

    this.provider = provider;
    this.purity = purity;
  }

  @Override
  public <T> T accept(StoredInvestmentVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
