package io.github.prospector.refinements.mixin.client;

import io.github.prospector.refinements.Refinements;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.block.BlockColorMap;
import net.minecraft.client.render.item.ItemColorMap;
import net.minecraft.item.BlockItem;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {

	@Shadow private ItemColorMap itemColorMap;

	@Shadow
	public abstract BlockColorMap getBlockColorMap();

	@Shadow private BlockColorMap blockColorMap;

	@Inject(at = @At("RETURN"), method = "init()V")
	public void afterInit(CallbackInfo info) {
		itemColorMap.register((stack, tintIndex) -> {
			if (MinecraftClient.getInstance().player != null && MinecraftClient.getInstance().world != null) {
				return blockColorMap.getRenderColor(((BlockItem) stack.getItem()).getBlock().getDefaultState(), MinecraftClient.getInstance().player.world, new BlockPos(MinecraftClient.getInstance().player), tintIndex);
			} else {
				BlockState blockState_1 = ((BlockItem) stack.getItem()).getBlock().getDefaultState();
				return blockColorMap.getRenderColor(blockState_1, null, null, tintIndex);
			}
		}, Blocks.GRASS_BLOCK, Blocks.GRASS, Blocks.FERN, Blocks.VINE, Blocks.OAK_LEAVES, Blocks.SPRUCE_LEAVES, Blocks.BIRCH_LEAVES, Blocks.JUNGLE_LEAVES, Blocks.ACACIA_LEAVES, Blocks.DARK_OAK_LEAVES, Blocks.LILY_PAD, Blocks.TALL_GRASS, Blocks.LARGE_FERN);
	}
}
