package net.galaxyxidorn.cryofluid.datagen;

import net.galaxyxidorn.cryofluid.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.CRYONITE_BLOCK.get());
        dropSelf(ModBlocks.COBBLED_FROZEN_DEEPSLATE.get());
        add(ModBlocks.FROZEN_DEEPSLATE.get(), (block) -> createSingleItemTableWithSilkTouch(block, ModBlocks.COBBLED_FROZEN_DEEPSLATE.get()));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
