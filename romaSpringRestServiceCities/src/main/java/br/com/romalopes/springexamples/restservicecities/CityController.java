package br.com.romalopes.springexamples.restservicecities;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 02/11/13
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class CityController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final HashMap<String, City> mapCities = new HashMap<String, City>();

    CityController() {
        mapCities.put("NYC", new City(1,"NYC", "New York"));
        mapCities.put("RJ", new City(2,"RJ", "Rio de Janeiro"));
        mapCities.put("SYD", new City(3,"SYD", "Sydney"));
    }

    //Method get that will show form.
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index() {
        System.out.println("index");
        return "index";
    }

    @RequestMapping("/city")    //Define via mvc that HTTP request is to /city
    //@RequestMapping("/greeting", Method=GET)
    public @ResponseBody            //Define that is will returns the JSON
    City city(@RequestParam(value="name", required=false, defaultValue="Rio") String name) {
              //the parameter passed in GET ?name=NYC
               System.out.println(name);
        City city = mapCities.get(name);

        Iterator it = mapCities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            System.out.println(pairs.getKey() + " = " + pairs.getValue());
        }
        if(city != null) {
            return city;    //City is transformed in JSON
        }
        return null;
    }

    @RequestMapping("/greeting")
    public @ResponseBody Greeting greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

}
