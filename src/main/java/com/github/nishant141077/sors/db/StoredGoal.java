package com.github.nishant141077.sors.db;

import com.github.nishant141077.sors.models.goal.GoalState;
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
import lombok.ToString;
import org.hibernate.annotations.GenerationTime;

@Data
@Entity
@ToString
@EqualsAndHashCode
@Builder
@Table(name = "goals", uniqueConstraints = {
    @UniqueConstraint(columnNames = "goal_id")
})
public class StoredGoal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private long id;

  @LookupKey
  @Column(name = "goal_id", unique = true, nullable = false)
  private String goalId;

  @Column(name = "name")
  private String name;

  @Column(name = "duration")
  private int duration;

  @Column(name = "end_date")
  private Date endDate;

  @Column(name = "target_amount")
  private double targetAmount;

  @Column(name = "state")
  @Enumerated(EnumType.STRING)
  private GoalState state;

  @Column(name = "created_at", updatable = false, insertable = false)
  @org.hibernate.annotations.Generated(value = GenerationTime.INSERT)
  private Date createdAt;

  @Column(name = "updated_at", updatable = false, insertable = false)
  @org.hibernate.annotations.Generated(value = GenerationTime.ALWAYS)
  private Date updatedAt;
}
