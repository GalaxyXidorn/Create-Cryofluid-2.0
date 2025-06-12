package net.galaxyxidorn.cryofluid.item.custom;

import net.galaxyxidorn.cryofluid.component.ModDataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.Objects;

public class BreezeFreezerBlockItem extends BlockItem {
    public BreezeFreezerBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if (!player.level().isClientSide() && entity.getType() == EntityType.BREEZE) {
            if (Boolean.TRUE.equals(stack.get(ModDataComponents.CAPTURED))) return InteractionResult.PASS;
            player.level().playSound(null, BlockPos.containing(entity.position()), SoundEvents.BREEZE_HURT, SoundSource.HOSTILE, .25f, .75f);
            entity.discard();
            stack.set(ModDataComponents.CAPTURED, true);
        }
        return InteractionResult.SUCCESS;
    }

//    private void spawnCaptureEvents(Level world, Vec3 vec3) {}

//    For Debug
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (stack.get(ModDataComponents.CAPTURED) != null) {
            tooltipComponents.add(Component.literal(Objects.requireNonNull(stack.get(ModDataComponents.CAPTURED)).toString()));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
