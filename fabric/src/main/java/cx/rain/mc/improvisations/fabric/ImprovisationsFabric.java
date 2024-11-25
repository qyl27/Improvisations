package cx.rain.mc.improvisations.fabric;

import cx.rain.mc.improvisations.Improvisations;
import net.fabricmc.api.ModInitializer;

public class ImprovisationsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Improvisations.init();
    }
}
