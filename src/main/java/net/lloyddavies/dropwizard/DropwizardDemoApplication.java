package net.lloyddavies.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import net.lloyddavies.dropwizard.health.SimpleHealthCheck;
import net.lloyddavies.dropwizard.resources.BookResource;
import net.lloyddavies.dropwizard.services.BookService;

public class DropwizardDemoApplication extends Application<DropwizardDemoConfiguration> {
    public static void main(String[] args) throws Exception {
        new DropwizardDemoApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard-demo";
    }

    @Override
    public void initialize(Bootstrap<DropwizardDemoConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(DropwizardDemoConfiguration configuration, Environment environment) {
        environment.healthChecks().register("simple", new SimpleHealthCheck());
        environment.jersey().register(new BookResource(new BookService()));
    }
}