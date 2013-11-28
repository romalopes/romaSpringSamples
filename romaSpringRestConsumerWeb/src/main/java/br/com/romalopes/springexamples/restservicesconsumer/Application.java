package br.com.romalopes.springexamples.restservicesconsumer;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 02/11/13
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */

public class Application {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();


        Page page = restTemplate.getForObject("http://graph.facebook.com/gopivotal", Page.class);
        System.out.println("\n\nResults\n\nName:    " + page.getName());
        System.out.println("About:   " + page.getAbout());
        System.out.println("Phone:   " + page.getPhone());
        System.out.println("Website: " + page.getWebsite());
/*
        //https://maps.googleapis.com/maps/api/geocode/json?&address=sydney&sensor=false
        String url = "https://maps.googleapis.com/maps/api/geocode/json?&address=riodejaneiro&sensor=false";
        ListOfCities listOfCities = restTemplate.getForObject(url, ListOfCities.class);

        System.out.println(listOfCities.toString());
        System.out.println("\n\nResults\n\n");
       for (City city : listOfCities.getCities()) {
            System.out.println("Value:    " + city.getResults());
        }

  */
    }

}

