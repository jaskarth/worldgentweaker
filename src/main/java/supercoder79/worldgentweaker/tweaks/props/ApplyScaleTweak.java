package supercoder79.worldgentweaker.tweaks.props;

import net.minecraft.world.biome.Biome;
import supercoder79.worldgentweaker.api.Tweak;

public class ApplyScaleTweak implements Tweak<Biome> {
    private final float scale;

    public ApplyScaleTweak(float scale) {
        this.scale = scale;
    }

    @Override
    public void apply(Biome biome) {
        biome.scale = this.scale;
    }
}
