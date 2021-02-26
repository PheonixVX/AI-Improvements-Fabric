package io.github.pheonixvx.aiimprovementsfabric.duckinterfaces;

import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.ai.goal.GoalSelector;

public interface MobEntityDuck {
	GoalSelector getTargetSelector();
	GoalSelector getGoalSelector();

	void setLookControl(LookControl lookControl);
}
