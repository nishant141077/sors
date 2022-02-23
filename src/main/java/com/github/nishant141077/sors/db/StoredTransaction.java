package com.github.nishant141077.sors.db;

import com.github.nishant141077.sors.models.transaction.TransactionType;
import io.appform.dropwizard.sharding.sharding.LookupKey;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenerationTime;

@Data
@Entity
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "transactions", uniqueConstraints = {
    @UniqueConstraint(columnNames = "transaction_id")
})
public class StoredTransaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private long id;

  @LookupKey
  @Column(name = "transaction_id")
  private String transactionId;

  @Column(name = "type", updatable = false, nullable = false)
  @Enumerated(EnumType.STRING)
  private TransactionType type;

  @Column(name = "investment_id", nullable = false)
  private String investmentId;

  @Column(name = "goal_id", nullable = false)
  private String goalId;

  @Column(name = "platform")
  private String platform;

  @Column(name = "amount")
  private double amount;

  @Column(name = "transaction_time")
  private Date transactionTime;

  @Column(name = "created_at", updatable = false, insertable = false)
  @org.hibernate.annotations.Generated(value = GenerationTime.INSERT)
  private Date createdAt;

  @Column(name = "updated_at", updatable = false, insertable = false)
  @org.hibernate.annotations.Generated(value = GenerationTime.ALWAYS)
  private Date updatedAt;
}
