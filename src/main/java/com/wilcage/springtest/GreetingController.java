package com.wilcage.springtest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 * User: wilson
 * Date: 8/30/15
 * Time: 2:15 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "greeting";
    }
}
