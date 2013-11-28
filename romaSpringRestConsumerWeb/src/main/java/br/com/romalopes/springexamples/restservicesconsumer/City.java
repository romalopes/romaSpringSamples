package br.com.romalopes.springexamples.restservicesconsumer;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 03/11/13
 * Time: 10:01
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown=true) //any property that is not found in this class should be ignored
public class City {

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    //https://maps.googleapis.com/maps/api/geocode/json?&address=riodejaneiro&sensor=false
    String results;


}

@JsonIgnoreProperties(ignoreUnknown=true)
class ListOfCities{
    List<City> getCities() {
        return cities;
    }

    void setCities(List<City> cities) {
        this.cities = cities;
    }

    // other variables
    private List<City> cities; //it getters and setters
}

/*
https://maps.googleapis.com/maps/api/geocode/json?&address=sydney&sensor=false

{
   "results" : [
      {
         "address_components" : [
            {
               "long_name" : "Sydney",
               "short_name" : "Sydney",
               "types" : [ "colloquial_area", "locality", "political" ]
            },
            {
               "long_name" : "Nova Gales do Sul",
               "short_name" : "NSW",
               "types" : [ "administrative_area_level_1", "political" ]
            },
            {
               "long_name" : "Comunidade da Austrália",
               "short_name" : "AU",
               "types" : [ "country", "political" ]
            }
         ],
         "formatted_address" : "Sydney NSW, Comunidade da Austrália",
         "geometry" : {
            "bounds" : {
               "northeast" : {
                  "lat" : -33.4245981,
                  "lng" : 151.3426361
               },
               "southwest" : {
                  "lat" : -34.1692489,
                  "lng" : 150.502229
               }
            },
            "location" : {
               "lat" : -33.8674869,
               "lng" : 151.2069902
            },
            "location_type" : "APPROXIMATE",
            "viewport" : {
               "northeast" : {
                  "lat" : -33.4245981,
                  "lng" : 151.3426361
               },
               "southwest" : {
                  "lat" : -34.1692489,
                  "lng" : 150.502229
               }
            }
         },
         "types" : [ "colloquial_area", "locality", "political" ]
      },
      {
         "address_components" : [
            {
               "long_name" : "Sydney",
               "short_name" : "Sydney",
               "types" : [ "locality", "political" ]
            },
            {
               "long_name" : "Nova Gales do Sul",
               "short_name" : "NSW",
               "types" : [ "administrative_area_level_1", "political" ]
            },
            {
               "long_name" : "Comunidade da Austrália",
               "short_name" : "AU",
               "types" : [ "country", "political" ]
            }
         ],
         "formatted_address" : "Sydney NSW, Comunidade da Austrália",
         "geometry" : {
            "bounds" : {
               "northeast" : {
                  "lat" : -33.8561177,
                  "lng" : 151.2229549
               },
               "southwest" : {
                  "lat" : -33.879786,
                  "lng" : 151.1971341
               }
            },
            "location" : {
               "lat" : -33.873651,
               "lng" : 151.2068896
            },
            "location_type" : "APPROXIMATE",
            "viewport" : {
               "northeast" : {
                  "lat" : -33.8561177,
                  "lng" : 151.2229549
               },
               "southwest" : {
                  "lat" : -33.879786,
                  "lng" : 151.1971341
               }
            }
         },
         "types" : [ "locality", "political" ]
      }
   ],
   "status" : "OK"
}