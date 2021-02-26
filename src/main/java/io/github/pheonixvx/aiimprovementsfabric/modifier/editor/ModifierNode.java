package io.github.pheonixvx.aiimprovementsfabric.modifier.editor;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;

/**
 * Created by Dark(DarkGuardsman, Robert) on 8/3/2019. Ported to Fabric by PheonixVX on 2/24/2021.
 */
public class ModifierNode implements IEntityAiModifier
{
	protected int callCount = 0;
	private final IEntityAiModifier action;

	public ModifierNode(IEntityAiModifier action)
	{
		this.action = action;
	}

	@Override
	public Goal handle(MobEntity entity, Goal aiTask)
	{
		return action.handle(entity, aiTask);
	}
}