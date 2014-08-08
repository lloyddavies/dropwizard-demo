package net.lloyddavies.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerDropwizard;
import net.lloyddavies.dropwizard.health.SimpleHealthCheck;
import net.lloyddavies.dropwizard.resources.BookResource;
import net.lloyddavies.dropwizard.services.BookService;

import java.io.IOException;

public class DropwizardDemoApplication extends Application<DropwizardDemoConfiguration> {

    private final SwaggerDropwizard swaggerDropwizard = new SwaggerDropwizard();

    public static void main(String[] args) throws Exception {
        new DropwizardDemoApplication().run(args);
    }

    @Override
    public String getName() {
        return "dw-demo";
    }

    @Override
    public void initialize(Bootstrap<DropwizardDemoConfiguration> bootstrap) {
        //Swagger intialization
        swaggerDropwizard.onInitialize(bootstrap);
    }

    @Override
    public void run(DropwizardDemoConfiguration configuration, Environment environment) throws IOException {

        environment.healthChecks().register("simple", new SimpleHealthCheck());
        environment.jersey().register(new BookResource(new BookService()));

        if (configuration.getSwaggerEnabled()){
            if (configuration.getSwaggerHost() == null || configuration.getSwaggerHost().isEmpty())
                swaggerDropwizard.onRun(configuration, environment);
            else
                swaggerDropwizard.onRun(configuration, environment, configuration.getSwaggerHost());
        }
    }
}