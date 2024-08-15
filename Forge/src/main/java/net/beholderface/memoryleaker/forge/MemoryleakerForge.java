package net.beholderface.memoryleaker.forge;

import dev.architectury.platform.forge.EventBuses;
import net.beholderface.memoryleaker.Memoryleaker;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * This is your loading entrypoint on forge, in case you need to initialize
 * something platform-specific.
 */
@Mod(Memoryleaker.MOD_ID)
public class MemoryleakerForge {
    public MemoryleakerForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(Memoryleaker.MOD_ID, bus);
        bus.addListener(MemoryleakerClientForge::init);
        Memoryleaker.init();
    }
}
