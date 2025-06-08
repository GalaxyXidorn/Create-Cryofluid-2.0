package net.galaxyxidorn.cryofluid.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

import static net.galaxyxidorn.cryofluid.CryoFluid.MOD_ID;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> CRYONITE_ORE_KEY = registerKey("cryonite_ore_placed");

    /**
     * pCount is the chance it can spawn
     * HeighRangePlacement.triangle means the ore will spawn most at the middle of the 2 values
     *                    .uniform means the ore will spawn at all the y levels uniformly */
    public static void bootstrap(BootstrapContext<PlacedFeature> ctx) {
        var configuredFeatures = ctx.lookup(Registries.CONFIGURED_FEATURE);

        register(ctx, CRYONITE_ORE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRYONITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(24, HeightRangePlacement.triangle(VerticalAnchor.absolute(-59), VerticalAnchor.absolute(-8))));
    }

    public static ResourceKey<PlacedFeature> registerKey (String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> ctx, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> config,
                                 List<PlacementModifier> modifiers) {
        ctx.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }
}
