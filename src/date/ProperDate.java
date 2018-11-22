package date;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProperDate extends GregorianCalendar
{
    private String dateRegexFirstFormat = "(\\d\\d\\d\\d)\\/(\\d\\d|\\d)\\/(\\d\\d|\\d)";
    private boolean firstRegex_ = false;
    private String dateRegexSecondFormat = "(\\d\\d|\\d)\\/(\\d\\d|\\d)\\/(\\d\\d\\d\\d)";
    private boolean secondRegex_ = false;
    private int year_;
    private int month_;
    private int day_;

    public ProperDate(String dateDsc) throws Exception
    {
        dateDsc = dateDsc.trim();

        Pattern pattern = Pattern.compile(dateRegexFirstFormat);
        Matcher matcher = pattern.matcher(dateDsc);

        if (matcher.matches())
        {
            try {
                year_ = Integer.parseInt(matcher.group(1));
                month_ = Integer.parseInt(matcher.group(2));
                day_ = Integer.parseInt(matcher.group(3));
            }catch (Exception e)
            {
                throw new Exception();
            }
            firstRegex_ = true;
        }

        pattern = Pattern.compile(dateRegexSecondFormat);
        matcher = pattern.matcher(dateDsc);
        if (matcher.matches())
        {
            try {
                year_ = Integer.parseInt(matcher.group(1));
                month_ = Integer.parseInt(matcher.group(2));
                day_ = Integer.parseInt(matcher.group(3));
            }catch (Exception e)
            {
                throw new Exception();
            }
            secondRegex_ = true;
        }

        if (!firstRegex_ && !secondRegex_)
        {
            throw new DateException("Wrong Format");
        }

        if (year_ < 1900 || year_ > 2100)
        {
            throw new DateException("Not Proper Year");
        }

        int maxForFeb = 28;
        if (isLeapYear(year_))
        {
            maxForFeb = 29;
        }

        if (month_ < 1 || month_ > 12)
        {
            throw new DateException("Not Proper Month");
        }

        switch (month_)
        {
            case 1 :
            case 3 :
            case 5 :
            case 7 :
            case 8 :
            case 10 :
            case 12 :
                if (day_ < 1 || day_ > 31)
                {
                    throw new DateException("Not Proper Day");
                }
            case 4 :
            case 6 :
            case 9 :
            case 11 :
                if (day_ < 1 || day_ > 30)
                {
                    throw new DateException("Not Proper Day");
                }
            case 2 :
                if (day_ < 1 || day_ > maxForFeb)
                {
                    throw new DateException("Not Proper Day");
                }
        }
    }

    public static void main(String args[]) throws Exception
    {
        try {
            ProperDate properDate = new ProperDate("1900/02/28");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

