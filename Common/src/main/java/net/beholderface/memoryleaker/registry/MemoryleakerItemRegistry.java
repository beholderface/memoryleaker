package net.beholderface.memoryleaker.registry;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.beholderface.memoryleaker.Memoryleaker;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

import static net.beholderface.memoryleaker.Memoryleaker.id;

public class MemoryleakerItemRegistry {
    // Register items through this
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Memoryleaker.MOD_ID, Registry.ITEM_KEY);

    public static void init() {
        ITEMS.register();
    }


}
