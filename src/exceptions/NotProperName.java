package exceptions;

public class NotProperName extends Exception
{
    public NotProperName()
    {
        super();
    }

    public NotProperName(String s)
    {
        super(s);
    }

    public NotProperName(String name, String reason)
    {
        super(reason + " (" + name + ")");
    }
}
