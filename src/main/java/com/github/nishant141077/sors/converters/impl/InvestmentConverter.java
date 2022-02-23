package com.github.nishant141077.sors.converters.impl;

import com.github.nishant141077.sors.converters.IModelConverter;
import com.github.nishant141077.sors.db.StoredInvestment;
import com.github.nishant141077.sors.db.StoredInvestmentVisitor;
import com.github.nishant141077.sors.db.impl.StoredEquityInvestment;
import com.github.nishant141077.sors.db.impl.StoredFixedDepositInvestment;
import com.github.nishant141077.sors.db.impl.StoredGoldInvestment;
import com.github.nishant141077.sors.db.impl.StoredLifeInsuranceInvestment;
import com.github.nishant141077.sors.db.impl.StoredMutualFundInvestment;
import com.github.nishant141077.sors.db.impl.StoredNPSInvestment;
import com.github.nishant141077.sors.db.impl.StoredPPFInvestment;
import com.github.nishant141077.sors.db.impl.StoredRecurringDepositInvestment;
import com.github.nishant141077.sors.db.impl.StoredSavingsAccountInvestment;
import com.github.nishant141077.sors.models.investment.Investment;
import com.github.nishant141077.sors.models.investment.InvestmentVisitor;
import com.github.nishant141077.sors.models.investment.impl.EquityInvestment;
import com.github.nishant141077.sors.models.investment.impl.FixedDepositInvestment;
import com.github.nishant141077.sors.models.investment.impl.GoldInvestment;
import com.github.nishant141077.sors.models.investment.impl.LifeInsuranceInvestment;
import com.github.nishant141077.sors.models.investment.impl.MutualFundInvestment;
import com.github.nishant141077.sors.models.investment.impl.NPSInvestment;
import com.github.nishant141077.sors.models.investment.impl.PPFInvestment;
import com.github.nishant141077.sors.models.investment.impl.RecurringDepositInvestment;
import com.github.nishant141077.sors.models.investment.impl.SavingsAccountInvestment;
import com.google.inject.Singleton;

@Singleton
public class InvestmentConverter implements IModelConverter<StoredInvestment, Investment> {

  private final InvestmentDtoBuilder dtoBuilder = new InvestmentDtoBuilder();

  private final InvestmentDaoBuilder daoBuilder = new InvestmentDaoBuilder();

  @Override
  public Investment toDto(StoredInvestment dao) {
    return dao.accept(dtoBuilder);
  }

  @Override
  public StoredInvestment toDao(Investment dto) {
    return dto.accept(daoBuilder);
  }

  private static final class InvestmentDtoBuilder implements StoredInvestmentVisitor<Investment> {

    @Override
    public Investment visit(StoredEquityInvestment investment) {
      return EquityInvestment.builder()
          .investmentId(investment.getInvestmentId())
          .name(investment.getName())
          .state(investment.getState())
          .createdAt(investment.getCreatedAt())
          .updatedAt(investment.getUpdatedAt())
          .company(investment.getCompany())
          .build();
    }

    @Override
    public Investment visit(StoredFixedDepositInvestment investment) {
      return FixedDepositInvestment.builder()
          .investmentId(investment.getInvestmentId())
          .name(investment.getName())
          .state(investment.getState())
          .createdAt(investment.getCreatedAt())
          .updatedAt(investment.getUpdatedAt())
          .bankName(investment.getBankName())
          .duration(investment.getDuration())
          .accountHolder(investment.getAccountHolder())
          .interestRate(investment.getInterestRate())
          .lastFourDigits(investment.getLastFourDigits())
          .build();
    }

    @Override
    public Investment visit(StoredGoldInvestment investment) {
      return GoldInvestment.builder()
          .investmentId(investment.getInvestmentId())
          .name(investment.getName())
          .state(investment.getState())
          .createdAt(investment.getCreatedAt())
          .updatedAt(investment.getUpdatedAt())
          .provider(investment.getProvider())
          .purity(investment.getPurity())
          .build();
    }

    @Override
    public Investment visit(StoredLifeInsuranceInvestment investment) {
      return LifeInsuranceInvestment.builder()
          .investmentId(investment.getInvestmentId())
          .name(investment.getName())
          .state(investment.getState())
          .createdAt(investment.getCreatedAt())
          .updatedAt(investment.getUpdatedAt())
          .company(investment.getCompany())
          .policyLastFourDigits(investment.getPolicyLastFourDigits())
          .build();
    }

    @Override
    public Investment visit(StoredMutualFundInvestment investment) {
      return MutualFundInvestment.builder()
          .investmentId(investment.getInvestmentId())
          .name(investment.getName())
          .state(investment.getState())
          .createdAt(investment.getCreatedAt())
          .updatedAt(investment.getUpdatedAt())
          .company(investment.getCompany())
          .build();
    }

    @Override
    public Investment visit(StoredNPSInvestment investment) {
      return NPSInvestment.builder()
          .investmentId(investment.getInvestmentId())
          .name(investment.getName())
          .state(investment.getState())
          .createdAt(investment.getCreatedAt())
          .updatedAt(investment.getUpdatedAt())
          .accountHolder(investment.getAccountHolder())
          .interestRate(investment.getInterestRate())
          .lastFourDigits(investment.getLastFourDigits())
          .build();
    }

    @Override
    public Investment visit(StoredPPFInvestment investment) {
      return PPFInvestment.builder()
          .investmentId(investment.getInvestmentId())
          .name(investment.getName())
          .state(investment.getState())
          .createdAt(investment.getCreatedAt())
          .updatedAt(investment.getUpdatedAt())
          .managingEntityName(investment.getManagingEntityName())
          .accountHolder(investment.getAccountHolder())
          .interestRate(investment.getInterestRate())
          .lastFourDigits(investment.getLastFourDigits())
          .build();
    }

    @Override
    public Investment visit(StoredRecurringDepositInvestment investment) {
      return RecurringDepositInvestment.builder()
          .investmentId(investment.getInvestmentId())
          .name(investment.getName())
          .state(investment.getState())
          .createdAt(investment.getCreatedAt())
          .updatedAt(investment.getUpdatedAt())
          .bankName(investment.getBankName())
          .accountHolder(investment.getAccountHolder())
          .interestRate(investment.getInterestRate())
          .lastFourDigits(investment.getLastFourDigits())
          .duration(investment.getDuration())
          .build();
    }

    @Override
    public Investment visit(StoredSavingsAccountInvestment investment) {
      return SavingsAccountInvestment.builder()
          .investmentId(investment.getInvestmentId())
          .name(investment.getName())
          .state(investment.getState())
          .createdAt(investment.getCreatedAt())
          .updatedAt(investment.getUpdatedAt())
          .bankName(investment.getBankName())
          .accountHolder(investment.getAccountHolder())
          .interestRate(investment.getInterestRate())
          .lastFourDigits(investment.getLastFourDigits())
          .build();
    }
  }

  private static final class InvestmentDaoBuilder implements InvestmentVisitor<StoredInvestment> {

    @Override
    public StoredInvestment visit(MutualFundInvestment investment) {
      return StoredMutualFundInvestment.builder()
          .investmentId(investment.getInvestmentId())
          .name(investment.getName())
          .state(investment.getState())
          .company(investment.getCompany())
          .build();
    }

    @Override
    public StoredInvestment visit(EquityInvestment investment) {
      return StoredEquityInvestment.builder()
          .investmentId(investment.getInvestmentId())
          .name(investment.getName())
          .state(investment.getState())
          .company(investment.getCompany())
          .build();
    }

    @Override
    public StoredInvestment visit(SavingsAccountInvestment investment) {
      return StoredSavingsAccountInvestment.builder()
          .investmentId(investment.getInvestmentId())
          .name(investment.getName())
          .state(investment.getState())
          .accountHolder(investment.getAccountHolder())
          .bankName(investment.getBankName())
          .lastFourDigits(investment.getLastFourDigits())
          .interestRate(investment.getInterestRate())
          .build();
    }

    @Override
    public StoredInvestment visit(PPFInvestment investment) {
      return StoredPPFInvestment.builder()
          .investmentId(investment.getInvestmentId())
          .name(investment.getName())
          .state(investment.getState())
          .managingEntityName(investment.getManagingEntityName())
          .accountHolder(investment.getAccountHolder())
          .lastFourDigits(investment.getLastFourDigits())
          .interestRate(investment.getInterestRate())
          .build();
    }

    @Override
    public StoredInvestment visit(RecurringDepositInvestment investment) {
      return StoredRecurringDepositInvestment.builder()
          .investmentId(investment.getInvestmentId())
          .name(investment.getName())
          .state(investment.getState())
          .accountHolder(investment.getAccountHolder())
          .bankName(investment.getBankName())
          .lastFourDigits(investment.getLastFourDigits())
          .interestRate(investment.getInterestRate())
          .duration(investment.getDuration())
          .build();
    }

    @Override
    public StoredInvestment visit(FixedDepositInvestment investment) {
      return StoredFixedDepositInvestment.builder()
          .investmentId(investment.getInvestmentId())
          .name(investment.getName())
          .state(investment.getState())
          .accountHolder(investment.getAccountHolder())
          .bankName(investment.getBankName())
          .lastFourDigits(investment.getLastFourDigits())
          .interestRate(investment.getInterestRate())
          .duration(investment.getDuration())
          .build();
    }

    @Override
    public StoredInvestment visit(NPSInvestment investment) {
      return StoredNPSInvestment.builder()
          .investmentId(investment.getInvestmentId())
          .name(investment.getName())
          .state(investment.getState())
          .accountHolder(investment.getAccountHolder())
          .lastFourDigits(investment.getLastFourDigits())
          .interestRate(investment.getInterestRate())
          .build();
    }

    @Override
    public StoredInvestment visit(GoldInvestment investment) {
      return StoredGoldInvestment.builder()
          .investmentId(investment.getInvestmentId())
          .name(investment.getName())
          .state(investment.getState())
          .provider(investment.getProvider())
          .purity(investment.getPurity())
          .build();
    }

    @Override
    public StoredInvestment visit(LifeInsuranceInvestment investment) {
      return StoredLifeInsuranceInvestment.builder()
          .investmentId(investment.getInvestmentId())
          .name(investment.getName())
          .state(investment.getState())
          .company(investment.getCompany())
          .policyLastFourDigits(investment.getPolicyLastFourDigits())
          .build();
    }
  }
}
