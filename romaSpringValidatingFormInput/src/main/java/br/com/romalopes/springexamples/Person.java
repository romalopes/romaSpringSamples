package br.com.romalopes.springexamples;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 21/11/13
 * Time: 10:56
 * To change this template use File | Settings | File Templates.
 */
public class Person {
    @NotNull //won't allow an empty value
    @Min(18) //won't allow if the age is less than 18
    private Integer age;

    public String toString() {
        return "Person(" + age + ")";
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}