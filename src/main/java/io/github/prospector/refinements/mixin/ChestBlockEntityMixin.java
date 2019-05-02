//package io.github.prospector.refinements.mixin;
//
//import io.github.prospector.refinements.Refinements;
//import io.github.prospector.refinements.mixintf.BlockedChestAnimationProvider;
//import net.minecraft.block.ChestBlock;
//import net.minecraft.block.entity.BlockEntityType;
//import net.minecraft.block.entity.ChestBlockEntity;
//import net.minecraft.block.entity.LootableContainerBlockEntity;
//import net.minecraft.block.enums.ChestType;
//import net.minecraft.sound.SoundCategory;
//import net.minecraft.sound.SoundEvents;
//import net.minecraft.util.math.Direction;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//@Mixin(ChestBlockEntity.class)
//public abstract class ChestBlockEntityMixin extends LootableContainerBlockEntity implements BlockedChestAnimationProvider {
//
//	public ChestBlockEntityMixin(BlockEntityType<?> blockEntityType_1) {
//		super(blockEntityType_1);
//	}
//
//	public int refinements_blockedAnimationTicker = -1;
//	public float refinements_blockedAnimationAngle;
//	public float refinements_lastBlockedAnimationAngle;
//
//	@Inject(method = "tick", at = @At("HEAD"))
//	public void tick(CallbackInfo info) {
//		this.refinements_lastBlockedAnimationAngle = this.refinements_blockedAnimationAngle;
//
//		if (refinements_blockedAnimationTicker >= 0) {
//			if (this.refinements_blockedAnimationTicker == 0) {
//				ChestType chestType_1 = this.getCachedState().get(ChestBlock.CHEST_TYPE);
//				if (chestType_1 != ChestType.LEFT) {
//					double double_1 = (double) this.pos.getX() + 0.5D;
//					double double_2 = (double) this.pos.getY() + 0.5D;
//					double double_3 = (double) this.pos.getZ() + 0.5D;
//					if (chestType_1 == ChestType.RIGHT) {
//						Direction direction_1 = ChestBlock.getFacing(this.getCachedState());
//						double_1 += (double) direction_1.getOffsetX() * 0.5D;
//						double_3 += (double) direction_1.getOffsetZ() * 0.5D;
//					}
//
//					this.world.playSound(null, double_1, double_2, double_3, SoundEvents.BLOCK_WOODEN_DOOR_CLOSE, SoundCategory.BLOCKS, 0.6F, this.world.random.nextFloat() * 0.1F + 0.3F);
//				}
//			}
//			this.refinements_blockedAnimationTicker++;
//
//			if (this.refinements_blockedAnimationTicker < 5) {
//				this.refinements_blockedAnimationAngle += 0.01F;
//			} else if (this.refinements_blockedAnimationTicker < 10) {
//				this.refinements_blockedAnimationAngle -= 0.01F;
//			}
//
//			//			if (this.refinements_blockedAnimationAngle > 0.0F || this.refinements_blockedAnimationAngle < 1.0F) {
//			//				float originalAngle = this.refinements_blockedAnimationAngle;
//
//			//
//			//				if (this.refinements_blockedAnimationAngle > 0.5F) {
//			//					this.refinements_blockedAnimationAngle = 0.5F;
//			//				}
//
//			//				if (this.refinements_blockedAnimationAngle < 0.5F && originalAngle >= 0.5F) {
//			//					this.playSound(SoundEvents.BLOCK_CHEST_LOCKED);
//			//				}
//		}
//		System.out.println(refinements_blockedAnimationAngle);
//		if (this.refinements_blockedAnimationTicker == 10) {
//			this.refinements_blockedAnimationAngle = 0.0F;
//			this.refinements_blockedAnimationTicker = -1;
//		}
//	}
//
//	@Inject(method = "onBlockAction", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/LootableContainerBlockEntity;onBlockAction(II)Z"), cancellable = true)
//	public void onBlockAction(int id, int value, CallbackInfoReturnable info) {
//		if (id == Refinements.CHEST_BLOCKED_ACTION_ID) {
//			System.out.println(value);
//			refinements_blockedAnimationTicker = 0;
//			info.cancel();
//		}
//	}
//
//	@Override
//	public float getBlockedAnimationAngle() {
//		return refinements_blockedAnimationAngle;
//	}
//}
