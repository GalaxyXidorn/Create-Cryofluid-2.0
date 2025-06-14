package net.galaxyxidorn.cryofluid.item.custom;

import net.galaxyxidorn.cryofluid.component.ModDataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

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
            ItemStack newStack = stack.copy();
            newStack.set(ModDataComponents.CAPTURED, true);
            player.setItemInHand(hand, newStack);
        }
        return InteractionResult.SUCCESS;
    }

//    private void spawnCaptureEvents(Level world, Vec3 vec3) {}
}
