package br.com.romalopes.springexamples.restservicesconsumer;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 03/11/13
 * Time: 10:01
 * To change this template use File | Settings | File Templates.
 */
@JsonIgnoreProperties(ignoreUnknown=true) //any property that is not found in this class should be ignored
public class Page {

    private String name;
    private String about;
    private String phone;
    private String website;

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

}