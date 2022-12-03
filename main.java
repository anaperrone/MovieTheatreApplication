import java.util.*;
import java.time.*;
import java.text.SimpleDateFormat;

public class main
{
    public static void main(String[] args) throws Exception
    {
        DataBase d = new DataBase();

        // boolean added = d.validateUsername("sobia", "password");
        // System.out.println(added);
        // boolean added2 = d.validateUsername("tina", "password");
        // System.out.println(added2);
        // boolean added3 = d.validateUsername("maitry", "password");
        // System.out.println(added3);
        // boolean added4 = d.validateUsername("ana", "password");
        // System.out.println(added4);

        // boolean removed = d.removeUser("sobia");
        // System.out.println(removed);

        // boolean granted = d.grantAccess("sobia", "password");
        // System.out.println(granted);

        // boolean granted2 = d.grantAccess("sobia", "wrong");
        // System.out.println(granted2);

        LocalDate localdate = LocalDate.of(2022, 12, 01);
        LocalTime localtime = LocalTime.of(1, 15);
        // System.out.println(localdate);
        // ArrayList<LocalTime> showtimes = d.getMovTimes("Black Panther", "Pink Panther", localdate);
        // System.out.println(showtimes);

        ArrayList<Integer> seats = d.getSeats("Black Panther", "Pink Panther", localdate, localtime);
        System.out.println(seats);

        seats = d.getSeats("Black Panther", "Golden Jubilee", localdate, localtime);
        System.out.println(seats);

    }
}