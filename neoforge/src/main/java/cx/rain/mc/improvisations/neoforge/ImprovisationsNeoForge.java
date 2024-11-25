package cx.rain.mc.improvisations.neoforge;

import cx.rain.mc.improvisations.Improvisations;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(Improvisations.MODID)
public class ImprovisationsNeoForge {
    public ImprovisationsNeoForge(ModContainer container, IEventBus bus) {
        bus.addListener(this::setupClient);

        Improvisations.init();
    }

    private void setupClient(FMLClientSetupEvent event) {
        Improvisations.initClient();
    }
}
