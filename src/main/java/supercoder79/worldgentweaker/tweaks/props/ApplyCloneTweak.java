package supercoder79.worldgentweaker.tweaks.props;

import net.minecraft.world.biome.Biome;
import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.IOUtils;
import supercoder79.worldgentweaker.api.Tweak;

public class ApplyCloneTweak implements Tweak<Biome> {
    private final String id;

    public ApplyCloneTweak(String id) {
        this.id = id;
    }

    @Override
    public void apply(Biome biome) {

    }
}
