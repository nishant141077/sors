package com.github.nishant141077.sors.models.investment;

import com.github.nishant141077.sors.models.investment.impl.EquityInvestment;
import com.github.nishant141077.sors.models.investment.impl.FixedDepositInvestment;
import com.github.nishant141077.sors.models.investment.impl.GoldInvestment;
import com.github.nishant141077.sors.models.investment.impl.LifeInsuranceInvestment;
import com.github.nishant141077.sors.models.investment.impl.MutualFundInvestment;
import com.github.nishant141077.sors.models.investment.impl.NPSInvestment;
import com.github.nishant141077.sors.models.investment.impl.PPFInvestment;
import com.github.nishant141077.sors.models.investment.impl.RecurringDepositInvestment;
import com.github.nishant141077.sors.models.investment.impl.SavingsAccountInvestment;

public interface InvestmentVisitor<T> {

  T visit(MutualFundInvestment investment);

  T visit(EquityInvestment investment);

  T visit(SavingsAccountInvestment investment);

  T visit(PPFInvestment investment);

  T visit(RecurringDepositInvestment investment);

  T visit(FixedDepositInvestment investment);

  T visit(NPSInvestment investment);

  T visit(GoldInvestment investment);

  T visit(LifeInsuranceInvestment investment);
}
