import java.text.ParseException;


/*
    Task:
        - create a Java interface and implementation for calculating amount of
        working days between dates. Implementation should be precise and fast.
        Working days are weekdays from Monday to Friday.
        - Application should do it with minimal code without any add-ons or
        visual beauty.
        - Application should use only standard java stack without additional
        libraries.
        - interface should be like "int workDaysWithoutHolidays(Date from, Date
        to)"
*/

public class Main {
    public static void main(String args[]) throws ParseException {
        Application_FindingWorkingDays WD = new Application_FindingWorkingDays("09/02/2017", "09/03/2017");
        System.out.println(WD.workDaysWithoutHolidays());
        Application_FindingWorkingDays WD2 = new Application_FindingWorkingDays("14/12/2017","20/12/2017");
        System.out.println(WD2.workDaysWithoutHolidays());
    }
}
