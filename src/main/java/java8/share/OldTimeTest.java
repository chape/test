package java8.share;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class OldTimeTest {

    @Test
    public void nowDate() {
        Date date = new Date(2012, 1, 1);
        System.out.println(date);// 坑爹： year是2012+1900，而month月份参数是1居然从零开始，输出二月

        Calendar calendar = Calendar.getInstance();
        calendar.set(2012, 1, 1);
        System.out.println(calendar.getTime());
        calendar.set(2012, Calendar.JANUARY, 1);
        System.out.println(calendar.getTime());
    }

    @Test
    public void betweenDay() {
        Calendar birth = Calendar.getInstance();
        birth.set(2017, Calendar.MAY, 1);
        Calendar now = Calendar.getInstance();
        System.out.println(daysBetween(birth, now));
        // 坑爹：如果连续计算两个Date实例的话，第二次会取得0，因为Calendar状态是可变的，考虑到重复计算的场合，最好复制一个新的Calendar
        System.out.println(daysBetween2(birth, now));
    }

    private long daysBetween(Calendar begin, Calendar end) {
        long daysBetween = 0;
        while (begin.before(end)) {
            begin.add(Calendar.DAY_OF_MONTH, 1);
            daysBetween++;
        }
        return daysBetween;
    }

    private long daysBetween2(Calendar begin, Calendar end) {
        Calendar calendar = (Calendar) begin.clone(); // 复制
        long daysBetween = 0;
        while (calendar.before(end)) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            daysBetween++;
        }
        return daysBetween;
    }

    static class UnsafeDateUtil {
        private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        public static String format(Date date) {
            return dateFormat.format(date);
        }

        public static Date parse(String dateStr) throws ParseException {
            return dateFormat.parse(dateStr);
        }

    }
    
    static class SafeDateUtil {
        private static ThreadLocal<SimpleDateFormat> local = new ThreadLocal<SimpleDateFormat>();

        private static SimpleDateFormat getDateFormat() {
            SimpleDateFormat dateFormat = local.get();
            if (dateFormat == null) {
                dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                local.set(dateFormat);
            }
            return dateFormat;
        }

        public static String format(Date date) {
            return getDateFormat().format(date);
        }

        public static Date parse(String dateStr) throws ParseException {
            return getDateFormat().parse(dateStr);
        }
    }
    
    private static ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(4);
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            newFixedThreadPool.execute(() -> {
                try {
//                    System.out.println(Thread.currentThread().getName() + "\t" + SafeDateUtil.parse("2016-01-01 10:24:00"));
                    System.out.println(Thread.currentThread().getName() + "\t" + UnsafeDateUtil.parse("2016-01-01 10:24:00"));
                } catch (Exception e) {
                    e.printStackTrace();
                }finally{
                    newFixedThreadPool.shutdown();
                }
            });
        }
    }
}
