package prospector.refinements.mixin;

import net.minecraft.client.MinecraftGame;
import net.minecraft.client.render.block.BlockColorMap;
import net.minecraft.client.render.item.ItemColorMap;
import net.minecraft.item.block.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biomes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import prospector.refinements.Refinements;

@Mixin(MinecraftGame.class)
public abstract class MinecraftGameMixin {

	@Shadow private ItemColorMap itemColorMap;

	@Shadow
	public abstract BlockColorMap getBlockColorMap();

	@Shadow private BlockColorMap blockColorMap;

	@Inject(at = @At("RETURN"), method = "init()V")
	public void afterInit(CallbackInfo info) {
		getBlockColorMap().register((var0x, var1, var2, var3) -> Biomes.SWAMP.getFoliageColorAt(BlockPos.ORIGIN), Refinements.SWAMP_LEAVES);
		itemColorMap.method_1708((var1x, var2x) -> blockColorMap.getRenderColor(((ItemBlock) var1x.getItem()).getBlock().getDefaultState(), null, null, var2x), Refinements.SWAMP_LEAVES);
		//		itemColorMap.method_1708((var1x, var2x) -> blockColorMap.getRenderColor(((ItemBlock) var1x.getItem()).getBlock().getDefaultState(), MinecraftGame.getInstance().player.world, new BlockPos(MinecraftGame.getInstance().player), var2x), Refinements.SWAMP_LEAVES);
	}
}
