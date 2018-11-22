package personalData;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GenderTests
{
    @Test
    public void testProperResultsForFromStringMethod()
    {
        Assertions.assertEquals(Gender.MALE ,Gender.fromString("male"));
        Assertions.assertEquals(Gender.MALE ,Gender.fromString("m  "));
        Assertions.assertEquals(Gender.MALE ,Gender.fromString("  M"));
        Assertions.assertEquals(Gender.MALE ,Gender.fromString("MALE"));

        Assertions.assertEquals(Gender.FEMALE ,Gender.fromString("female"));
        Assertions.assertEquals(Gender.FEMALE ,Gender.fromString("f"));
        Assertions.assertEquals(Gender.FEMALE ,Gender.fromString("F"));
        Assertions.assertEquals(Gender.FEMALE ,Gender.fromString("Female  "));

        Assertions.assertEquals(Gender.NOTRECOGNIZED ,Gender.fromString("asasmen"));
    }
}