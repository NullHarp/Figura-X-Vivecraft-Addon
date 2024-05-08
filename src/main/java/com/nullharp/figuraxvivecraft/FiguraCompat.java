package com.nullharp.figuraxvivecraft;

import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Matrix4f;
import net.blf02.vrapi.api.IVRAPI;
import net.blf02.vrapi.api.data.IVRData;
import net.blf02.vrapi.common.VRAPI;
import net.blf02.vrapi.data.VRData;
import net.minecraft.client.GuiMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Screenshot;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.figuramc.figura.FiguraMod;
import org.figuramc.figura.avatar.Avatar;
import org.figuramc.figura.avatar.AvatarManager;
import org.figuramc.figura.config.Configs;
import org.figuramc.figura.ducks.GuiMessageAccessor;
import org.figuramc.figura.lua.LuaNotNil;
import org.figuramc.figura.lua.LuaWhitelist;
import org.figuramc.figura.lua.api.entity.EntityAPI;
import org.figuramc.figura.lua.api.world.ItemStackAPI;
import org.figuramc.figura.lua.docs.LuaFieldDoc;
import org.figuramc.figura.lua.docs.LuaMethodDoc;
import org.figuramc.figura.lua.docs.LuaMethodOverload;
import org.figuramc.figura.lua.docs.LuaTypeDoc;
import org.figuramc.figura.math.matrix.FiguraMat4;
import org.figuramc.figura.math.matrix.FiguraMatrix;
import org.figuramc.figura.math.vector.FiguraVec3;
import org.figuramc.figura.mixin.LivingEntityAccessor;
import org.figuramc.figura.mixin.gui.ChatComponentAccessor;
import org.figuramc.figura.mixin.gui.ChatScreenAccessor;
import org.figuramc.figura.model.rendering.texture.FiguraTexture;
import org.figuramc.figura.utils.ColorUtils;
import org.figuramc.figura.utils.LuaUtils;
import org.figuramc.figura.utils.TextUtils;
import org.figuramc.figura.utils.LuaUtils;

import java.util.*;

@LuaWhitelist
@LuaTypeDoc(
        name = "VR",
        value = "vr"
)
public class FiguraCompat {
    Player player = Minecraft.getInstance().player;
    IVRAPI vrApi = VRPlugin.vrAPI;

    public IVRData getData(String type) {
        vrApi = VRPlugin.vrAPI;
        player = Minecraft.getInstance().player;
        if (Objects.equals(type, "left_controller")) {
            return vrApi.getVRPlayer(player).getController(1);
        } else if (Objects.equals(type, "right_controller")) {
            return vrApi.getVRPlayer(player).getController(0);
        } else if (Objects.equals(type, "headset")) {
            return vrApi.getVRPlayer(player).getHMD();
        } else {
            return null;
        }
    }


    @LuaWhitelist
    @LuaMethodDoc("vr.is_player_vr")
    public boolean isPlayerVr() {

        return vrApi.playerInVR(player);
    }
    @LuaWhitelist
    @LuaMethodDoc("vr.get_look_angle")
    public FiguraVec3  getLookAngle(@LuaNotNil String type) {
        IVRData vrData = getData(type);
        if (vrData == null) return null;
        return FiguraVec3.fromVec3(vrData.getLookAngle());

    }
    @LuaWhitelist
    @LuaMethodDoc("vr.get_pitch")
    public float getPitch(@LuaNotNil String type) {
        IVRData vrData = getData(type);
        if (vrData != null) {
            return vrData.getPitch();
        } else return -1;

    }
    @LuaWhitelist
    @LuaMethodDoc("vr.get_yaw")
    public float getYaw(@LuaNotNil String type) {
        IVRData vrData = getData(type);
        if (vrData != null) {
            return vrData.getYaw();
        } else return -1;
    }
    @LuaWhitelist
    @LuaMethodDoc("vr.get_roll")
    public float getRoll(@LuaNotNil String type) {
        IVRData vrData = getData(type);
        if (vrData != null) {
            return vrData.getRoll();
        } else return -1;
    }
    @LuaWhitelist
    @LuaMethodDoc("vr.get_position")
    public FiguraVec3 getPosition(@LuaNotNil String type) {
        IVRData vrData = getData(type);
        if (vrData != null) {
            return FiguraVec3.fromVec3(vrData.position());
        } else return null;
    }
    @LuaWhitelist
    @LuaMethodDoc("vr.get_rotation_matrix")
    public FiguraMat4 getRotationMatrix(@LuaNotNil String type) {
        IVRData vrData = getData(type);
        Matrix4f mat = vrData.getRotationMatrix();
        FiguraMat4 matNew = new FiguraMat4();
        matNew.set(mat);
        if (vrData != null) {
            return matNew;
        } else return null;

    }
    @LuaWhitelist
    @LuaMethodDoc("vr.blank")
    public String blank(@LuaNotNil String type) {
        return type;
    }
}
