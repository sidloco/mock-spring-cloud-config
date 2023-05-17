package com.example.serviceb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configs")
@RefreshScope
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
