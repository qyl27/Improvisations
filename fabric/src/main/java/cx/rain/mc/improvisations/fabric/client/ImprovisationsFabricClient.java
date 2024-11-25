package cx.rain.mc.improvisations.fabric.client;

import cx.rain.mc.improvisations.Improvisations;
import net.fabricmc.api.ClientModInitializer;

public class ImprovisationsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Improvisations.initClient();
    }
}
