package com.nullharp.figuraxvivecraft;

import net.blf02.forge.VRAPIPlugin;
import net.blf02.forge.VRAPIPluginProvider;
import net.blf02.vrapi.api.IVRAPI;

@VRAPIPlugin
public class VRPlugin implements VRAPIPluginProvider {

    public static IVRAPI vrAPI = null;

    @Override
    public void getVRAPI(IVRAPI ivrapi) {
        vrAPI = ivrapi;
        VRPluginStatus.hasPlugin = true;
    }
}