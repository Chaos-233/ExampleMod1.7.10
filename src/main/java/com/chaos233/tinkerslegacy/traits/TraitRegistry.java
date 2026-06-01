package com.chaos233.tinkerslegacy.traits;

import java.util.HashMap;
import java.util.Map;

public class TraitRegistry {

    private static final Map<String, IToolTrait> TRAITS = new HashMap<>();

    public static void register(IToolTrait trait) {
        TRAITS.put(trait.getTraitID(), trait);
    }

    public static IToolTrait get(String id) {
        return TRAITS.get(id);
    }
}
