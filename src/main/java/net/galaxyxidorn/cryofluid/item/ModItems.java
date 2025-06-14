package net.galaxyxidorn.cryofluid.item;

import net.galaxyxidorn.cryofluid.CryoFluid;
import net.galaxyxidorn.cryofluid.block.ModBlocks;
import net.galaxyxidorn.cryofluid.component.ModDataComponents;
import net.galaxyxidorn.cryofluid.fluid.ModFluids;
import net.galaxyxidorn.cryofluid.item.custom.BreezeFreezerBlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CryoFluid.MOD_ID);

    public static final DeferredItem<Item>
            CRYONITECRYSTAL = simpleItem("cryonite_crystal"),
            CRYODUST = simpleItem("cryodust"),
            CRYONITE_ALLOY = simpleItem("cryonite_alloy");
    public static final DeferredItem<BucketItem> CRYOFLUID_BUCKET = ITEMS.register("cryofluid_bucket",
            () -> new BucketItem(ModFluids.CRYOFLUID.get(), new Item.Properties()));
    public static final DeferredItem<BreezeFreezerBlockItem> BREEZE_FREEZER = ITEMS.register("breeze_freezer",
            () -> new BreezeFreezerBlockItem(ModBlocks.BREEZE_FREEZER.get(), new Item.Properties().component(ModDataComponents.CAPTURED, false)));

    private static DeferredItem<Item> simpleItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
