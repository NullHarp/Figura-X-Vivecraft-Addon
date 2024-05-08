package com.nullharp.figuraxvivecraft;

import net.blf02.vrapi.api.IVRAPI;
import net.blf02.vrapi.common.VRAPI;
import net.blf02.vrapi.data.VRData;
import net.blf02.vrapi.data.VRPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.util.profiling.jfr.event.WorldLoadFinishedEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.logging.Logger;

public class EventHandler {
    @SubscribeEvent
    public void pickupItem(EntityItemPickupEvent event) {
        IVRAPI vrapi = VRAPI.VRAPIInstance;
        Player player = Minecraft.getInstance().player;
        System.out.println("Is VR: " + vrapi.playerInVR(player));
    }
}
