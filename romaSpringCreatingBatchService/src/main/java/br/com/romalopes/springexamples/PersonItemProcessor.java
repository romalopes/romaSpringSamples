package br.com.romalopes.springexamples;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 27/11/13
 * Time: 13:11
 * To change this template use File | Settings | File Templates.
 */
//Classes can be totally different
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(final Person person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final Person transformedPerson = new Person(firstName, lastName);

        System.out.println("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }

}