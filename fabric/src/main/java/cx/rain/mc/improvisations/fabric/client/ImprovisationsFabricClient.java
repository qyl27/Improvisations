package cx.rain.mc.improvisations.fabric.client;

import cx.rain.mc.improvisations.client.ImprovisationsClient;
import net.fabricmc.api.ClientModInitializer;

public class ImprovisationsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ImprovisationsClient.initClient();
    }
}
