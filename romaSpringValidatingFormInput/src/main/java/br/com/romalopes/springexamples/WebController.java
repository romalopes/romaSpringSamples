package br.com.romalopes.springexamples;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 21/11/13
 * Time: 10:58
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class WebController {

    //Method get that will show form.
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String showForm(Person person) {
        return "form";
    }

    //Method POST that will validate Person
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String enterAge(@Valid Person person, BindingResult bindingResult, //bindingResult will receive the errors from validator
                           RedirectAttributes redirectAttributes) {//Will get the errors to be shown in flash object

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", bindingResult.getFieldError().getDefaultMessage());
            return "redirect:/";
        }
        return "results";
    }

}