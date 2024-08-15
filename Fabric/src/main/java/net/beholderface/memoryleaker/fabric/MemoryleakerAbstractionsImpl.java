package net.beholderface.memoryleaker.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.beholderface.memoryleaker.MemoryleakerAbstractions;

import java.nio.file.Path;

public class MemoryleakerAbstractionsImpl {
    /**
     * This is the actual implementation of {@link MemoryleakerAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
	
    public static void initPlatformSpecific() {

    }
}
