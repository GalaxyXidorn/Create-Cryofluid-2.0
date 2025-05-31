package net.galaxyxidorn.cryofluid.fluid;

import net.galaxyxidorn.cryofluid.CryoFluid;
import net.galaxyxidorn.cryofluid.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, CryoFluid.MOD_ID);

    public static final DeferredHolder<Fluid, FlowingFluid> CRYOFLUID = FLUIDS.register("cryofluid", () -> new BaseFlowingFluid.Source(ModFluids.CRYOFLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> CRYOFLUID_FLOWING = FLUIDS.register("cryofluid_flowing", () -> new BaseFlowingFluid.Flowing(ModFluids.CRYOFLUID_PROPERTIES));

    public static final BaseFlowingFluid.Properties CRYOFLUID_PROPERTIES = new BaseFlowingFluid.Properties(ModFluidTypes.CRYOFLUID_TYPE, CRYOFLUID, CRYOFLUID_FLOWING)
            .block(ModBlocks.CRYOFLUID)
            .slopeFindDistance(3)
            .levelDecreasePerBlock(2)
            .tickRate(25);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
