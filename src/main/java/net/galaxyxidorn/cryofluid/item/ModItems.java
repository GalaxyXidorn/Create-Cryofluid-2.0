package net.galaxyxidorn.cryofluid.item;

import net.galaxyxidorn.cryofluid.CryoFluid;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CryoFluid.MOD_ID);

    public static final DeferredItem<Item> CRYONITECRYSTAL = ITEMS.register("cryonite_crystal",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CRYODUST = ITEMS.register("cryodust",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
