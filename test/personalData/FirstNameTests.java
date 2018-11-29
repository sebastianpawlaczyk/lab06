package personalData;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import exceptions.NameGenderMismatch;
import exceptions.NotProperName;

class FirstNameTests {

	@SuppressWarnings("unused")
	private FirstName abc;

	@Test
	void checkProperNameWhichIsInTheFile() throws Exception
	{
		FirstName abc = new FirstName("PopularNames.txt");
		abc.checkName("Josh", Gender.MALE);
	}
	
	@Test
	void tryToConstructObjectAndThrowExceptionWithBadFileName() throws Exception
	{
		Assertions.assertThrows(Exception.class,
                ()->{
                	abc = new FirstName("fsafsaf.txt");
                });
	}
	
	@Test
	void constructProperObjectAndThrowExceptionForBadGender() throws Exception
	{
		FirstName abc = new FirstName("PopularNames.txt");
		
		Assertions.assertThrows(NameGenderMismatch.class,
                ()->{
                	abc.checkName("Josh", Gender.FEMALE);
                });
	}
	
	@Test
	void constructProperObjectAndThrowExceptionForBadName() throws Exception
	{
		FirstName abc = new FirstName("PopularNames.txt");
		
		Assertions.assertThrows(NotProperName.class,
                ()->{
                	abc.checkName("asfasf", Gender.FEMALE);
                });
	}

}
