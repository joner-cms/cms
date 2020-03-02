package com.mzd.multipledatasources.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

@RestController
public class ProducerController {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;

    @PostMapping("/queue/test")
    public String sendQueue(@RequestBody String str){
        this.senMessage(this.queue,str);
        return "success";
    }
    @PostMapping("/topic/test")
    public String sendTopic(@RequestBody String str){
        this.senMessage(this.topic,str);
        return "success";
    }
    //发送消息，destination是发送的队列，messages是发送的内容
    private void senMessage(Destination destination,final String message){
        jmsMessagingTemplate.convertAndSend(destination,message);
    }
}
