package CafeModel;

import java.util.Scanner;

public class ConfirmChoice
{
    static Scanner obj=new Scanner(System.in);
    public static boolean confirmationChecker(String st)
    {
        if(st.equalsIgnoreCase("yes") || st.charAt(0)=='y' || st.equalsIgnoreCase("yeah") || st.contains("es") || st.contains("yep") || st.contains("confirm"))
        {
            return true;
        }
        else {
            return false;
        }
    }
}
