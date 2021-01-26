package com.example.demo.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
public class FirstApiController {

    private static final Logger LOG = LoggerFactory.getLogger(FirstApiController.class);

    @GetMapping("/api/math/digits/{digits}")

    public ResponseEntity<Map<String, String>> getAverage(@PathVariable("digits") String digits) {

        LOG.info("*** digits inside server: {}", digits);

        return ResponseEntity.ok(calculateAverage(digits));
    }
    private Map<String, String> calculateAverage(String digits){
       String[] digitsAsArrayOfString = digits.split(",");


       String wyp="";
       for(int i=0; i< digitsAsArrayOfString.length;i++){

          if(Integer.parseInt(digitsAsArrayOfString[i]) % 2 == 0){
              if(wyp.contains(digitsAsArrayOfString[i]))
                  continue;
              wyp+=digitsAsArrayOfString[i]+",";

          }
       }
       if(wyp.length()>1){
            wyp=wyp.substring(0,wyp.length()-1);
       }

       Map<String,String> result = new HashMap<>();


       result.put("average",wyp);
       return result;
    }
}
