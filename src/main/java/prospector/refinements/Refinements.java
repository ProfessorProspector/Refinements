package prospector.refinements;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.block.BlockItem;
import net.minecraft.sortme.ItemGroup;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.config.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.SwampTreeFeature;
import prospector.silk.block.SilkLeavesBlock;
import prospector.silk.block.SilkSaplingBlock;
import prospector.silk.util.SilkSaplingGenerator;

public class Refinements implements ModInitializer {
	public static final String MOD_ID = "refinements";

	public static final Block SWAMP_LEAVES;
	public static final Block SWAMP_SAPLING;

	static {
		SWAMP_LEAVES = register("swamp_leaves", new SilkLeavesBlock(null), ItemGroup.DECORATIONS);
		SWAMP_SAPLING = register("swamp_sapling", new SilkSaplingBlock(new SilkSaplingGenerator(new SwampTreeFeature(DefaultFeatureConfig::make))), ItemGroup.DECORATIONS);
	}

	private static Block register(String name, Block block, ItemGroup tab) {
		Registry.register(Registry.BLOCKS, MOD_ID + ":" + name, block);
		BlockItem item = new BlockItem(block, new Item.Builder().creativeTab(tab));
		item.registerBlockItemMap(Item.BLOCK_ITEM_MAP, item);
		register(name, item);
		return block;
	}

	private static Item register(String name, Item item) {
		Registry.register(Registry.ITEMS, MOD_ID + ":" + name, item);
		return item;
	}

	@Override
	public void onInitialize() {

	}
}
