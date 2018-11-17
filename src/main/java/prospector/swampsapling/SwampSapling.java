package prospector.swampsapling;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.gui.CreativeTab;
import net.minecraft.item.Item;
import net.minecraft.item.block.ItemBlock;
import net.minecraft.util.registry.Registry;
import net.minecraft.block.SwampLSCompound;

public class SwampSapling implements ModInitializer {
	public static final Block swampLeaves;
	public static final Block swampSapling;

	static {
		SwampLSCompound swampLSCompound = new SwampLSCompound();
		register("swamp_leaves", swampLeaves = swampLSCompound.lsLeaves, CreativeTab.DECORATIONS);
		register("swamp_sapling", swampSapling = swampLSCompound.lsSapling, CreativeTab.DECORATIONS);
	}

	private static Block register(String name, Block block, CreativeTab tab) {
		Registry.register(Registry.BLOCKS, "swampsapling:" + name, block);
		ItemBlock item = new ItemBlock(block, new Item.Builder().creativeTab(tab));
		item.method_7713(Item.BLOCK_ITEM_MAP, item);
		register(name, item);
		return block;
	}

	private static Item register(String name, Item item) {
		Registry.register(Registry.ITEMS, "swampsapling:" + name, item);
		return item;
	}

	@Override
	public void onInitialize() {

	}
}
