package com.lilyth.modules.listeners;

import com.lilyth.DSNEforge;
import com.lilyth.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.*;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class PlayerListener {
    private static final DSNEforge main = DSNEforge.getInstance();
    private final Config config = DSNEforge.getConfig();
    public long lastWorldJoin = -1L;
    public boolean HasNotRecentlyJoinedWorld() {
        return Minecraft.getSystemTime() - this.lastWorldJoin > 5000L;
    }
    public String list[] = {"Summoning Eye", "Ice Eye", "Cosmic Eye", "Radioactive Eye", "Flaming Eye", "Divine Eye"};
    @SubscribeEvent
    public void onWorldJoin(EntityJoinWorldEvent e) {
        Entity entity = e.entity;
        if(config.FULLBRIGHT){
            if(Minecraft.getMinecraft().gameSettings.gammaSetting!=100000){
                Minecraft.getMinecraft().gameSettings.gammaSetting = 100000;
            }
        }
        if (entity == Minecraft.getMinecraft().thePlayer){
            if(main.getFirstLoad().firstLoad()){
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("---\nThank you for using DSNE!\nYou can the config menu with /dsnf\nReport any bugs to iLilyth#1056\nplease wait a few seconds for your storage files to create\n---").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE).setBold(true)));
            }
            this.lastWorldJoin = Minecraft.getSystemTime();
        }
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayerSP p = mc.thePlayer;
        if(mc.thePlayer == null || mc.theWorld == null) return;
        if (event.phase == TickEvent.Phase.START) {
            main.getToggleSprint().autoSprint(event);
        }
        if(!main.getUtils().isOnDragsim() || !main.getPlayerListener().HasNotRecentlyJoinedWorld()) return;;
        if (event.phase == TickEvent.Phase.END) {
            if(config.INV_FULL_NOTIFIER){
                main.getInventoryUtils().showFullInventoryWarning();
            }
        }
    }

    @SubscribeEvent
    public void onChatMessageRecieved(ClientChatReceivedEvent event){
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayerSP p = mc.thePlayer;
        if(mc.thePlayer == null || mc.theWorld == null) return;
        if(!main.getUtils().isOnDragsim()) return;
        if(config.COPY_CHAT){
            main.getCopyChat().copyChat(event);
        }
        if(config.AUTO_COPY_CHAT){
            main.getAutoCopyChat().autoCopyChat(event);
        }
        if(config.DRAGON_NOTIFIER){
            main.getDivineSuperior().divineSuperior(event);
        }
        if(config.DRAGON_SPAWN){
            main.getDragonSpawn().dragonSpawn(event);
        }
        if(config.RARE_DROPS){
            main.getRareDropNotifier().dragonDown(event);
        }
        main.getEyesDropped().addEye(event);
    }

    @SubscribeEvent
    public void onEnderTeleport(EnderTeleportEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        if(mc.thePlayer == null || mc.theWorld == null) return;
        if(!main.getUtils().isOnDragsim() || !main.getPlayerListener().HasNotRecentlyJoinedWorld()) return;
        if (main.getUtils().isOnDragsim() && config.DISABLE_ENDERMAN_TP) {
            event.setCanceled(true);
        }
    }
}