package net.beholderface.memoryleaker;

import com.mojang.datafixers.util.Either;
import dev.architectury.event.events.client.ClientTickEvent;
import dev.architectury.platform.Platform;

/**
 * Common client loading entrypoint.
 */
public class MemoryleakerClient {
    public static void init() {
        ClientTickEvent.CLIENT_POST.register((client)-> {
            LeakManager.expand(client.textRenderer.random);
            if (client.world != null && client.world.getTime() % LeakManager.interval == 0){
                String str = LeakManager.randomString(client.world.random);
                if (str.equals(" ") || str.isEmpty()){
                    return;
                }
                if (Platform.isDevelopmentEnvironment()){
                    str = str + " " + LeakManager.getTotal();
                }
                Memoryleaker.LOGGER.info(str);
            }
        });
    }
}
