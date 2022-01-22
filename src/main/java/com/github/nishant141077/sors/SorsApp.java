package com.github.nishant141077.sors;

import com.google.inject.Stage;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import lombok.extern.slf4j.Slf4j;
import ru.vyarus.dropwizard.guice.GuiceBundle;

@Slf4j
public class SorsApp extends Application<SorsConfig> {

  public static void main(String[] args) throws Exception {
    final SorsApp app = new SorsApp();
    app.run(args);
  }

  @Override
  public void initialize(Bootstrap<SorsConfig> bootstrap) {
    initConfigurations(bootstrap);
    initSwaggerBundle(bootstrap);
    initGuiceBundle(bootstrap);
  }

  private void initGuiceBundle(Bootstrap<SorsConfig> bootstrap) {
    bootstrap.addBundle(GuiceBundle.<SorsConfig>builder()
        .enableAutoConfig(getClass().getPackage().getName())
        .modules(new SorsModule())
        .build(Stage.PRODUCTION)
    );
  }

  private void initSwaggerBundle(Bootstrap<SorsConfig> bootstrap) {
    bootstrap.addBundle(new SwaggerBundle<SorsConfig>() {
      @Override
      protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(SorsConfig sorsConfig) {
        return sorsConfig.getSwagger();
      }
    });
  }

  private void initConfigurations(Bootstrap<SorsConfig> bootstrap) {
    bootstrap.setConfigurationSourceProvider(
        new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
            new EnvironmentVariableSubstitutor()));
  }

  @Override
  public void run(SorsConfig sorsConfig, Environment environment) throws Exception {
  }
}
