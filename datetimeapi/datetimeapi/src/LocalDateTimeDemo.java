import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        localDateTimeInstantiationExample();
        System.out.println("========= Getting information ==============");
        gettingInformationExample();
        System.out.println("========= Add & Subtract Time ==============");
        addSubtractTimeExample();

    }

    private static void addSubtractTimeExample() {
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);
        LocalDateTime localDateTime1 = localDateTime.plus(1, ChronoUnit.DAYS);
        System.out.println("localDateTime1 = " + localDateTime1);
        LocalDateTime localDateTime2 = localDateTime.minusHours(3);
        System.out.println("localDateTime2 = " + localDateTime2);
        LocalDateTime localDateTime3=localDateTime.plusWeeks(1);
        System.out.println("localDateTime3 = " + localDateTime3);
        localDateTime1.plusMonths(1L);
    }

    private static void gettingInformationExample() {
        LocalDateTime localDateTime=LocalDateTime.now();
        int dayOfMonth = localDateTime.get(ChronoField.DAY_OF_MONTH);
        System.out.println("dayOfMonth = " + dayOfMonth);
        int hour = localDateTime.getHour();
        System.out.println("hour = " + hour);
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);
        Month month = localDateTime.getMonth();
        System.out.println("month = " + month);
        int year = localDateTime.getYear();
        System.out.println("year = " + year);


    }

    public static void localDateTimeInstantiationExample(){
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);
        LocalDateTime localDateTime1=LocalDateTime.
                of(1997, Month.JANUARY,1,
                8,20,10);
        System.out.println("localDateTime1 = " + localDateTime1);
        LocalDateTime localDateTime2=LocalDateTime.parse("1997-01-01T08:20:10");
        System.out.println("localDateTime2 = " + localDateTime2);
    }
}
