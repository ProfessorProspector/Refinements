package io.github.prospector.refinements;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

public class Refinements implements ModInitializer {
	public static final String MOD_ID = "refinements";

	//	public static final int CHEST_BLOCKED_ACTION_ID = 13;
	//	public static final Supplier<Float> CHEST_PITCH = () -> 0.12F;

	public static final Block POTTED_ROSE = register("potted_rose", new FlowerPotBlock(Blocks.ROSE_BUSH, Block.Settings.copy(Blocks.FLOWER_POT)));
	public static final Block POTTED_PAEONIA = register("potted_paeonia", new FlowerPotBlock(Blocks.PEONY, Block.Settings.copy(Blocks.FLOWER_POT)));
//	public static final Block POTTED_CYAN_ROSE = register("potted_cyan_rose", new FlowerPotBlock(Blocks.AIR, Block.Settings.copy(Blocks.FLOWER_POT)));

	static {

	}

	private static Block register(String name, Block block) {
		Registry.register(Registry.BLOCK, MOD_ID + ":" + name, block);
		return block;
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
