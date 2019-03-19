package com.frank.web;

import com.frank.handdler.YourException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: xu.wr
 * @create: 2019-03-14 14:50
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping(value="/{name}", method= RequestMethod.GET)
    public String say(@PathVariable String name) throws YourException {
        if (!"frank".equals(name)){
            throw new YourException("It's not Frank");
        }
        return "I'm "+name;
    }
}
