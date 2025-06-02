package net.galaxyxidorn.cryofluid.datagen;

import net.galaxyxidorn.cryofluid.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.galaxyxidorn.cryofluid.CryoFluid.MOD_ID;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CRYONITE_BLOCK.get())
                .add(ModBlocks.COBBLED_FROZEN_DEEPSLATE.get())
                .add(ModBlocks.FROZEN_DEEPSLATE.get())
                .add(ModBlocks.CRYONITE_ORE.get())
                .add(ModBlocks.POLISHED_FROZEN_DEEPSLATE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CRYONITE_ORE.get())
                .add(ModBlocks.CRYONITE_BLOCK.get());
    }
}
