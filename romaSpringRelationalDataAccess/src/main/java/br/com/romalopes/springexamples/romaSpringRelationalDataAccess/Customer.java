package br.com.romalopes.springexamples.romaSpringRelationalDataAccess;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 06/11/13
 * Time: 01:12
 * To change this template use File | Settings | File Templates.
 */
public class Customer {
    private long id;
    private String firstName, lastName;

    public Customer(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    // getters & setters omitted for brevity
}
