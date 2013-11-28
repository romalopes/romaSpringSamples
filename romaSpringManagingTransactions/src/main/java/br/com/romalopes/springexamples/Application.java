package br.com.romalopes.springexamples;

import org.junit.Assert;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 02/11/13
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */

@Configuration
@EnableTransactionManagement //Enable transaction features, which makes @Transactional function
@EnableAutoConfiguration //say spring to look at classpath and run some default behaviors, a Spring MVC(dispatch servlet is created and configured with out a web.xml.
//EnableAutoConfiguration Detects that the program has spring-tx and DataSource


public class Application {

    @Bean
    //Configure the bookingService bean
    BookingService bookingService() {
        return new BookingService();
    }

    @Bean
    //Define the dataSource
    //For production use a JDBC connection pool to handle multiple requests simultaneously
    DataSource dataSource() {
        return new SimpleDriverDataSource() {{
            setDriverClass(org.h2.Driver.class);
            setUsername("sa");
            setUrl("jdbc:h2:mem");
            setPassword("");
        }};
    }

    @Bean
    //Define the jdbcTemplate that is auto wired in bookingService
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("Creating tables");
        jdbcTemplate.execute("drop table BOOKINGS if exists");
        jdbcTemplate.execute("create table BOOKINGS(" +
                "ID serial, FIRST_NAME varchar(5) NOT NULL)");
        return jdbcTemplate;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        BookingService bookingService = ctx.getBean(BookingService.class);
        bookingService.book("Alice", "Bob", "Carol");
        Assert.assertEquals("First booking should work with no problem",
                3, bookingService.findAllBookings().size());

        try {
            bookingService.book("Chris", "Samuel");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        Assert.assertEquals("'Samuel' should have triggered a rollback",
                3, bookingService.findAllBookings().size());

        try {
            bookingService.book("Buddy", null);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        Assert.assertEquals("'null' should have triggered a rollback",
                3, bookingService.findAllBookings().size());

    }

}
