package net.beholderface.memoryleaker.networking;

import dev.architectury.networking.NetworkChannel;
import net.minecraft.server.network.ServerPlayerEntity;

import static net.beholderface.memoryleaker.Memoryleaker.id;

public class MemoryleakerNetworking {
    private static final NetworkChannel CHANNEL = NetworkChannel.create(id("networking_channel"));

    public static void init() {

    }

    public static <T> void sendToServer(T message) {
        CHANNEL.sendToServer(message);
    }

    public static <T> void sendToPlayer(ServerPlayerEntity player, T message) {
        CHANNEL.sendToPlayer(player, message);
    }

    public static <T> void sendToPlayers(Iterable<ServerPlayerEntity> players, T message) {
        CHANNEL.sendToPlayers(players, message);
    }
}
