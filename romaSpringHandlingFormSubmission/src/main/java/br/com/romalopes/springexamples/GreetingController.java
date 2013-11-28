package br.com.romalopes.springexamples;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 27/11/13
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 */
@Controller  //Annotation that shows that this class is a controller
public class GreetingController {

    //@RequestMapping annotation allows you to map HTTP requests to specific controller method
    @RequestMapping(value="/greeting", method= RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }

}