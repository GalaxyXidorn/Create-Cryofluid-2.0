package net.galaxyxidorn.cryofluid.fluid;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.NotNull;

import static net.galaxyxidorn.cryofluid.CryoFluid.MOD_ID;

public class ModFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, MOD_ID);

    public static final ResourceLocation CRYOFLUID = ResourceLocation.fromNamespaceAndPath(MOD_ID, "fluid/cryofluid"),
            CRYOFLUID_FLOWING = ResourceLocation.fromNamespaceAndPath(MOD_ID, "fluid/cryofluid_flow");
    public static final DeferredHolder<FluidType, FluidType> CRYOFLUID_TYPE = FLUID_TYPES.register("cryofluid_type",
            () -> new FluidType(FluidType.Properties.create()
                    .canSwim(false)
                    .canDrown(true)
                    .canHydrate(false)
                    .canExtinguish(true)));

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
        eventBus.addListener(ModFluidTypes::registerClientExtensions);
    }

    private static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public int getTintColor() {
                return 0xFFFFFFFF;
            }

            @Override
            public @NotNull ResourceLocation getStillTexture() {
                return CRYOFLUID;
            }

            @Override
            public @NotNull ResourceLocation getFlowingTexture() {
                return CRYOFLUID_FLOWING;
            }
        }, CRYOFLUID_TYPE.get());
    }
}
