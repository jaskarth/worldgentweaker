package supercoder79.worldgentweaker.tweaks.color;

import net.minecraft.world.biome.Biome;
import supercoder79.worldgentweaker.api.Tweak;

public class ApplyFogColorTweak implements Tweak<Biome> {
    private final int fogColor;

    public ApplyFogColorTweak(int fogColor) {
        this.fogColor = fogColor;
    }

    @Override
    public void apply(Biome biome) {
        biome.effects.waterFogColor = this.fogColor;
    }
}
