package com.cinderous.crystalarchitect.blocks;

import com.cinderous.crystalarchitect.CrystalArchitect;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem {
    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(CrystalArchitect.TAB));
    }
}
