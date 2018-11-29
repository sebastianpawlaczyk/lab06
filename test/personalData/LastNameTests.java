package personalData;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import exceptions.NotProperName;

class LastNameTests {

	@Test
	void checkProperLastNameAndDoNotThrowException() throws Exception
	{
		LastName.checkName("Abc-Oro-Xyz");
	}
	
	@Test
	void tryToConstructObjectAndThrowExceptionWithBadFileName() throws Exception
	{
		Assertions.assertThrows(NotProperName.class,
                ()->{
                	LastName.checkName("Abc3535Oro_Xyz");
                });
	}
	

}
