package br.com.romalopes.springexamples;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 12/11/13
 * Time: 18:40
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public @ResponseBody
    String index() {
        return "Welcome to the home page!";
    }
}