package net.beholderface.memoryleaker.forge;

import net.beholderface.memoryleaker.MemoryleakerAbstractions;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class MemoryleakerAbstractionsImpl {
    /**
     * This is the actual implementation of {@link MemoryleakerAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
	
    public static void initPlatformSpecific() {

    }
}
