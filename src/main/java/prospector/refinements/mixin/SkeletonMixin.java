package prospector.refinements.mixin;

import net.minecraft.class_1383;
import net.minecraft.class_3745;
import net.minecraft.entity.EntityFactory;
import net.minecraft.entity.mob.EntityHostile;
import net.minecraft.entity.mob.EntitySkeletonBase;
import net.minecraft.entity.tracker.TrackedData;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntitySkeletonBase.class)
public abstract class SkeletonMixin extends EntityHostile implements class_3745 {

	@Shadow
	@Final
	private static TrackedData<Boolean> AIMING;

	public SkeletonMixin(EntityFactory<?> entityFactory, World world) {
		super(entityFactory, world);
	}

	@Inject(at = @At("RETURN"), method = "method_5959()V")
	public void addAIGoals(CallbackInfo callbackInfo) {
		goalSelector.add(3, new class_1383((EntitySkeletonBase) (Object) this, 1.0D, 8.0F));
	}

	@Override
	public void method_7110(boolean var1) {
		dataTracker.set(AIMING, var1);
	}
}
