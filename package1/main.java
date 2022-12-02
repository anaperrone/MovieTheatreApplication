

package package1;
import java.util.*;

public class main
{
    public static void main(String[] args)
    {
        DataBase d = new DataBase();
        boolean added = d.addUsername("sobia", "password");
        System.out.println(added);
    }
}