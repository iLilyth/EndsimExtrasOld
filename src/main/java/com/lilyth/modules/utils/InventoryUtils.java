package com.lilyth.modules.utils;

import com.lilyth.DSNEforge;
import com.lilyth.config.Config;
import gg.essential.universal.ChatColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryUtils {
    private static final DSNEforge main = DSNEforge.getInstance();
    private final Config config = DSNEforge.getConfig();
    public void showFullInventoryWarning() {
        Minecraft mc = Minecraft.getMinecraft();
        if(hasOpenInventorySlots()) return;
        mc.thePlayer.playSound("random.orb", 0.5f, 1);
        mc.ingameGUI.displayTitle(ChatColor.RED + "INVENTORY FULL!", "", 0, 1, 0);
    }
    public static boolean hasOpenInventorySlots() {
        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
        IInventory inventory = player.inventory;
        int armorSlots = 5; // the number of armor slots
        int inventorySize = inventory.getSizeInventory();
        inventorySize = inventorySize - armorSlots;
        int emptySlots = 0;
        for (int i = 0; i < inventorySize; i++) {
            ItemStack itemStack = inventory.getStackInSlot(i);
            if (itemStack==null) {
                emptySlots++;
            }
        }
        return emptySlots > 0;
    }

}