package io.github.pheonixvx.aiimprovementsfabric.mixins;

import io.github.pheonixvx.aiimprovementsfabric.duckinterfaces.GoalSelectorDuck;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.ai.goal.PrioritizedGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Set;

@Mixin(GoalSelector.class)
public class GoalSelectorMixin implements GoalSelectorDuck {
	@Shadow private final Set<PrioritizedGoal> goals;

	public GoalSelectorMixin (Set<PrioritizedGoal> goals) {
		this.goals = goals;
	}

	@Override
	public Set<PrioritizedGoal> getGoals () {
		return this.goals;
	}
}
