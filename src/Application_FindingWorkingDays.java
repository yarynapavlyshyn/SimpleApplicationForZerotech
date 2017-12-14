import java.time.DayOfWeek;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Application_FindingWorkingDays {
    Date from;
    Date to;
    long numberOfWorkingDaysBetween;
    DateTimeFormatter dTF = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");

    public Application_FindingWorkingDays(String Sfrom, String Sto) throws ParseException{
        try {
            this.from = new SimpleDateFormat("dd/MM/yyyy").parse(Sfrom);
            this.to = new SimpleDateFormat("dd/MM/yyyy").parse(Sto);
            this.numberOfWorkingDaysBetween = findWorkDaysWithoutHolidays(from, to);
        } catch (Error e){
            System.out.print("Please give the dates in format \"dd/MM/yyyy\" ");
        }
    }

    private long findWorkDaysWithoutHolidays(Date from, Date to){
        numberOfWorkingDaysBetween = 0;

        // We are moving forward from date "from" to the first Monday adding work days
        LocalDate LDfrom = LocalDate.parse(from.toString(), dTF);
        while (LDfrom.getDayOfWeek() != DayOfWeek.MONDAY){
            if (LDfrom.getDayOfWeek() != DayOfWeek.SATURDAY
                    & LDfrom.getDayOfWeek() != DayOfWeek.SUNDAY)
                numberOfWorkingDaysBetween += 1;
            LDfrom = LDfrom.plusDays(1);
        }
        System.out.println(LDfrom);

        // We are moving back form date "to" to the last Monday adding work days
        LocalDate LDto = LocalDate.parse(to.toString(), dTF);
        while (LDto.getDayOfWeek() != DayOfWeek.MONDAY){
            if (LDto.getDayOfWeek() != DayOfWeek.SATURDAY
                    & LDto.getDayOfWeek() != DayOfWeek.SUNDAY)
                numberOfWorkingDaysBetween += 1;
            LDto = LDto.minusDays(1);
        }
        System.out.println(LDto);

        // We just add the rounded number of 5/7 * number of days between
        // the fist and the last Mondays in the range of dates
        numberOfWorkingDaysBetween += (getNumberOfDaysBetween(LDfrom, LDto) * 5 / 7);

        return numberOfWorkingDaysBetween;
    }

    private long getNumberOfDaysBetween(LocalDate from, LocalDate to) {
        return ChronoUnit.DAYS.between(from, to);
    }

    public long workDaysWithoutHolidays() {
        return numberOfWorkingDaysBetween;
    }
}
