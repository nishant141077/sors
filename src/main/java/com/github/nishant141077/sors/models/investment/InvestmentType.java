package com.github.nishant141077.sors.models.investment;

import lombok.Getter;

@Getter
public enum InvestmentType {
  MUTUAL_FUND("Mutual Fund", "MF"),
  EQUITY("Equity", "EQ"),
  SAVINGS_ACCOUNT("Savings Account", "ACC"),
  PUBLIC_PROVIDENT_FUND("Public Provident Fund", "PPF"),
  RECURRING_DEPOSIT("Recurring Deposit", "RD"),
  FIXED_DEPOSIT("Fixed Deposit", "FD"),
  NATIONAL_PENSION_SCHEME("National Pension Scheme", "NPS"),
  GOLD("Gold", "GOLD"),
  BOND("Bond", "BOND"),
  LIFE_INSURANCE("Life Insurance", "LINS");

  private final String code;
  private final String displayName;

  InvestmentType(String code, String displayName) {
    this.code = code;
    this.displayName = displayName;
  }

  public static final String MUTUAL_FUND_TEXT = "MUTUAL_FUND";
  public static final String EQUITY_TEXT = "EQUITY";
  public static final String SAVINGS_ACCOUNT_TEXT = "SAVINGS_ACCOUNT";
  public static final String PUBLIC_PROVIDENT_FUND_TEXT = "PUBLIC_PROVIDENT_FUND";
  public static final String RECURRING_DEPOSIT_TEXT = "RECURRING_DEPOSIT";
  public static final String FIXED_DEPOSIT_TEXT = "FIXED_DEPOSIT";
  public static final String NATIONAL_PENSION_SCHEME_TEXT = "NATIONAL_PENSION_SCHEME";
  public static final String GOLD_TEXT = "GOLD";
  public static final String BOND_TEXT = "BOND";
  public static final String LIFE_INSURANCE_TEXT = "LIFE_INSURANCE";

}
