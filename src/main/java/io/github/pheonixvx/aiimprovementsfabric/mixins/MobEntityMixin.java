package io.github.pheonixvx.aiimprovementsfabric.mixins;

import io.github.pheonixvx.aiimprovementsfabric.duckinterfaces.MobEntityDuck;
import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MobEntity.class)
public class MobEntityMixin implements MobEntityDuck {
	@Shadow protected final GoalSelector goalSelector;
	@Shadow protected final GoalSelector targetSelector;
	@Shadow protected LookControl lookControl;

	public MobEntityMixin (GoalSelector goalSelector, GoalSelector targetSelector) {
		this.goalSelector = goalSelector;
		this.targetSelector = targetSelector;
	}

	@Override
	public GoalSelector getTargetSelector () {
		return this.targetSelector;
	}

	@Override
	public GoalSelector getGoalSelector () {
		return this.goalSelector;
	}

	@Override
	public void setLookControl (LookControl lookControl) {
		this.lookControl = lookControl;
	}
}
