package com.cinderous.crystalarchitect.items;

import com.cinderous.crystalarchitect.CrystalArchitect;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {


    public ItemBase( ) {
        super(new Item.Properties().group(CrystalArchitect.TAB));
    }
}
