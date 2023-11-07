import java.time.*;

public class ZonedDateTimeDemo {
    public static void main(String[] args) {
        zonedDateTimeInstantiation();
    }

    private static void zonedDateTimeInstantiation() {
        /*ZonedDateTime zonedDateTime=ZonedDateTime.of(LocalDateTime.now(ZoneId.of("Asia/Singapore")), ZoneId.of("Asia/Singapore"));
        System.out.println("zonedDateTime = " + zonedDateTime);
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Singapore"));
        System.out.println("now = " + now);*/

        ZonedDateTime zonedDateTime=ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Paris"));
        System.out.println("zonedDateTime = " + zonedDateTime);
        ZonedDateTime zonedDateTime1=ZonedDateTime.ofInstant(Instant.now(),ZoneId.of("Europe/Paris"));
        System.out.println("zonedDateTime1 = " + zonedDateTime1);
        ZonedDateTime zonedDateTime2=ZonedDateTime.ofLocal(
                LocalDateTime.now(),ZoneId.of("Asia/Singapore"), ZoneOffset.of("+08:00"));
        System.out.println("zonedDateTime2 = " + zonedDateTime2);
        ZonedDateTime zonedDateTime3=ZonedDateTime.ofStrict(
                LocalDateTime.now(),ZoneOffset.of("+02:00"),ZoneId.of("Asia/Singapore"));
        System.out.println("zonedDateTime3 = " + zonedDateTime3);
    }
}
