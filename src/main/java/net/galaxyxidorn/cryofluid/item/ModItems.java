package net.galaxyxidorn.cryofluid.item;

import net.galaxyxidorn.cryofluid.CryoFluid;
import net.galaxyxidorn.cryofluid.fluid.ModFluids;
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

    private static DeferredItem<Item> simpleItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
