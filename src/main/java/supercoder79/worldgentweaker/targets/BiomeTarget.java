package supercoder79.worldgentweaker.targets;

import net.minecraft.world.biome.Biome;
import supercoder79.worldgentweaker.api.Target;
import supercoder79.worldgentweaker.api.Tweak;

import java.util.List;

public class BiomeTarget implements Target {
    private final Biome biome;
    private final List<Tweak<Biome>> tweaks;

    public BiomeTarget(Biome biome, List<Tweak<Biome>> tweaks) {
        this.biome = biome;
        this.tweaks = tweaks;
    }

    @Override
    public void execute() {
        tweaks.forEach((tweak) -> tweak.apply(biome));
    }
}
