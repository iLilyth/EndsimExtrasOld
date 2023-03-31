package com.lilyth.modules.features.copychat;

import com.lilyth.DSNEforge;
import com.lilyth.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class AutoCopyChat {
    private static final DSNEforge main = DSNEforge.getInstance();
    private final Config config = DSNEforge.getConfig();
    int[] playSoundPitch = {1, 2, 3, 5, 8, 13};
    public void autoCopyChat(ClientChatReceivedEvent e) {
        Minecraft mc = Minecraft.getMinecraft();
        String msg = e.message.getUnformattedText();
        StringSelection stringSelection = new StringSelection(msg);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        if(msg.startsWith("RARE DROP! Summoning Eye")){
            if(config.AUTO_COPY_CHAT_FILTER<1){
                clipboard.setContents(stringSelection, null);
                mc.thePlayer.addChatMessage(new ChatComponentText("Drop copied to clipboard!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                for (int i = 0; i < playSoundPitch.length; i++) {
                    mc.thePlayer.playSound("random.orb", 1, playSoundPitch[i]);
                }
            }
        }else if(msg.startsWith("RARE DROP! Ice Eye")){
            if(config.AUTO_COPY_CHAT_FILTER<2) {
                clipboard.setContents(stringSelection, null);
                mc.thePlayer.addChatMessage(new ChatComponentText("Drop copied to clipboard!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                for (int i = 0; i < playSoundPitch.length; i++) {
                    mc.thePlayer.playSound("random.orb", 1, playSoundPitch[i]);
                }
            }
        }else if(msg.startsWith("RARE DROP! Cosmic Eye")){
            if(config.AUTO_COPY_CHAT_FILTER<3) {
                clipboard.setContents(stringSelection, null);
                mc.thePlayer.addChatMessage(new ChatComponentText("Drop copied to clipboard!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                for (int i = 0; i < playSoundPitch.length; i++) {
                    mc.thePlayer.playSound("random.orb", 1, playSoundPitch[i]);
                }
            }
        }else if(msg.startsWith("CRAZY RARE DROP! Radioactive Eye")){
            if(config.AUTO_COPY_CHAT_FILTER<4) {
                clipboard.setContents(stringSelection, null);
                mc.thePlayer.addChatMessage(new ChatComponentText("Drop copied to clipboard!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                for (int i = 0; i < playSoundPitch.length; i++) {
                    mc.thePlayer.playSound("random.anvil_land", 1, playSoundPitch[i]);
                }
            }
        }else if(msg.startsWith("RNGesus INCARNATE! Flaming Eye")){
            if(config.AUTO_COPY_CHAT_FILTER<5) {
                clipboard.setContents(stringSelection, null);
                mc.thePlayer.addChatMessage(new ChatComponentText("Drop copied to clipboard!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                for (int i = 0; i < playSoundPitch.length; i++) {
                    mc.thePlayer.playSound("mob.enderdragon.growl", 1, playSoundPitch[i]);
                }
            }
        }else if(msg.startsWith("RNGesus INCARNATE! Divine Eye")){
            if(config.AUTO_COPY_CHAT_FILTER<6) {
                clipboard.setContents(stringSelection, null);
                mc.thePlayer.addChatMessage(new ChatComponentText("Drop copied to clipboard!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                for (int i = 0; i < playSoundPitch.length; i++) {
                    mc.thePlayer.playSound("mob.enderdragon.growl", 1, playSoundPitch[i]);
                }
            }

        }else if(msg.startsWith("INSANE DROP! Divine Ameliorate")){
            if(config.AUTO_COPY_CHAT_FILTER<6){
                clipboard.setContents(stringSelection, null);
                mc.thePlayer.addChatMessage(new ChatComponentText("Drop copied to clipboard!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                for (int i = 0; i < playSoundPitch.length; i++) {
                    mc.thePlayer.playSound("mob.wither.death", 1, playSoundPitch[i]);
                }
            }
        }
    }

}
