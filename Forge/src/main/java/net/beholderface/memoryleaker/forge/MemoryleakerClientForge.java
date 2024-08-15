package net.beholderface.memoryleaker.forge;

import net.beholderface.memoryleaker.MemoryleakerClient;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Forge client loading entrypoint.
 */
public class MemoryleakerClientForge {
    public static void init(FMLClientSetupEvent event) {
        MemoryleakerClient.init();
    }
}
