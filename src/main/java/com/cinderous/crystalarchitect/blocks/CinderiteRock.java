package com.cinderous.crystalarchitect.blocks;

//import com.cinderous.crystalarchitect.particles.ColouredParticle;
import com.cinderous.crystalarchitect.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.stream.Stream;

public class CinderiteRock extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 2, 7, 9, 3, 9),
            Block.makeCuboidShape(7, 2, 5, 9, 3, 6),
            Block.makeCuboidShape(5, 2, 10, 7, 3, 11),
            Block.makeCuboidShape(10, 1, 7, 12, 2, 8),
            Block.makeCuboidShape(8, 3, 8, 11, 5, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(7, 2, 7, 9, 3, 9),
            Block.makeCuboidShape(5, 2, 7, 6, 3, 9),
            Block.makeCuboidShape(10, 2, 9, 11, 3, 11),
            Block.makeCuboidShape(7, 1, 4, 8, 2, 6),
            Block.makeCuboidShape(8, 3, 5, 9, 5, 8)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(7, 2, 7, 9, 3, 9),
            Block.makeCuboidShape(7, 2, 10, 9, 3, 11),
            Block.makeCuboidShape(9, 2, 5, 11, 3, 6),
            Block.makeCuboidShape(4, 1, 8, 6, 2, 9),
            Block.makeCuboidShape(5, 3, 7, 8, 5, 8)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(7, 2, 7, 9, 3, 9),
            Block.makeCuboidShape(10, 2, 7, 11, 3, 9),
            Block.makeCuboidShape(5, 2, 5, 6, 3, 7),
            Block.makeCuboidShape(8, 1, 10, 9, 2, 12),
            Block.makeCuboidShape(7, 3, 8, 8, 5, 11)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public CinderiteRock() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(5.0f,6.0f)
                .sound(SoundType.GROUND)
        );
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }


    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

//    /**
//     * Returns the blockstate with the given rotation from the passed blockstate. If
//     * inapplicable, returns the passed blockstate.
//     *
//     * @deprecated call via {@link IBlockState#withRotation(Rotation)} whenever
//     *             possible. Implementing/overriding is fine.
//     */
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

//    /**
//     * Returns the blockstate with the given mirror of the passed blockstate. If
//     * inapplicable, returns the passed blockstate.
//     *
//    // * @deprecated call via {@link IBlockState#withMirror(Mirror)} whenever
//     *             possible. Implementing/overriding is fine.
//     */
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    //@Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == RegistryHandler.CINDIRT.get() || block == RegistryHandler.CINDIRT_GRASS.get();
    }


//    @Override
//    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
//                                             Hand handIn, BlockRayTraceResult result) {
//        /*
//         * if (!worldIn.isRemote()) { ServerWorld serverWorld = (ServerWorld) worldIn;
//         * LightningBoltEntity entity = new LightningBoltEntity(worldIn, pos.getX(),
//         * pos.getY(), pos.getZ(), false); serverWorld.addLightningBolt(entity); }
//         */
//        worldIn.addParticle(new ColouredParticle.ColouredParticleData(0.0f, 1.0f, 0.0f, 1.0f), pos.getX() + 0.5f,
//                pos.getY() + 0.5f, pos.getZ() + 0.5f, 0.0f, 0.0f, 0.0f);
//        return ActionResultType.SUCCESS;
//    }
}
