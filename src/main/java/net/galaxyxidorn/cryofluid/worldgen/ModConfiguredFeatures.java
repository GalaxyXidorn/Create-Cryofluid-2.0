package net.galaxyxidorn.cryofluid.worldgen;

import net.galaxyxidorn.cryofluid.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

import static net.galaxyxidorn.cryofluid.CryoFluid.MOD_ID;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYONITE_ORE_KEY = registerKey("cryonite_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> ctx) {
        register(ctx, CRYONITE_ORE_KEY, Feature.GEODE, new GeodeConfiguration(
                new GeodeBlockSettings(
                        BlockStateProvider.simple(ModBlocks.CRYONITE_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.CRYONITE_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.CRYONITE_ORE.get()),
                        BlockStateProvider.simple(ModBlocks.FROZEN_DEEPSLATE.get()),
                        BlockStateProvider.simple(ModBlocks.FROZEN_DEEPSLATE.get()),
                        List.of(Blocks.AIR.defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE,
                        BlockTags.GEODE_INVALID_BLOCKS
                ),
                new GeodeLayerSettings(1.0, 2.0, 2.0, 3.0),
                new GeodeCrackSettings(0.0, 0.75, 2),
                0.35,
                0.0,
                false,
                ConstantInt.of(1),
                ConstantInt.of(1),
                ConstantInt.of(0),
                -16,
                16,
                0.0,
                1
        ));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey (String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> ctx,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        ctx.register(key, new ConfiguredFeature<>(feature, config));
    }
}
