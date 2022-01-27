package com.github.nishant141077.sors.models.investment.impl;

import com.github.nishant141077.sors.models.investment.Investment;
import com.github.nishant141077.sors.models.investment.InvestmentState;
import com.github.nishant141077.sors.models.investment.InvestmentType;
import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GoldInvestment extends Investment {

  @NotBlank
  private String provider;

  private double purity;

  @Builder
  public GoldInvestment(String name, String investmentId, InvestmentState state, String provider,
      double purity, Date createdAt, Date updatedAt) {
    super(InvestmentType.GOLD, name, investmentId, state, createdAt, updatedAt);

    this.provider = provider;
    this.purity = purity;
  }
}
