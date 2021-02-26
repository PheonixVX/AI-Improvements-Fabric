package io.github.pheonixvx.aiimprovementsfabric.config;

import io.github.pheonixvx.aiimprovementsfabric.AIImprovementsFabric;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = AIImprovementsFabric.MOD_ID)
public class ModConfig implements ConfigData {
	//Global
	public final boolean allowRemoveCalls = true;
	public final boolean enableCallBubbling = true;

	//Generic mob
	public final boolean removeLookGoal = false;
	public final boolean removeLookRandom = false;
	public final boolean replaceLookController = true;

	//Fish
	public final boolean removeFishSwim = false;
	public final boolean removeFishAvoidPlayer = false;
	public final boolean removeFishPanic = false;
	public final boolean removeFishFollowLeader = false;
	public final boolean removeFishPuff = false;

	//Squid
	public final boolean removeSquidFlee = false;
	public final boolean removeRandomMove = false;
}
