package prospector.refinements.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.SwampTreeFeature;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import prospector.refinements.Refinements;

@Mixin(SwampTreeFeature.class)
public class SwampMixin {

	@Shadow
	@Final
	@Mutable
	private static BlockState field_13886;

	static {
		field_13886 = Refinements.SWAMP_LEAVES.getDefaultState();
	}
}
