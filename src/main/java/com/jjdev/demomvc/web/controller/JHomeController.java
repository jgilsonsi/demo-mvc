package com.jjdev.demomvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author jgilson
 */
@Controller
public class JHomeController {

    @GetMapping("/")
    public String home() {
        return "/home";
    }

}
