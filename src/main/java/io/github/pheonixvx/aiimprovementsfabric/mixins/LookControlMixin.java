package io.github.pheonixvx.aiimprovementsfabric.mixins;

import io.github.pheonixvx.aiimprovementsfabric.duckinterfaces.LookControlDuck;
import net.minecraft.entity.ai.control.LookControl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LookControl.class)
public class LookControlMixin implements LookControlDuck {
	@Shadow protected float yawSpeed;
	@Shadow protected float pitchSpeed;

	@Override
	public float getYawSpeed () {
		return this.yawSpeed;
	}

	@Override
	public float getPitchSpeed () {
		return this.pitchSpeed;
	}
}
