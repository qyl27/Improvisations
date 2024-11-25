package cx.rain.mc.improvisations;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Properties;

public class Improvisations {
    public static final String MODID = "improvisations";

    public static final String NAME = "Improvisations";
    public static final String VERSION;
    public static final OffsetDateTime BUILD_TIME;

    static {
        var properties = new Properties();
        String version;
        OffsetDateTime buildTime;
        try {
            properties.load(Improvisations.class.getResourceAsStream("/build_info.properties"));
            version = properties.getProperty("mod_version");
            buildTime = OffsetDateTime.parse(properties.getProperty("build_time"));
        } catch (IOException ex) {
            version = "Unknown";
            // B.C. 3200
            buildTime = OffsetDateTime.of(-3200, 2, 29, 21, 34, 0, 0, ZoneOffset.ofHours(8));
        }
        VERSION = version;
        BUILD_TIME = buildTime;
    }

    public static void init() {
    }

    public static void initClient() {
    }
}
