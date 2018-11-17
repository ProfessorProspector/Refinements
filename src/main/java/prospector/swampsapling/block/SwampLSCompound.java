package prospector.swampsapling.block;

import net.minecraft.world.gen.config.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.SwampTreeFeature;
import prospector.swampsapling.TreeGenerator;

public class SwampLSCompound {
	public String name;
	public LSLeaves lsLeaves;
	public LSSapling lsSapling;

	public SwampLSCompound() {
		lsLeaves = new LSLeaves();
		lsSapling = new LSSapling();
	}

	public class LSLeaves extends BlockTraverseLeaves {

		public LSLeaves() {
			super(null);
		}
	}

	public class LSSapling extends BlockTraverseSapling {
		public LSSapling() {
			super(new TreeGenerator(new SwampTreeFeature(DefaultFeatureConfig::make)));
		}
	}

}