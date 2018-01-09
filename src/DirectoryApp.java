import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.HashMap;

/**
 * DirectoryApp registers Jersey resources and static asset bundles.
 */
public class DirectoryApp extends Application<DirectoryConfig>
{
    private Exchanges exchanges;

    public static void main(String[] args) throws Exception {
        new DirectoryApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<DirectoryConfig> bootstrap) {
        // nothing to do yet
        bootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html"));
    }

    @Override
    public void run(DirectoryConfig configuration,
                    Environment environment) {
        //Set exchanges
        setExchanges(configuration.getExchanges());
        //Set api url pattern.
        environment.jersey().setUrlPattern("/api/*");
        //resource declarations
        final DirectoryExchanges direx;
        direx = new DirectoryExchanges(exchanges);
        //environment registrations.
        environment.jersey().register(direx);
    }

    public DirectoryApp() {
        exchanges = null;
    }

    public void setExchanges(Exchanges exchanges)
    {
        this.exchanges = exchanges;
    }
}