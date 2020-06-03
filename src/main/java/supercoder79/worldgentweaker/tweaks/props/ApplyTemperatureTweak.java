package supercoder79.worldgentweaker.tweaks.props;

import net.minecraft.world.biome.Biome;
import supercoder79.worldgentweaker.api.Tweak;

public class ApplyTemperatureTweak implements Tweak<Biome> {
    private final float temperature;

    public ApplyTemperatureTweak(float temperature) {
        this.temperature = temperature;
    }

    @Override
    public void apply(Biome biome) {
        biome.temperature = this.temperature;
    }
}
