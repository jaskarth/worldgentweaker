package supercoder79.worldgentweaker.targets;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import supercoder79.worldgentweaker.api.Target;
import supercoder79.worldgentweaker.api.Tweak;

import java.util.List;

public class DeferredBiomeTarget implements Target {
    private final Identifier id;
    private final List<Tweak<Biome>> tweaks;

    public DeferredBiomeTarget(Identifier id, List<Tweak<Biome>> tweaks) {
        this.id = id;
        this.tweaks = tweaks;
    }

    @Override
    public void execute() {
        Biome biome = Registry.BIOME.get(id);
        tweaks.forEach((tweak) -> tweak.apply(biome));
    }

    public Identifier getId() {
        return id;
    }
}
