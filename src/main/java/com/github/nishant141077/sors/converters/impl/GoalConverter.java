package com.github.nishant141077.sors.converters.impl;

import com.github.nishant141077.sors.converters.IModelConverter;
import com.github.nishant141077.sors.db.StoredGoal;
import com.github.nishant141077.sors.models.goal.Goal;
import com.google.inject.Singleton;

@Singleton
public class GoalConverter implements IModelConverter<StoredGoal, Goal> {

  @Override
  public Goal toDto(StoredGoal storedGoal) {
    return Goal.builder()
        .goalId(storedGoal.getGoalId())
        .name(storedGoal.getName())
        .state(storedGoal.getState())
        .targetAmount(storedGoal.getTargetAmount())
        .duration(storedGoal.getDuration())
        .endDate(storedGoal.getEndDate())
        .createdAt(storedGoal.getCreatedAt())
        .updatedAt(storedGoal.getUpdatedAt())
        .build();
  }

  @Override
  public StoredGoal toDao(Goal goal) {
    return StoredGoal.builder()
        .goalId(goal.getGoalId())
        .name(goal.getName())
        .state(goal.getState())
        .duration(goal.getDuration())
        .endDate(goal.getEndDate())
        .targetAmount(goal.getTargetAmount())
        .build();
  }
}
