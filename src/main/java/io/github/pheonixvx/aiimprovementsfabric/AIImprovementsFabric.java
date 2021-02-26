package io.github.pheonixvx.aiimprovementsfabric;

import io.github.pheonixvx.aiimprovementsfabric.config.ModConfig;
import io.github.pheonixvx.aiimprovementsfabric.modifier.ModifierSystem;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class AIImprovementsFabric implements ModInitializer {

	public static final String MOD_ID = "aiimprovements";

	@Override
	public void onInitialize () {
		// Register config
		AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);

		FastTrig.init();
		ModifierSystem.init();
	}

}
