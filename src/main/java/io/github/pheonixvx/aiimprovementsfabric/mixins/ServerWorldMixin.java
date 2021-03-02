package io.github.pheonixvx.aiimprovementsfabric.mixins;

import io.github.pheonixvx.aiimprovementsfabric.modifier.ModifierSystem;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {

	@Inject(at = @At("TAIL"), method = "addEntity")
	private void addEntity (Entity entity, CallbackInfoReturnable<Boolean> cir) {
		ModifierSystem.editor.handle(entity);
	}
}
