package net.galaxyxidorn.cryofluid.datagen;

import net.galaxyxidorn.cryofluid.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import static net.galaxyxidorn.cryofluid.CryoFluid.MOD_ID;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CRYONITE_BLOCK);
        blockWithItem(ModBlocks.FROZEN_DEEPSLATE);
        blockWithItem(ModBlocks.COBBLED_FROZEN_DEEPSLATE);
        blockWithItem(ModBlocks.CRYONITE_ORE);
        blockWithItem(ModBlocks.POLISHED_FROZEN_DEEPSLATE);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
