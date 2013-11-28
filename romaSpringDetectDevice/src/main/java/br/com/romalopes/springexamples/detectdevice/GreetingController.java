package br.com.romalopes.springexamples.detectdevice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 28/11/13
 * Time: 11:38
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting() {
        return "greeting";
    }

}