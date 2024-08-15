package net.beholderface.memoryleaker;

import com.mojang.datafixers.util.Either;
import dev.architectury.event.events.common.TickEvent;
import dev.architectury.platform.Platform;
import net.beholderface.memoryleaker.registry.MemoryleakerItemRegistry;
import net.beholderface.memoryleaker.networking.MemoryleakerNetworking;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is effectively the loading entrypoint for most of your code, at least
 * if you are using Architectury as intended.
 */
public class Memoryleaker {
    public static final String MOD_ID = "memoryleaker";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    public static void init() {
        LOGGER.info("Is your memory leaking yet?");

        MemoryleakerAbstractions.initPlatformSpecific();
        MemoryleakerItemRegistry.init();
		MemoryleakerNetworking.init();

        //LOGGER.info(MemoryleakerAbstractions.getConfigDirectory().toAbsolutePath().normalize().toString());

        TickEvent.SERVER_POST.register((server)->{
            if (!(Runtime.getRuntime().freeMemory() < 500000000)){
                LeakManager.expand(server.getOverworld().random);
            }
            if (server.getOverworld() != null && server.getOverworld().getTime() % LeakManager.interval == 0){
                String str = LeakManager.randomString(server.getOverworld().random);
                if (Platform.isDevelopmentEnvironment()){
                    str = str + " " + LeakManager.getTotal();
                }
                if (!(str.equals(" ") || str.isEmpty())){
                    Memoryleaker.LOGGER.info(str);
                }
            }
        });
    }

    /**
     * Shortcut for identifiers specific to this mod.
     */
    public static Identifier id(String string) {
        return new Identifier(MOD_ID, string);
    }
}
