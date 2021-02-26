package io.github.pheonixvx.aiimprovementsfabric.modifier.editor;

import net.minecraft.entity.ai.goal.Goal;

/**
 * Created by Dark(DarkGuardsman, Robert) on 8/3/2019. Ported to Fabric by PheonixVX on 2/25/2021.
 */
@FunctionalInterface
public interface InstanceCheck
{
	boolean isGoal(Goal goal);
}