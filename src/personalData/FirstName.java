package personalData;

import exceptions.NameGenderMismatch;
import exceptions.NotProperName;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstName
{
    private Map<String,Gender> names_ = new HashMap<>();
    private boolean isBoy_ = false;

    private boolean checkIfGender(String name)
    {
        if (name.contains("boys"))
        {
            isBoy_ = true;
            return true;
        }

        if (name.contains("girls"))
        {
            isBoy_ = false;
            return true;
        }

        return false;
    }

    public FirstName(String fileName) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();

            String name = new String(line);
            name = name.toLowerCase();

            if (!checkIfGender(name))
            {
                if (isBoy_)
                {
                    names_.put(name, Gender.MALE);
                }

                if (!isBoy_)
                {
                    names_.put(name, Gender.FEMALE);
                }
            }
        }
        scanner.close();
    }

    public void checkName(String name, Gender gender) throws Exception
    {
        name = name.toLowerCase();
        name = name.trim();

        if (names_.get(name) == null)
        {
            throw new NotProperName(name, "No name in file");
        }

        if (names_.get(name) != gender)
        {
            throw new NameGenderMismatch(name, gender.toString());
        }

        System.out.println("Proper data " + name + " " + gender.toString());

    }

    public static void main(String args[]) throws Exception
    {
        try
        {
            FirstName abc = new FirstName("PopularNames.txt");
            abc.checkName("Josh", Gender.MALE);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
