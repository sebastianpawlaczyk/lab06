package date;


public class DateException extends Exception
{
    public DateException()
    {
        super();
    }


    public DateException(String message)
    {
        super(message);
    }

    public DateException(String date, String reason)
    {
        super(reason + " (" + date + ")");
    }

}
