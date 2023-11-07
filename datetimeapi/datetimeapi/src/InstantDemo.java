import java.time.*;
import java.time.temporal.*;
import java.util.Date;

public class InstantDemo {
    public static void main(String[] args) {
        System.out.println("===================== create instants =============================");
        System.out.println();
        createInstant();
        System.out.println("===================== add & subtract instants =============================");
        System.out.println();
        addSubtractDemo();
        System.out.println("===================== compare instants =============================");
        System.out.println();
        dateComparison();
        System.out.println("===================== convert instants =============================");
        System.out.println();
        instantConversionExample();
    }

    private static void instantConversionExample() {
        Instant instant=Instant.now();
        System.out.println("instant = " + instant);
        LocalDate date=LocalDate.ofInstant(instant,ZoneId.systemDefault());
        System.out.println("date from instant = " + date);
        LocalDateTime localDateTime=LocalDateTime.ofInstant(instant,ZoneId.systemDefault());
        System.out.println("localDateTime from instant = " + localDateTime);
        ZonedDateTime zonedDateTime=ZonedDateTime.ofInstant(instant,ZoneId.systemDefault());
        System.out.println("zonedDateTime from instant: " + zonedDateTime);
       OffsetDateTime offsetDateTime=OffsetDateTime.ofInstant(instant,ZoneId.of("Europe/Paris"));
        System.out.println("offsetDateTime from instant = " + offsetDateTime.getOffset());
    }

    private static void dateComparison() {
        Instant instant1 = Instant.parse("1984-08-13T10:15:30.345Z");
        Instant instant2 = Instant.parse("1985-08-13T10:15:30.345Z");
        boolean isAfter = instant1.isAfter(instant2);
        System.out.println("isAfter = " + isAfter);
        boolean isBefore=instant1.isBefore(instant2);
        System.out.println("isBefore = " + isBefore);
        int i = instant1.compareTo(instant2);
        System.out.println("i = " + i);
    }

    private static void addSubtractDemo() {
        Instant instant=Instant.now();
        System.out.println("instant: " + instant);
        Instant instant1 = instant.minus(5, ChronoUnit.DAYS);
        System.out.println("instant1 = " + instant1);
        Instant instant2 = instant.plus(10,ChronoUnit.MINUTES);
        System.out.println("instant2 = " + instant2);
        Instant instant3 = Instant.parse("1984-08-13T10:15:30.345Z");
        System.out.println("instant3 = " + instant3.plus(Period.ofDays(1)));
        System.out.println(instant3.plusSeconds(60*60*24));

    }

    private static void createInstant(){
        Instant instant1=Instant.now();
        System.out.println("instant1 = " + instant1);
        Instant instant2=Instant.now(Clock.systemUTC());
        System.out.println("instant2 = " + instant2);
        long now=System.currentTimeMillis();
        System.out.println("now = " + now);
        Instant instant3=Instant.ofEpochMilli(now);
        System.out.println("instant3 = " + instant3);
        Instant instant4=Instant.ofEpochSecond(now/1000);
        System.out.println("instant4 = " + instant4);
        Instant instant5=Instant.ofEpochSecond(now/1000, 1000);
        System.out.println("instant5 = " + instant5);
        Instant instant6=Instant.parse("2023-05-12T15:46:00.08Z");
        System.out.println("instant6 = " + instant6);

        Instant instant7=new Date().toInstant();
        System.out.println("instant7 = " + instant7);


        System.out.println("seconds field of instant7: " + instant7.get(ChronoField.NANO_OF_SECOND));
        System.out.println("milliseconds field of instant7: " +instant7.get(ChronoField.MILLI_OF_SECOND));
        System.out.println("getEpochSeconds: " + instant7.getEpochSecond());
    }

}