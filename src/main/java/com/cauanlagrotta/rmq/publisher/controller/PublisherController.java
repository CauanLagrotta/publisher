package com.cauanlagrotta.rmq.publisher.controller;

import com.cauanlagrotta.rmq.publisher.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {
  @Value("${rabbitmq.queuename}")
  private String queueName;

  @Autowired
  private PublisherService publisherService;

  @PostMapping("/publish/text")
  public void publishText(@RequestBody String text){
    System.out.println("Sending: " + text);
    publisherService.publishTextMessage(text, queueName);
  }
}
