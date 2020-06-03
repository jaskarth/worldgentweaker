package supercoder79.worldgentweaker.tweaks.color;

import net.minecraft.world.biome.Biome;
import supercoder79.worldgentweaker.api.Tweak;

public class ApplySkyColorTweak implements Tweak<Biome> {
    private final int skyColor;

    public ApplySkyColorTweak(int skyColor) {
        this.skyColor = skyColor;
    }

    @Override
    public void apply(Biome biome) {
        biome.skyColor = this.skyColor;
    }
}
