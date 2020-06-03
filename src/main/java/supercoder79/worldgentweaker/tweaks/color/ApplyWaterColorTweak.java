package supercoder79.worldgentweaker.tweaks.color;

import net.minecraft.world.biome.Biome;
import supercoder79.worldgentweaker.api.Tweak;

public class ApplyWaterColorTweak implements Tweak<Biome> {
    private final int waterColor;

    public ApplyWaterColorTweak(int waterColor) {
        this.waterColor = waterColor;
    }

    @Override
    public void apply(Biome biome) {
        biome.effects.waterColor = this.waterColor;
    }
}
