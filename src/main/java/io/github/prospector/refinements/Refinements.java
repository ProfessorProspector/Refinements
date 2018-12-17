package io.github.prospector.refinements;

import io.github.prospector.silk.block.SilkLeavesBlock;
import io.github.prospector.silk.block.SilkSaplingBlock;
import io.github.prospector.silk.util.SilkSaplingGenerator;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.block.BlockItem;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.config.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.SwampTreeFeature;

public class Refinements implements ModInitializer {
	public static final String MOD_ID = "refinements";

	public static final Block SWAMP_LEAVES;
	public static final Block SWAMP_SAPLING;

	static {
		SWAMP_LEAVES = register("swamp_leaves", new SilkLeavesBlock(null), ItemGroup.DECORATIONS);
		SWAMP_SAPLING = register("swamp_sapling", new SilkSaplingBlock(new SilkSaplingGenerator(new SwampTreeFeature(DefaultFeatureConfig::deserialize))), ItemGroup.DECORATIONS);
	}

	private static Block register(String name, Block block, ItemGroup tab) {
		Registry.register(Registry.BLOCK, MOD_ID + ":" + name, block);
		BlockItem item = new BlockItem(block, new Item.Settings().itemGroup(tab));
		item.registerBlockItemMap(Item.BLOCK_ITEM_MAP, item);
		register(name, item);
		return block;
	}

	private static Item register(String name, Item item) {
		Registry.register(Registry.ITEM, MOD_ID + ":" + name, item);
		return item;
	}

	@Override
	public void onInitialize() {

	}
}
