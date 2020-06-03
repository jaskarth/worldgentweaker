package supercoder79.worldgentweaker.tweaks.props;

import net.minecraft.world.biome.Biome;
import supercoder79.worldgentweaker.api.Tweak;

public class ApplyDownfallTweak implements Tweak<Biome> {
    private final float downfall;

    public ApplyDownfallTweak(float downfall) {
        this.downfall = downfall;
    }

    @Override
    public void apply(Biome biome) {
        biome.downfall = this.downfall;
    }
}
