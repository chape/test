package java8.newtime;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class DateAPI {

    @Test
    public void printToday(){
        System.out.println("today date is " + LocalDate.now());
    }
    
    public static void clock() {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);

        Instant instant = clock.instant();
        Date date = Date.from(instant);
        System.out.println(date);
    }

    public static void timezone() {
        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        System.out.println(now1.isBefore(now2)); // false

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println(hoursBetween); // -4
        System.out.println(minutesBetween); // -299
    }

    public static void formatLocale() {
        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late); // 23:59:59

        DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.CHINESE);

        LocalTime leetTime = LocalTime.parse("下午01:37", germanFormatter);
        System.out.println(leetTime); // 13:37
    }

    public static void localDate() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);
        System.out.println(yesterday);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek); // FRIDAY

        DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
        System.out.println(xmas); // 2014-12-24
    }

    public static void localDateTime() {
        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

        DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek); // WEDNESDAY

        Month month = sylvester.getMonth();
        System.out.println(month); // DECEMBER

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay); // 1439

        Instant instant = sylvester.atZone(ZoneId.systemDefault()).toInstant();

        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate); // Wed Dec 31 23:59:59 CET 2014
    }

    public static void format() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy-HH:mm");

        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014-07:13", formatter);
        String string = formatter.format(parsed);
        System.out.println(string); // Nov 03, 2014 - 07:13
    }

    public static void main(String[] args) {

        format();
    }
}
