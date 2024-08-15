package net.beholderface.memoryleaker.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.beholderface.memoryleaker.MemoryleakerClient;

/**
 * Fabric client loading entrypoint.
 */
public class MemoryleakerClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MemoryleakerClient.init();
    }
}
