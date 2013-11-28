package br.com.romalopes.springexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 02/11/13
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */

@ComponentScan //tells Spring to search recursively through the hello
    //All children packages marked with @Component annotation. @Controller is a child of @Component
@EnableAutoConfiguration //say spring to look at classpath and run some default behaviors, a Spring MVC(dispatch servlet is created and configured with out a web.xml.
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        List<Person> results = ctx.getBean(JdbcTemplate.class).query("SELECT first_name, last_name FROM people", new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int row) throws SQLException {
                return new Person(rs.getString(1), rs.getString(2));
            }
        });

        for (Person person : results) {
            System.out.println("Found <" + person + "> in the database.");
        }
    }

}

