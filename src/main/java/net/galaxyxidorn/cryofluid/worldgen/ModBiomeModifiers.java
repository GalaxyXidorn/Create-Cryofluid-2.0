package net.galaxyxidorn.cryofluid.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import static net.galaxyxidorn.cryofluid.CryoFluid.MOD_ID;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_CRYONITE_ORE = registerKey("add_cryonite_ore");

    public static void bootstrap(BootstrapContext<BiomeModifier> ctx) {
        var placedFeatures = ctx.lookup(Registries.PLACED_FEATURE);
        var biomes = ctx.lookup(Registries.BIOME);

        ctx.register(ADD_CRYONITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CRYONITE_ORE_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    private static ResourceKey<BiomeModifier> registerKey(String nane) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MOD_ID, nane));
    }
}
