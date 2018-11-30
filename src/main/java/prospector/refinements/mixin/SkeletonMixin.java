package prospector.refinements.mixin;

import net.minecraft.class_3745;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.CrossbowAttackGoal;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractSkeletonEntity.class)
public abstract class SkeletonMixin extends HostileEntity implements class_3745 {

	@Shadow
	@Final
	private static TrackedData<Boolean> AIMING;

	public SkeletonMixin(EntityType<?> entityFactory, World world) {
		super(entityFactory, world);
	}

	@Inject(at = @At("RETURN"), method = "method_5959()V")
	public void addAIGoals(CallbackInfo callbackInfo) {
		//noinspection unchecked
		goalSelector.add(3, new CrossbowAttackGoal((AbstractSkeletonEntity) (Object) this, 1.0D, 8.0F));
	}

	@Override
	public void method_7110(boolean var1) {
		dataTracker.set(AIMING, var1);
	}
}
