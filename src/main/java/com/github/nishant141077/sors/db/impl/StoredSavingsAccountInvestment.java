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
@DiscriminatorValue("SAVINGS_ACCOUNT")
public class StoredSavingsAccountInvestment extends StoredInvestment {

  @Column(name = "bank_name")
  private String bankName;

  @Column(name = "last_four_digits")
  private String lastFourDigits;

  @Column(name = "interest_rate")
  private double interestRate;

  @Column(name = "account_holder")
  private String accountHolder;

  @Builder
  public StoredSavingsAccountInvestment(String investmentId, String name, InvestmentState state,
      String bankName, String lastFourDigits, String accountHolder, double interestRate) {
    super(InvestmentType.SAVINGS_ACCOUNT, investmentId, name, state);

    this.bankName = bankName;
    this.lastFourDigits = lastFourDigits;
    this.interestRate = interestRate;
    this.accountHolder = accountHolder;
  }

  @Override
  public <T> T accept(StoredInvestmentVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
