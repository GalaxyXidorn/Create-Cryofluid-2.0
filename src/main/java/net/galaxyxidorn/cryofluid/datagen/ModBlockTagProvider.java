package net.galaxyxidorn.cryofluid.datagen;

import com.simibubi.create.Create;
import net.galaxyxidorn.cryofluid.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
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
                .add(ModBlocks.POLISHED_FROZEN_DEEPSLATE.get())
                .add(ModBlocks.CRYO_CASING.get());

        tag(BlockTags.MINEABLE_WITH_AXE).add(ModBlocks.CRYO_CASING.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CRYONITE_ORE.get())
                .add(ModBlocks.CRYONITE_BLOCK.get());

        TagKey<Block> CASING = TagKey.create(Registries.BLOCK, Create.asResource("casing"));
        tag(CASING).add(ModBlocks.CRYO_CASING.get());
    }
}
