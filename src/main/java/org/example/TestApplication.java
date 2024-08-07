package org.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.example.controllers.TestController;
import org.example.daos.TestDao;
import org.example.services.TestService;

public class TestApplication extends Application<TestConfiguration> {

    /**
     * Initialisation that runs the Test Application.
     *
     * @param args
     * @throws Exception
     */
    public static void main(final String[] args) throws Exception {
        new TestApplication().run(args);
    }

    /**
     * Retrieves Name.
     * @return Test
     */
    @Override
    public String getName() {
        return "Test";
    }

    /**
     * Initialization of the application.
     * @param bootstrap
     */
    @Override
    public void initialize(final Bootstrap<TestConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
                    final TestConfiguration configuration) {
                return configuration.getSwagger();
            }
        });
    }

    /**
     * Running the environment.
     * @param configuration
     * @param environment
     */
    @Override
    public void run(final TestConfiguration configuration,
                    final Environment environment) {
        environment.jersey()
                .register(new TestController(new TestService(new TestDao())));
    }

}
