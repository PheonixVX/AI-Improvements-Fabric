package io.github.pheonixvx.aiimprovementsfabric.modifier.editor;

import io.github.pheonixvx.aiimprovementsfabric.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;

/**
 * Created by Dark(DarkGuardsman, Robert) on 8/3/2019. Ported to Fabric by PheonixVX on 2/25/2021.
 */
public class GenericRemove implements IEntityAiModifier {
	private final InstanceCheck instanceCheck;
	private final boolean configCheck;

	public GenericRemove(InstanceCheck instanceCheck, boolean configCheck)
	{
		this.instanceCheck = instanceCheck;
		this.configCheck = configCheck;
	}

	@Override
	public Goal handle(MobEntity entity, Goal aiTask)
	{
		ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
		return config.allowRemoveCalls && instanceCheck.isGoal(aiTask) && configCheck ? null : aiTask;
	}
}