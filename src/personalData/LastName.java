package personalData;

import exceptions.NotProperName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LastName
{
    public static String NAMEREGEX = "([A-Z])([a-z]*)((\\-[A-Z][a-z]*))*";

    public static void checkName(String name) throws Exception
    {
        name = name.trim();
        Pattern pattern = Pattern.compile(NAMEREGEX);
        Matcher matcher = pattern.matcher(name);

        if (!matcher.matches())
        {
            throw new NotProperName(name + " (no such name)");
        }

        System.out.println("Good name");
    }

    public static void main(String args[]) throws Exception
    {
      try
      {
            LastName.checkName("Rodrihez-L-A    ");
      }
      catch (Exception e)
      {
          System.out.println(e.getMessage());
      }
    }
}
