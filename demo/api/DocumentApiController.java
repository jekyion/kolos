package com.example.demo.api;

import com.example.demo.dto.DocumentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/api")
public class DocumentApiController {

    private static final Logger LOGGER =  LoggerFactory.getLogger(DocumentApiController.class);
    @RequestMapping(value = "/document/test", method = RequestMethod.POST)



    public ResponseEntity<Void> testDocument(@RequestBody DocumentDto documentDto) {
        LOGGER.info("###Dziala");
       String x=documentDto.getName();



       if(isPalindrome(x)) {
           return new ResponseEntity<>(HttpStatus.OK);
       }else
       {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }



}
    private boolean isPalindrome(String text) {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        int length = clean.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = clean.charAt(forward++);
            char backwardChar = clean.charAt(backward--);
            if (forwardChar != backwardChar)
                return false;
        }
        return true;
    }
}