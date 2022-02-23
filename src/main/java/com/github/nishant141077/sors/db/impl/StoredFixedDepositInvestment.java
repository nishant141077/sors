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
@DiscriminatorValue("FIXED_DEPOSIT")
public class StoredFixedDepositInvestment extends StoredInvestment {

  @Column(name = "bank_name")
  private String bankName;

  @Column(name = "last_four_digits")
  private String lastFourDigits;

  @Column(name = "interest_rate")
  private double interestRate;

  @Column(name = "account_holder")
  private String accountHolder;

  @Column(name = "duration")
  private int duration; //in months

  @Builder
  public StoredFixedDepositInvestment(String investmentId, String name, InvestmentState state,
      String bankName, String lastFourDigits, double interestRate, String accountHolder,
      int duration) {
    super(InvestmentType.FIXED_DEPOSIT, investmentId, name, state);

    this.bankName = bankName;
    this.lastFourDigits = lastFourDigits;
    this.interestRate = interestRate;
    this.accountHolder = accountHolder;
    this.duration = duration;
  }

  @Override
  public <T> T accept(StoredInvestmentVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
