package br.com.romalopes.springexamples.schedulingtask;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 03/11/13
 * Time: 12:14
 * To change this template use File | Settings | File Templates.
 */

@EnableScheduling //Spring will look for this annotation to enable scheduling
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000) //fixedDelay=, cron=   //time for schedule
                                        //http://docs.spring.io/spring/docs/3.2.x/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html
    public void reportCurrentTime() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }
}
