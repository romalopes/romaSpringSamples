package br.com.romalopes.springexamples;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 27/11/13
 * Time: 23:10
 * To change this template use File | Settings | File Templates.
 */

public class BookingService {

    @Autowired
    //Autowire the jdbcTemplate
    JdbcTemplate jdbcTemplate;

    @Transactional
    //As transaction, any problem in any insert, causes to rollback the entire operation
    public void book(String... persons) {
        for (String person : persons) {
            System.out.println("Booking " + person + " in a seat...");
            jdbcTemplate.update("insert into BOOKINGS(FIRST_NAME) values (?)", person);
        }
    };

    public List<String> findAllBookings() {
        return jdbcTemplate.query("select FIRST_NAME from BOOKINGS", new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("FIRST_NAME");
            }
        });
    }

}