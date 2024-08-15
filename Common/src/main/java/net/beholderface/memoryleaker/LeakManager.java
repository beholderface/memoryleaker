package net.beholderface.memoryleaker;

import net.minecraft.util.math.random.Random;

import java.util.*;

public class LeakManager {
    public static final int interval = 1200;
    private static final Map<UUID, List<String>> expandingMap = new HashMap<>();
    private static long total = 0;
    public static final String[] wackyStrings = {"why do they call it oven when they of in the cold food of out hot eat the food",
    " uwu ", "you will find 100 grams of sand in your bed", "people die when they are killed", "silksong", "you're mother", "what happened to three and four?",
    "amogus", "the plural of moose is meese", "SCP-2521", "promoted to conductor", "Roko's Basilisk", "more people have been to berlin than I have"};

    public static void expand(Random random){
        List<String> stringList = new ArrayList<>();
        int count = random.nextBetween(1000, 5000);
        for (int i = 0; i < count; i++){
            String wacky = wackyStrings[random.nextBetween(0, wackyStrings.length - 1)];
            int start = random.nextBetween(0, wacky.length());
            int end = random.nextBetween(start, wacky.length());
            stringList.add(wacky.substring(start, end));
        }
        total += count;
        expandingMap.put(UUID.randomUUID(), stringList);
    }

    public static String randomString(Random random){
        if (expandingMap.isEmpty()){
            expand(random);
        }
        Object[] keys;
        try {
            keys = expandingMap.keySet().toArray();
        } catch (IndexOutOfBoundsException e){
            keys = new Object[]{expandingMap.keySet().iterator().next()};
        }
        UUID key;
        try {
            key = (UUID) keys[Math.min(random.nextBetween(0, keys.length -1), keys.length - 2)];
        } catch (IndexOutOfBoundsException exception){
            key = (UUID)keys[0];
        }
        List<String> strings = expandingMap.get(key);
        return strings.get(random.nextBetween(0, strings.size() - 1));
    }

    public static long getTotal(){
        return total;
    }
}
