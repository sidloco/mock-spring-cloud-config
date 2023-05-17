package com.example.servicea.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configs")
@RefreshScope
@ConfigurationProperties
public class TestController {

  @Value("${hello.message}")
  private String helloMessage;

  @Value("${hello.db}")
  private String helloDb;

  @GetMapping("")
  public String getConfigs() {
    return " " + helloMessage +  " ------ " + helloDb;
  }
}
