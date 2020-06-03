package supercoder79.worldgentweaker;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import supercoder79.worldgentweaker.api.Target;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Worldgentweaker implements ModInitializer {
    @Override
    public void onInitialize() {
        //Initialize tweaks folder
        File tweaksFolder = Paths.get(FabricLoader.getInstance().getConfigDirectory().getPath(), "worldgentweaker", "tweaks").toFile();
        if (!tweaksFolder.exists()) {
            tweaksFolder.mkdirs();
        }
        List<File> tweakFiles = new ArrayList<>();
        for (File file : tweaksFolder.listFiles()) {
            tryAddingTweak(file, tweakFiles);
        }

        tweakFiles.forEach(TweakReader::executeTweakScript);
        for (Target target : TweakReader.targets) {
            target.execute();
        }
    }

    private void tryAddingTweak(File file, List<File> tweakFiles) {
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                tryAddingTweak(child, tweakFiles);
            }
        } else {
            if (file.getPath().endsWith(".wgt")) {
                tweakFiles.add(file);
            }
        }
    }
}
