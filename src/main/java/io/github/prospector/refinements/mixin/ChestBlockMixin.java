//package io.github.prospector.refinements.mixin;
//
//import io.github.prospector.refinements.Refinements;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.BlockWithEntity;
//import net.minecraft.block.ChestBlock;
//import net.minecraft.container.NameableContainerProvider;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.util.Hand;
//import net.minecraft.util.hit.BlockHitResult;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
//
//@Mixin(ChestBlock.class)
//public abstract class ChestBlockMixin extends BlockWithEntity {
//
//	public ChestBlockMixin(Settings settings) {
//		super(settings);
//	}
//
//	@Inject(method = "activate", locals = LocalCapture.CAPTURE_FAILSOFT, at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/block/ChestBlock;createContainerProvider(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/container/NameableContainerProvider;"))
//	public void activate(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult, CallbackInfoReturnable info, NameableContainerProvider nameableContainerProvider) {
//		if (nameableContainerProvider == null) {
//			world.addBlockAction(pos, this, Refinements.CHEST_BLOCKED_ACTION_ID, 1);
//			System.out.println("click!");
//		}
//	}
//}
