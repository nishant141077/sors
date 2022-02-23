package com.github.nishant141077.sors.db;

import com.github.nishant141077.sors.db.impl.StoredEquityInvestment;
import com.github.nishant141077.sors.db.impl.StoredFixedDepositInvestment;
import com.github.nishant141077.sors.db.impl.StoredGoldInvestment;
import com.github.nishant141077.sors.db.impl.StoredLifeInsuranceInvestment;
import com.github.nishant141077.sors.db.impl.StoredMutualFundInvestment;
import com.github.nishant141077.sors.db.impl.StoredNPSInvestment;
import com.github.nishant141077.sors.db.impl.StoredPPFInvestment;
import com.github.nishant141077.sors.db.impl.StoredRecurringDepositInvestment;
import com.github.nishant141077.sors.db.impl.StoredSavingsAccountInvestment;

public interface StoredInvestmentVisitor<T> {

  T visit(StoredEquityInvestment investment);

  T visit(StoredFixedDepositInvestment investment);

  T visit(StoredGoldInvestment investment);

  T visit(StoredLifeInsuranceInvestment investment);

  T visit(StoredMutualFundInvestment investment);

  T visit(StoredNPSInvestment investment);

  T visit(StoredPPFInvestment investment);

  T visit(StoredRecurringDepositInvestment investment);

  T visit(StoredSavingsAccountInvestment investment);
}
