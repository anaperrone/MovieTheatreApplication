

package package1;
import java.util.*;

public class main
{
    public static void main(String[] args)
    {
        DataBase d = new DataBase();
        boolean added = d.addUsername("sobia", "password");
        System.out.println(added);
        boolean added2 = d.addUsername("tina", "password");
        System.out.println(added2);
        boolean added3 = d.addUsername("maitry", "password");
        System.out.println(added3);
        boolean added4 = d.addUsername("ana", "password");
        System.out.println(added4);


        boolean granted = d.grantAccess("sobia", "password");
        System.out.println(granted);

        boolean granted2 = d.grantAccess("sobia", "wrong");
        System.out.println(granted2);

    }
}