package br.com.romalopes.springexamples;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 13/11/13
 * Time: 10:37
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class HelloController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index() {
        return "index";
    }
}
