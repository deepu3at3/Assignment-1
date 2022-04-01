package com.example.assignment.controller;


import com.example.assignment.model.Info;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/cf")
public class CfController {



    @GetMapping("/")
    public ResponseEntity<List<Info>> getCfData()
    {

        List<Info> infoArray=new ArrayList<Info>();
        RestTemplate restTemplate=new RestTemplate();
        String pivotUrl="https://api.run.pivotal.io/v2/info";
        String bluemixUrl="https://api.ng.bluemix.net/v2/info";
        infoArray.add(restTemplate.getForObject(pivotUrl,Info.class));
        infoArray.add(restTemplate.getForObject(bluemixUrl,Info.class));
        return new ResponseEntity<List<Info>>(infoArray, HttpStatus.OK);

    }

    @RequestMapping(value="/{provider:PWC|BLU}",method=RequestMethod.GET)
    public ResponseEntity<String> getSelectedProvider(@ApiParam(value="value must be PWC|BLU",required=true) @PathVariable("provider") String provider)
    {

        RestTemplate restTemplate=new RestTemplate();
        String url=(provider.equals("PWC"))?"https://api.run.pivotal.io/v2/info":"https://api.ng.bluemix.net/v2/info";
        return restTemplate.getForEntity(url,String.class);
    }




}
