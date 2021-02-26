package io.github.pheonixvx.aiimprovementsfabric;

import io.github.pheonixvx.aiimprovementsfabric.duckinterfaces.LookControlDuck;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.MathHelper;

/**
 * Created by Dark on 7/20/2015. Ported to Fabric on 2/25/2021.
 */
public class FixedLookController extends LookControl {

	public FixedLookController (MobEntity entity) {
		super(entity);
	}

	@Override
	protected float getTargetPitch () {
		double lvt_1_1_ = this.lookX - this.entity.getX();
		double lvt_3_1_ = this.lookY - (this.entity.getY() + this.entity.getEyeHeight(EntityPose.STANDING));
		double lvt_5_1_ = this.lookZ - this.entity.getZ();
		double lvt_7_1_ = MathHelper.sqrt(lvt_1_1_ * lvt_1_1_ + lvt_5_1_ * lvt_5_1_);
		return (float) (-(tan(lvt_3_1_, lvt_7_1_) * 57.2957763671875D));
	}

	@Override
	protected float getTargetYaw () {
		double lvt_1_1_ = this.lookX - this.entity.getX();
		double lvt_3_1_ = this.lookZ - this.entity.getZ();
		return (float) (tan(lvt_3_1_, lvt_1_1_) * 57.2957763671875D) - 90.0F;
	}


	public static float tan (double a, double b) {
		return FastTrig.atan2(a, b);
	}

	public void copyDataIntoSelf (LookControl oldHelper) {
		lookX = oldHelper.getLookX();
		lookY = oldHelper.getLookY();
		lookZ = oldHelper.getLookZ();
		active = oldHelper.isActive();
		pitchSpeed = ((LookControlDuck) oldHelper).getPitchSpeed();
		yawSpeed = ((LookControlDuck) oldHelper).getYawSpeed();
	}
}