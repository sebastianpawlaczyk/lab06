package exceptions;

public class NameGenderMismatch extends Exception
{
    public NameGenderMismatch()
    {
        super();
    }

    public NameGenderMismatch(String message)
    {
        super(message);
    }

    public NameGenderMismatch(String name, String gender)
    {
        super(name + " (" + gender + ")");
    }
}
