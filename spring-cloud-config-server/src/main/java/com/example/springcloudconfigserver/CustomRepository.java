package com.example.springcloudconfigserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomRepository implements EnvironmentRepository {

  @Override
  public Environment findOne(String application, String profile, String label) {
    Environment environment = new Environment(application, profile);
    final Map<String, String> properties = getConfigs(application, profile);
    environment.add(new PropertySource("mapPropertySource", properties));
    return environment;
  }

  private Map<String, String> getConfigs(String application, String profile) {
    System.out.println(profile + " / " + application);
    Map<String, String> configMap = new HashMap<>();
    configMap.put("hello.message", "Hello from custom repository akbdadkj");
    return configMap;
  }
}
