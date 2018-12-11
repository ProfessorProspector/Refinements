package io.github.prospector.refinements.client.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.block.BlockColorMap;
import net.minecraft.client.render.item.ItemColorMap;
import net.minecraft.item.block.BlockItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biomes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import io.github.prospector.refinements.Refinements;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {

	@Shadow private ItemColorMap itemColorMap;

	@Shadow
	public abstract BlockColorMap getBlockColorMap();

	@Shadow private BlockColorMap blockColorMap;

	@Inject(at = @At("RETURN"), method = "init()V")
	public void afterInit(CallbackInfo info) {
		getBlockColorMap().register((var0x, var1, var2, var3) -> Biomes.SWAMP.getFoliageColorAt(BlockPos.ORIGIN), Refinements.SWAMP_LEAVES);
		itemColorMap.method_1708((var1x, var2x) -> blockColorMap.getRenderColor(((BlockItem) var1x.getItem()).getBlock().getDefaultState(), MinecraftClient.getInstance().player.world, new BlockPos(MinecraftClient.getInstance().player), var2x), Blocks.GRASS_BLOCK, Blocks.GRASS, Blocks.FERN, Blocks.VINE, Blocks.OAK_LEAVES, Blocks.SPRUCE_LEAVES, Blocks.BIRCH_LEAVES, Blocks.JUNGLE_LEAVES, Blocks.ACACIA_LEAVES, Blocks.DARK_OAK_LEAVES, Blocks.LILY_PAD, Blocks.TALL_GRASS, Blocks.LARGE_FERN, Refinements.SWAMP_LEAVES);

	}
}
