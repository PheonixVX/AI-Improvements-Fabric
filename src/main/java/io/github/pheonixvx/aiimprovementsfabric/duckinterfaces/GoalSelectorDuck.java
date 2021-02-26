package io.github.pheonixvx.aiimprovementsfabric.duckinterfaces;

import net.minecraft.entity.ai.goal.PrioritizedGoal;

import java.util.Set;

public interface GoalSelectorDuck {
	Set<PrioritizedGoal> getGoals();
}
