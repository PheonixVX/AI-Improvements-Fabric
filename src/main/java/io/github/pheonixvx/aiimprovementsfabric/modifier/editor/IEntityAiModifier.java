package io.github.pheonixvx.aiimprovementsfabric.modifier.editor;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;

/**
 * Created by Dark(DarkGuardsman, Robert) on 8/2/2019. Ported by PheonixVX to Fabric on 2/24/2021.
 */
@FunctionalInterface
public interface IEntityAiModifier
{
	/**
	 * Called to modify an entity's AI task
	 *
	 * @param entity - entity being modified
	 * @return null to remove, same to skip, new to replace
	 */
	Goal handle(MobEntity entity, Goal aiTask);
}