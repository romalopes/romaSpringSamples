package br.com.romalopes.springexamples;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 27/11/13
 * Time: 17:54
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class GreetingController {

    @RequestMapping("/site-preference")
    //@ResponseBody implies that the controller will not return to a View, the controller just return a string
    public @ResponseBody String home(SitePreference sitePreference) {
        if (sitePreference != null) {
            return "Hello " + sitePreference.name() + " site preference!";
        } else {
            return "SitePreference is not configured.";
        }
    }

}