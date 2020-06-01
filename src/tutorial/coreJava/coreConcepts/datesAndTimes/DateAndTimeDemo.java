package tutorial.coreJava.coreConcepts.datesAndTimes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateAndTimeDemo {
    public static void main(String[] args) throws Exception {

        /**
         * Date instance
         */
        Date date = new Date();
        System.out.println(date);


        DateFormat simpleDateFormat = new SimpleDateFormat("MMM E yyyy HH mm ss");
        /*System.out.println(simpleDateFormat.format(date));*/


        /**
         * LocalDate instance
         */
        LocalDate startDate = LocalDate.now();
        System.out.println(startDate);


        /* // about Duration class and also LocalDate instance with particular custom date (not now())
        LocalDate endDate = LocalDate.of(2020,7,13);
        System.out.println(Duration.between(startDate.atStartOfDay(), endDate.atStartOfDay()).toDays());*/

        /**
         * LocalDateTime instance (separates date and time with T)
         */

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        /**
         * DateTimeFormatter
         */

        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("D")));
        //System.out.println(simpleDateFormat.format(localDateTime));



        /**
         * Calendar instance
         */
        Calendar calendar = Calendar.getInstance();

        /*calendar.setTimeZone(TimeZone.getTimeZone("IST"));*/
        calendar.set(2020, Calendar.MAY, 19); //setting date to 2019-01-01
        /*calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));*/  //set overloaded method to override any calendar properties
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));


        System.out.println("normal date format v/s customized date format with calendar instance");
        System.out.println(calendar.getTime());
        simpleDateFormat.setCalendar(calendar);
        System.out.println(simpleDateFormat.format(calendar.getTime()));

    }
}
