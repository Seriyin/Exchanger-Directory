package app;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import model.Companies;
import model.Exchanges;
import resources.*;

/**
 * DirectoryApp registers Jersey resources and static asset bundles.
 */
public class DirectoryApp extends Application<DirectoryConfig>
{
    private Exchanges exchanges;
    private Companies companies;

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
        setCompanies(exchanges);
        //Set api url pattern.
        environment.jersey().setUrlPattern("/api/*");

        declareResourcesAndRegister(environment);
    }

    private void declareResourcesAndRegister(Environment environment)
    {
        //resource declarations
        final DirectoryExchanges direx;
        direx = new DirectoryExchanges(exchanges);
        final DirectoryCompanies compex;
        compex = new DirectoryCompanies(companies);
        final DirectoryExchangeCompanies direxcomp;
        direxcomp = new DirectoryExchangeCompanies(exchanges);
        final DirectoryStats dirstat;
        dirstat = new DirectoryStats(exchanges);
        final DirectoryStatsDay dirstdy;
        dirstdy = new DirectoryStatsDay(exchanges);

        //environment registrations.
        environment.jersey().register(direx);
        environment.jersey().register(compex);
        environment.jersey().register(direxcomp);
        environment.jersey().register(dirstat);
        environment.jersey().register(dirstdy);
    }

    private void declareResources()
    {
    }

    public DirectoryApp() {
        exchanges = null;
        companies = null;
    }

    public void setExchanges(Exchanges exchanges)
    {
        this.exchanges = exchanges;
    }

    public void setCompanies(Exchanges exchanges) {
        this.companies = new Companies(exchanges);
    }
}