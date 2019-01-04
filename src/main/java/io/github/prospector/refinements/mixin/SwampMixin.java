package io.github.prospector.refinements.mixin;

import io.github.prospector.refinements.Refinements;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.SwampTreeFeature;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SwampTreeFeature.class)
public class SwampMixin {

	@Shadow
	@Final
	@Mutable
	private static BlockState LEAVES;

	static {
		LEAVES = Refinements.SWAMP_LEAVES.getDefaultState();
	}
}
