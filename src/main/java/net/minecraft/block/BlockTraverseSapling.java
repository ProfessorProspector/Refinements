package net.minecraft.block;

import net.minecraft.sound.BlockSoundGroup;
import prospector.swampsapling.TreeGenerator;

public class BlockTraverseSapling extends BlockSapling {
	public BlockTraverseSapling(TreeGenerator treeGenerator) {
		super(treeGenerator, Block.Builder.create(Material.field_15935).method_9634().method_9640().method_9618().soundGroup(BlockSoundGroup.field_11535));
	}
}
