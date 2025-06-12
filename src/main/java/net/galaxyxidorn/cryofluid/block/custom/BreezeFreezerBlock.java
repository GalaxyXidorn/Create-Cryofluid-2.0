package net.galaxyxidorn.cryofluid.block.custom;

import com.mojang.serialization.MapCodec;
import net.galaxyxidorn.cryofluid.component.ModDataComponents;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

public class BreezeFreezerBlock extends HorizontalDirectionalBlock {
    public static final BooleanProperty CAPTURED = BooleanProperty.create("captured");

    public static final MapCodec<BreezeFreezerBlock> CODEC = simpleCodec(BreezeFreezerBlock::new);

    public BreezeFreezerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(CAPTURED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(CAPTURED, FACING);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(CAPTURED, context.getItemInHand().get(ModDataComponents.CAPTURED) == null ? false : context.getItemInHand().get(ModDataComponents.CAPTURED));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }
}
