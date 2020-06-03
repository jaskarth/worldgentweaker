package supercoder79.worldgentweaker.tweaks.props;

import net.minecraft.world.biome.Biome;
import supercoder79.worldgentweaker.api.Tweak;

public class ApplyDepthTweak implements Tweak<Biome> {
    private final float depth;

    public ApplyDepthTweak(float depth) {
        this.depth = depth;
    }

    @Override
    public void apply(Biome biome) {
        biome.depth = this.depth;
    }
}
