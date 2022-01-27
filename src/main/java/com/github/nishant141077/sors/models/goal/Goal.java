package com.github.nishant141077.sors.models.goal;

import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Goal {

  private String goalId;
  @NotBlank
  private String name;
  @Min(1)
  @Max(1200)
  private int duration; //in months
  @NotNull
  private Date endDate;
  private double targetAmount;
  @NotNull
  private GoalState state;
}
