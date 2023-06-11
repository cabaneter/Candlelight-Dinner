package satisfyu.candlelight.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import satisfyu.candlelight.util.CandlelightIdentifier;

import java.util.Set;

public class StorageTypesRegistry {
    public static final ResourceLocation SHELF = new CandlelightIdentifier("shelf");

    public static void registerBlocks(Set<Block> blocks) {
        blocks.add(ObjectRegistry.OAK_SHELF.get());
        blocks.add(ObjectRegistry.SPRUCE_SHELF.get());
        blocks.add(ObjectRegistry.BIRCH_SHELF.get());
        blocks.add(ObjectRegistry.ACACIA_SHELF.get());
        blocks.add(ObjectRegistry.JUNGLE_SHELF.get());
        blocks.add(ObjectRegistry.DARK_OAK_SHELF.get());
        blocks.add(ObjectRegistry.MANGROVE_SHELF.get());
        blocks.add(ObjectRegistry.CRIMSON_SHELF.get());
        blocks.add(ObjectRegistry.WARPED_SHELF.get());
    }
}