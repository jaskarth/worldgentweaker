package supercoder79.worldgentweaker;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import supercoder79.worldgentweaker.api.Target;
import supercoder79.worldgentweaker.api.Tweak;
import supercoder79.worldgentweaker.targets.BiomeTarget;
import supercoder79.worldgentweaker.targets.DeferredBiomeTarget;
import supercoder79.worldgentweaker.tweaks.color.*;
import supercoder79.worldgentweaker.tweaks.props.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// massive state machine that handles all the tweak parsing.
public class TweakReader {
    public static final List<Target> targets = new ArrayList<>();
    public static final List<Target> deferred = new ArrayList<>();
    private static Identifier executionBiome;
    private static final List<Tweak<Biome>> tweaks = new ArrayList<>();

    public static void executeTweakScript(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                executeLine(line);
                line = reader.readLine();
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error with " + file.getPath() + "!");
            e.printStackTrace();
        }
    }

    private static void executeLine(String line) {
        if (line.startsWith("//")) return;

        String[] tokens = line.split(" ");
        if (tokens.length == 0) return;

        switch (tokens[0]) {
            case "tweak":
                ensureSize(tokens, line, 3);
                switch (tokens[1]) {
                    case "biome":
                        setupTweak(tokens[2]);
                        break;
                }
                break;
            case "apply":
                ensureSize(tokens, line, 3);
                switch (tokens[1]) {
                    case "depth":
                        tweaks.add(new ApplyDepthTweak(Float.parseFloat(tokens[2])));
                        break;
                    case "scale":
                        tweaks.add(new ApplyScaleTweak(Float.parseFloat(tokens[2])));
                        break;
                    case "temperature":
                        tweaks.add(new ApplyTemperatureTweak(Float.parseFloat(tokens[2])));
                        break;
                    case "downfall":
                        tweaks.add(new ApplyDownfallTweak(Float.parseFloat(tokens[2])));
                        break;
                    case "skycolor":
                        tweaks.add(new ApplySkyColorTweak(Integer.decode(tokens[2])));
                        break;
                    case "watercolor":
                        tweaks.add(new ApplyWaterColorTweak(Integer.decode(tokens[2])));
                        break;
                    case "waterfogcolor":
                        tweaks.add(new ApplyWaterFogColorTweak(Integer.decode(tokens[2])));
                        break;
                    case "fogcolor":
                        tweaks.add(new ApplyFogColorTweak(Integer.decode(tokens[2])));
                        break;
                }
                break;
            case "end":
                ensureSize(tokens, line, 1);
                endTweak();
                break;
        }
    }

    private static void setupTweak(String identifer) {
        System.out.println("Tweaking biome " + identifer);
        executionBiome = new Identifier(identifer);
    }

    private static void endTweak() {
        Biome b = Registry.BIOME.get(executionBiome);
        if (b != null) {
            targets.add(new BiomeTarget(b, new ArrayList<>(tweaks)));
        } else {
            deferred.add(new DeferredBiomeTarget(executionBiome, new ArrayList<>(tweaks)));
        }

        tweaks.clear();
    }

    private static void ensureSize(String[] tokens, String line, int size) {
        if (tokens.length < size) {
            System.out.println("Line \"" + line + "\" needs to have " + size + " elements!");
        }
    }
}
