package net.galaxyxidorn.cryofluid.worldgen;

import net.galaxyxidorn.cryofluid.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

import static net.galaxyxidorn.cryofluid.CryoFluid.MOD_ID;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRYONITE_ORE_KEY = registerKey("cryonite_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> ctx) {
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        List<OreConfiguration.TargetBlockState> cryoniteOres = List.of(OreConfiguration.target(deepslateReplaceables, ModBlocks.CRYONITE_ORE.get().defaultBlockState()));
        register(ctx, CRYONITE_ORE_KEY, Feature.ORE, new OreConfiguration(cryoniteOres, 14)); // size = size of the vein
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey (String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> ctx,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        ctx.register(key, new ConfiguredFeature<>(feature, config));
    }
}
