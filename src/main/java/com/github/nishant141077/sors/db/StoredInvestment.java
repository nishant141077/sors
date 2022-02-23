package com.github.nishant141077.sors.db;

import com.github.nishant141077.sors.models.investment.InvestmentState;
import com.github.nishant141077.sors.models.investment.InvestmentType;
import io.appform.dropwizard.sharding.sharding.LookupKey;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenerationTime;

@Data
@Entity
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "investments", uniqueConstraints = {
    @UniqueConstraint(columnNames = "investment_id")
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class StoredInvestment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private long id;

  @Column(name = "type", updatable = false, nullable = false)
  @Enumerated(EnumType.STRING)
  private InvestmentType type;

  @LookupKey
  @Column(name = "investment_id", unique = true, nullable = false)
  private String investmentId;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "state", nullable = false)
  @Enumerated(EnumType.STRING)
  private InvestmentState state;

  @Column(name = "created_at", updatable = false, insertable = false)
  @org.hibernate.annotations.Generated(value = GenerationTime.INSERT)
  private Date createdAt;

  @Column(name = "updated_at", updatable = false, insertable = false)
  @org.hibernate.annotations.Generated(value = GenerationTime.ALWAYS)
  private Date updatedAt;

  protected StoredInvestment(InvestmentType type, String investmentId, String name,
      InvestmentState state) {
    this.type = type;
    this.investmentId = investmentId;
    this.name = name;
    this.state = state;
  }

  public abstract <T> T accept(StoredInvestmentVisitor<T> visitor);
}
