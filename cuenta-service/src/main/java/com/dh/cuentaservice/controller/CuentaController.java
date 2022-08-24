package com.dh.cuentaservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    //case 1
    @Value("${domain-mail-enabled}")
    private String[] domains;

    //case 2
    @Value("#{'${domain-mail-enabled}'.split(',')}")
    private List<String> listOfDomains;

    @Value("${server.port}")
    private String port;

    @Value("${message.specific-information}")
    private String message;

    @Value("${global-message}")
    private String globalMessage;

    @GetMapping
    public Map<String,String> getPropertiesFromConfigServer(){

        Map<String,String> properties = new HashMap<>();
        properties.put("port", port);
        properties.put("message", message);
        properties.put("global-message", globalMessage);
        //case 1
        properties.put("domain1", domains[0]);
        properties.put("domain2", domains[1]);
        properties.put("domain3", domains[2]);
        //case 2
        properties.put("domain1", listOfDomains.get(0));
        properties.put("domain2", listOfDomains.get(1));
        properties.put("domain3", listOfDomains.get(2));

        return properties;
    }

}
