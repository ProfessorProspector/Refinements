//package io.github.prospector.refinements.mixin.client;
//
//import io.github.prospector.refinements.mixintf.BlockedChestAnimationProvider;
//import net.minecraft.block.entity.BlockEntity;
//import net.minecraft.block.entity.BlockEntityType;
//import net.minecraft.block.entity.ChestBlockEntity;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//@Mixin(ChestBlockEntity.class)
//public abstract class ChestBlockEntityMixin extends BlockEntity {
//	@Shadow protected int viewerCount;
//
//	public ChestBlockEntityMixin(BlockEntityType<?> blockEntityType_1) {
//		super(blockEntityType_1);
//	}
//
//	@Inject(method = "getAnimationProgress", at = @At("HEAD"), cancellable = true)
//	public void getAnimationProgress(CallbackInfoReturnable info) {
//		float blockedAnimationAngle = ((BlockedChestAnimationProvider) this).getBlockedAnimationAngle();
//		if (blockedAnimationAngle > 0) {
//			System.out.println("Angle: " + blockedAnimationAngle);
//			info.setReturnValue(blockedAnimationAngle);
//		}
//	}
//}
