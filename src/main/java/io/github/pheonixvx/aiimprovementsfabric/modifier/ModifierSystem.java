package io.github.pheonixvx.aiimprovementsfabric.modifier;

import io.github.pheonixvx.aiimprovementsfabric.FixedLookController;
import io.github.pheonixvx.aiimprovementsfabric.config.ModConfig;
import io.github.pheonixvx.aiimprovementsfabric.duckinterfaces.MobEntityDuck;
import io.github.pheonixvx.aiimprovementsfabric.mixins.EscapeAttackerGoalAccessor;
import io.github.pheonixvx.aiimprovementsfabric.mixins.InflateGoalAccessor;
import io.github.pheonixvx.aiimprovementsfabric.mixins.SwimGoalAccessor;
import io.github.pheonixvx.aiimprovementsfabric.modifier.editor.GenericRemove;
import io.github.pheonixvx.aiimprovementsfabric.modifier.filters.FilterLayer;
import io.github.pheonixvx.aiimprovementsfabric.modifier.filters.FilterResult;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.PufferfishEntity;
import net.minecraft.entity.passive.SquidEntity;

/**
 * Created by Dark(DarkGuardsman, Robert) on 8/3/2019. Ported to Fabric by PheonixVX on 2/24/2021.
 */
public class ModifierSystem {
	public static final FilterLayer editor = new FilterLayer(null);
	public static final ModifierLevel mobEntityEditor = ModifierLevel.newFilter(entity -> entity instanceof MobEntity);
	public static final ModifierLevel fishEditor = ModifierLevel.newFilter(entity -> entity instanceof FishEntity);
	public static final ModifierLevel squidEditor = ModifierLevel.newFilter(entity -> entity instanceof SquidEntity);

	public static void init()
	{
		ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
		editor.add(mobEntityEditor);

		//Generic remove calls
		mobEntityEditor.goalEditor.add(new GenericRemove(goal -> goal instanceof LookAtEntityGoal, config.removeLookGoal));
		mobEntityEditor.goalEditor.add(new GenericRemove(goal -> goal instanceof LookAroundGoal, config.removeLookRandom));
		mobEntityEditor.filters.add(entity -> replaceLookHelper((MobEntity) entity));

		//Fish remove calls
		mobEntityEditor.filters.add(fishEditor);
		fishEditor.goalEditor.add(new GenericRemove(goal -> goal instanceof SwimAroundGoal, config.removeFishSwim));
		fishEditor.goalEditor.add(new GenericRemove(goal -> goal instanceof FleeEntityGoal, config.removeFishAvoidPlayer));
		fishEditor.goalEditor.add(new GenericRemove(goal -> goal instanceof EscapeDangerGoal, config.removeFishPanic));
		fishEditor.goalEditor.add(new GenericRemove(goal -> goal instanceof FollowGroupLeaderGoal, config.removeFishFollowLeader));
		fishEditor.goalEditor.add(new GenericRemove(goal -> goal instanceof InflateGoalAccessor, config.removeFishFollowLeader));

		//Squid
		mobEntityEditor.filters.add(squidEditor);
		squidEditor.goalEditor.add(new GenericRemove(goal -> goal instanceof SwimGoalAccessor, config.removeRandomMove));
		squidEditor.goalEditor.add(new GenericRemove(goal -> goal instanceof EscapeAttackerGoalAccessor, config.removeRandomMove));
	}

	private static FilterResult replaceLookHelper(MobEntity living)
	{
		ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
		//Only replace vanilla look helper to avoid overlapping mods
		if (config.replaceLookController && (living.getLookControl() == null || living.getLookControl().getClass() == LookControl.class))
		{
			//Get old so we can copy data
			final LookControl oldHelper = living.getLookControl();

			//Set new
			((MobEntityDuck) living).setLookControl(new FixedLookController(living));

			//Instance of check may look unneeded but some mods do stupid things
			if (living.getLookControl() instanceof FixedLookController) {
				((FixedLookController) living.getLookControl()).copyDataIntoSelf(oldHelper);
				return FilterResult.MODIFIED;
			} else {
				//TODO error/warning in console, then mark this entity as unusable for future checks
			}
		}
		return FilterResult.DID_NOTHING;
	}
}
