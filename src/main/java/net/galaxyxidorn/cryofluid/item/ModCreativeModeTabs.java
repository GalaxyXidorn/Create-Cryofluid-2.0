package net.galaxyxidorn.cryofluid.item;

import net.galaxyxidorn.cryofluid.CryoFluid;
import net.galaxyxidorn.cryofluid.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Display;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.lang.reflect.Parameter;
import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CryoFluid.MOD_ID);

    public static final Supplier<CreativeModeTab> CREATE_CRYOFLUID_TAB = CREATE_MODE_TAB.register("create_cryofluid_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CRYONITECRYSTAL.get()))
                    .title(Component.translatable("creativetab.cryofluid.create_cryofluid"))
                    .displayItems((parameters, output) ->{
                        output.accept(ModItems.CRYONITECRYSTAL);
                        output.accept(ModItems.CRYODUST);
                        output.accept(ModBlocks.CRYONITE_BLOCK);
                        output.accept(ModBlocks.FROZEN_DEEPSLATE);

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATE_MODE_TAB.register(eventBus);
    }
}
