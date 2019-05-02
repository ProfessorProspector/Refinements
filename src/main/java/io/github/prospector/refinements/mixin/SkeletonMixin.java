package io.github.prospector.refinements.mixin;

import net.minecraft.entity.CrossbowUser;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.CrossbowAttackGoal;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractSkeletonEntity.class)
public abstract class SkeletonMixin extends HostileEntity implements CrossbowUser {

	public SkeletonMixin(EntityType<? extends HostileEntity> entityType_1, World world_1) {
		super(entityType_1, world_1);
	}

	@Inject(at = @At("RETURN"), method = "initGoals")
	public void addGoals(CallbackInfo callbackInfo) {
		goalSelector.add(3, new CrossbowAttackGoal((AbstractSkeletonEntity) (Object) this, 1.0D, 8.0F));
	}

	@Override
	public void setCharging(boolean charging) {
		setCharging(charging);
	}
}
