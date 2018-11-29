package date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import date.ProperDate;

class ProperDateTests {

	@SuppressWarnings("unused")
	private ProperDate properDate;

	@Test
	void createProperDate() throws Exception
	{
		properDate = new ProperDate("1900/02/28");
		
		Assertions.assertEquals(1900, properDate.get(ProperDate.YEAR));
		Assertions.assertEquals(2, properDate.get(ProperDate.MONTH));
		Assertions.assertEquals(28, properDate.get(ProperDate.DAY_OF_MONTH));
	}

	@Test
	void createProperDateWithBadYearAndThrowException() throws Exception
	{
		Assertions.assertThrows(DateException.class,
                ()->{
                	properDate = new ProperDate("1800/02/28");
                });
	}
	
	@Test
	void createProperDateWithBadMonthAndThrowException() throws Exception
	{
		Assertions.assertThrows(DateException.class,
                ()->{
                	properDate = new ProperDate("1900/34/28");
                });
	}
	
	@Test
	void createProperDateWithBadDayAndThrowException() throws Exception
	{
		Assertions.assertThrows(DateException.class,
                ()->{
                	properDate = new ProperDate("1900/02/29");
                });
	}
}
