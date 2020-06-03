package supercoder79.worldgentweaker.tweaks.color;

import net.minecraft.world.biome.Biome;
import supercoder79.worldgentweaker.api.Tweak;

public class ApplyWaterFogColorTweak implements Tweak<Biome> {
    private final int waterFogColor;

    public ApplyWaterFogColorTweak(int waterFogColor) {
        this.waterFogColor = waterFogColor;
    }

    @Override
    public void apply(Biome biome) {
        biome.effects.waterFogColor = this.waterFogColor;
    }
}
