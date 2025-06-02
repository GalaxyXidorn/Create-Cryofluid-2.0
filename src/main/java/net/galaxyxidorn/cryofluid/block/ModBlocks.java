package net.galaxyxidorn.cryofluid.block;

import net.galaxyxidorn.cryofluid.CryoFluid;
import net.galaxyxidorn.cryofluid.fluid.ModFluids;
import net.galaxyxidorn.cryofluid.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CryoFluid.MOD_ID);

    public static final DeferredBlock<Block> CRYONITE_BLOCK = registerBlock("cryonite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    public static final DeferredBlock<Block> FROZEN_DEEPSLATE = registerBlock("frozen_deepslate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

    public static final DeferredBlock<Block> COBBLED_FROZEN_DEEPSLATE = registerBlock("cobbled_frozen_deepslate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE)));

    public static final DeferredBlock<Block> POLISHED_FROZEN_DEEPSLATE = registerBlock("polished_frozen_deepslate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DEEPSLATE)));

    public static final DeferredBlock<DropExperienceBlock> CRYONITE_ORE = registerBlock("cryonite_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 3), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)));

    public static final DeferredBlock<LiquidBlock> CRYOFLUID = BLOCKS.register("cryofluid",
            () -> new LiquidBlock(ModFluids.CRYOFLUID.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noCollission().noLootTable()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventbus) {
        BLOCKS.register(eventbus);
    }
}
