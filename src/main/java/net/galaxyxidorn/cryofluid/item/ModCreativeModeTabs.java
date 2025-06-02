package net.galaxyxidorn.cryofluid.item;

import net.galaxyxidorn.cryofluid.CryoFluid;
import net.galaxyxidorn.cryofluid.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Set;
import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CryoFluid.MOD_ID);
    private static final Set<DeferredBlock<? extends Block>> EXCLUDED_BLOCKS = Set.of(ModBlocks.CRYOFLUID);
    private static final Set<DeferredItem<? extends Item>> EXCLUDED_ITEMS = Set.of();

    public static final Supplier<CreativeModeTab> CREATE_CRYOFLUID_TAB = CREATE_MODE_TAB.register("create_cryofluid_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CRYONITECRYSTAL.get()))
                    .title(Component.translatable("creativetab.cryofluid.create_cryofluid"))
                    .displayItems((parameters, output) ->{
                        ModItems.ITEMS.getEntries().forEach(item -> {
                            if (!EXCLUDED_ITEMS.contains(item)) output.accept(item.get());
                        });
                        ModBlocks.BLOCKS.getEntries().forEach(block -> {
                            if (!EXCLUDED_BLOCKS.contains(block)) output.accept(block.get());
                        });
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATE_MODE_TAB.register(eventBus);
    }
}
