package net.galaxyxidorn.cryofluid.datagen;

import net.galaxyxidorn.cryofluid.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static net.galaxyxidorn.cryofluid.CryoFluid.MOD_ID;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.CRYODUST.get());
        basicItem(ModItems.CRYONITECRYSTAL.get());
        basicItem(ModItems.CRYOFLUID_BUCKET.get());
        basicItem(ModItems.CRYONITE_ALLOY.get());
    }
}
