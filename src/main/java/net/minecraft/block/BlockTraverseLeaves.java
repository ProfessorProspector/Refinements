package net.minecraft.block;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;

public class BlockTraverseLeaves extends BlockLeaves {
	public Item sapling;

	public BlockTraverseLeaves(Item sapling) {
		super(Builder.create(Material.LEAVES).method_9632(0.2F).method_9640().soundGroup(BlockSoundGroup.field_11535));
	}
}
