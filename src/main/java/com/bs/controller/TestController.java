package com.bs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Huang
 * @date CREATE IN 2018-03-19 00:24
 */
@Controller
@RequestMapping("/index")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(@RequestParam(value = "a",required = false,defaultValue = "aaaa") String a) {

        logger.info("34567890");
        return a+"ssssssss";
    }

}
