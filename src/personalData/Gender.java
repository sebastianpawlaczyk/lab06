package personalData;

public enum Gender
{
    MALE,
    FEMALE,
    NOTRECOGNIZED;

    public static Gender fromString(String s)
    {
        s =s.trim();
        s = s.toLowerCase();
        switch (s)
        {
            case "male" :
            case "m" :
                return MALE;
            case "female" :
            case "f" :
                return FEMALE;
            default :
                return NOTRECOGNIZED;
        }
    }
}
