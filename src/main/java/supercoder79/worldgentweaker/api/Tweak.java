package supercoder79.worldgentweaker.api;

import net.minecraft.world.biome.Biome;

public interface Tweak<T> {
    void apply(T biome);
}
