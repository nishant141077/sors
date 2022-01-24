package com.github.nishant141077.sors.models.investment;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.nishant141077.sors.models.investment.impl.EquityInvestment;
import com.github.nishant141077.sors.models.investment.impl.FixedDepositInvestment;
import com.github.nishant141077.sors.models.investment.impl.GoldInvestment;
import com.github.nishant141077.sors.models.investment.impl.LifeInsuranceInvestment;
import com.github.nishant141077.sors.models.investment.impl.MutualFundInvestment;
import com.github.nishant141077.sors.models.investment.impl.NPSInvestment;
import com.github.nishant141077.sors.models.investment.impl.PPFInvestment;
import com.github.nishant141077.sors.models.investment.impl.RecurringDepositInvestment;
import com.github.nishant141077.sors.models.investment.impl.SavingsAccountInvestment;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = SavingsAccountInvestment.class, name = InvestmentType.SAVINGS_ACCOUNT_TEXT),
    @JsonSubTypes.Type(value = MutualFundInvestment.class, name = InvestmentType.MUTUAL_FUND_TEXT),
    @JsonSubTypes.Type(value = EquityInvestment.class, name = InvestmentType.EQUITY_TEXT),
    @JsonSubTypes.Type(value = FixedDepositInvestment.class, name = InvestmentType.FIXED_DEPOSIT_TEXT),
    @JsonSubTypes.Type(value = LifeInsuranceInvestment.class, name = InvestmentType.LIFE_INSURANCE_TEXT),
    @JsonSubTypes.Type(value = PPFInvestment.class, name = InvestmentType.PUBLIC_PROVIDENT_FUND_TEXT),
    @JsonSubTypes.Type(value = GoldInvestment.class, name = InvestmentType.GOLD_TEXT),
    @JsonSubTypes.Type(value = RecurringDepositInvestment.class, name = InvestmentType.RECURRING_DEPOSIT_TEXT),
    @JsonSubTypes.Type(value = NPSInvestment.class, name = InvestmentType.NATIONAL_PENSION_SCHEME_TEXT),
})
@EqualsAndHashCode
@ToString
public abstract class Investment {

  @NotNull
  private InvestmentType type;
  @NotBlank
  private String name;
  private String investmentId;
  @NotNull
  private InvestmentState state;

  protected Investment(InvestmentType type) {
    this.type = type;
  }

  protected Investment(InvestmentType type, String name, String investmentId,
      InvestmentState state) {
    this.type = type;
    this.name = name;
    this.investmentId = investmentId;
    this.state = state;
  }
}
