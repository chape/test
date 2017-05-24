package java8.share;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import org.junit.Test;

public class NewTimeTest {

    @Test
    public void nowDateOrTime() {
        // 获取当前日期
        System.out.println("今天的日期：" + LocalDate.now());
        // 获取当前时间
        System.out.println(LocalTime.now().withNano(0));
        // 获取当前时间
        System.out.println(LocalDateTime.now().withNano(0));
    }

    @Test
    public void specifyDateOrTime() {
        // 指定某日期
        LocalDate specifyDate = LocalDate.of(2016, 11, 13);
        LocalDate specifyDate2 = LocalDate.parse("2016-11-13");
        // 指定时间
        LocalTime specifyTime = LocalTime.of(14, 10, 21);
        LocalTime specifyTime2 = LocalTime.parse("14:10:21");

        // 取2016年11月的第1天
        LocalDate firstDay = specifyDate.withDayOfMonth(1);
        System.out.println(firstDay);

        // 取2016年11月的最后1天，不用考虑大月，小月，平年，闰年
        LocalDate lastDay = specifyDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);

        // 当前日期＋1天
        LocalDate tomorrow = specifyDate.plusDays(1);
        System.out.println(tomorrow);
        // 当前时间增加1小时
        LocalTime timePlusHour = specifyTime.plusHours(1);
        System.out.println(timePlusHour);

        // 判断是否为闰年
        boolean isLeapYear = tomorrow.isLeapYear();
        System.out.println(isLeapYear);

    }

    @Test
    public void isBirthDay() {
        LocalDate bornDay = LocalDate.of(1990, 01, 17);
        MonthDay birthDay = MonthDay.of(bornDay.getMonth(), bornDay.getDayOfMonth());
        MonthDay today = MonthDay.from(LocalDate.of(2017, 01, 17));
        System.out.println("今天是你的生日吗?" + (today.equals(birthDay) ? " 是的" : " 不是"));
    }

    @Test
    public void BetweenDateOrTime() {
        LocalDate today = LocalDate.now();
        LocalDate specifyDate = LocalDate.of(2017, 1, 1);

        System.out.println(specifyDate.isBefore(today));
        System.out.println(specifyDate.until(today, ChronoUnit.DAYS));
        System.out.println(specifyDate.until(today, ChronoUnit.MONTHS));
    }

    @Test
    public void dateFormat() {
        String specifyDateStr = "2015/10/11";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate formatted = LocalDate.parse(specifyDateStr, formatter);
        System.out.println(formatted);

        LocalDate specifyDate = LocalDate.of(1990, 01, 17);
        System.out.println(specifyDate.format(formatter));
    }

    @Test
    public void transforEachOther() {
        // Date与Instant的相互转化
        Instant instant = Instant.now();
        Date date = Date.from(instant);
        Instant transforedInstant = date.toInstant();

        // Date转为LocalDateTime
        Date nowDate = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(nowDate.toInstant(), ZoneId.systemDefault());
        // LocalDateTime转Date
        LocalDateTime nowLocalDateTime = LocalDateTime.now();
        Instant tempInstant = nowLocalDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date transforedDate = Date.from(tempInstant);

        // LocalDate转Date(LocalDate不包含时间，所以转Date时，会默认转为当天的起始时间，即00:00:00)
        LocalDate nowLocalDate = LocalDate.now();
        Instant localDateinstant = nowLocalDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date transfored = Date.from(localDateinstant);
    }

    @Test
    public void timeZone() {
        // 查看当前的时区
        ZoneId defaultZone = ZoneId.systemDefault();
        System.out.println(defaultZone);

        // 查看美国纽约当前的时间
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime shanghaiTime = LocalDateTime.now();
        LocalDateTime americaDateTime = LocalDateTime.now(america);
        System.out.println(shanghaiTime);
        System.out.println(americaDateTime);

        // 带有时区的时间
        ZonedDateTime americaZoneDateTime = ZonedDateTime.now(america);
        System.out.println(americaZoneDateTime);
    }
}
