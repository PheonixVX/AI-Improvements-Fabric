package io.github.pheonixvx.aiimprovementsfabric.modifier.editor;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;

/**
 * Created by Dark(DarkGuardsman, Robert) on 8/3/2019. Ported to Fabric on 2/25/2021.
 */
public class ConfigDrivenEdit implements IEntityAiModifier
{
	private final boolean configCheck;
	private final IEntityAiModifier modifier;

	public ConfigDrivenEdit(boolean configCheck, IEntityAiModifier modifier)
	{
		this.configCheck = configCheck;
		this.modifier = modifier;
	}

	@Override
	public Goal handle(MobEntity entity, Goal aiTask)
	{
		return configCheck ? modifier.handle(entity, aiTask) : aiTask;
	}

}