package net.galaxyxidorn.cryofluid.component;

import com.mojang.serialization.Codec;
import net.galaxyxidorn.cryofluid.CryoFluid;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.UnaryOperator;

public class ModDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.createDataComponents(CryoFluid.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> CAPTURED = register("captured",
            builder -> builder.persistent(Codec.BOOL));

    private static <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name,
                                                                                          UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return DATA_COMPONENT_TYPES.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus bus) {
        DATA_COMPONENT_TYPES.register(bus);
    }
}
