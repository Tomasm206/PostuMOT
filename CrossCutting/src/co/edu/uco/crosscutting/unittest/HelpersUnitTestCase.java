package co.edu.uco.crosscutting.unittest;

import org.junit.Test;

import co.edu.uco.crosscutting.helpers.ObjectHelper;

class HelpersUnittesting {

	@Test
	void givenWantValidateIfObjectIsNullWhenObjectIsNullThenResultsIsFalse() {
		// Arrange: Initial Context
		var Object="";
	
		//Act
		boolean result = ObjectHelper.isNull(Object);
		
		//Assert
	
		assertFalse(result);
	}
	private void assertFalse(boolean result) {
		// TODO Auto-generated method stub
		
	}
	@Test
	void givenWantValidateIfObjectIsNotNullWhenObjectIsNullThenResultsIsTrue() {
		// Arrange: Initial Context
		String Object=null;
		
	    //Act
		boolean result = ObjectHelper.isNull(Object);
		
		//Assert
	
		assertTrue(result);
	}
	
	private void assertTrue(boolean result) {
		// TODO Auto-generated method stub
		
	}
	@Test
	void givenWantGetOriginalWhenObjectIsNullThenResultsIsTheSameObject() {
		// Arrange: Initial Context
		var Object = "Casa";
		var DefaultValue = "Default";
		
	    //Act
		var result = ObjectHelper.getDefault(Object, DefaultValue);
		
		//Assert
		assertEquals(Object, result);
	}
	private void assertEquals(String object, String result) {
		// TODO Auto-generated method stub
		
	}
	@Test
	void givenWantGetDefaultValueWhenObjectIsNullThenResultsIsDefaultObject() {
		// Arrange: Initial Context
		String object = null;
		var DefaultValue = "Default";
		
	    //Act
		var result = ObjectHelper.getDefault(object, DefaultValue);
		
		//Assert
		assertgetDefault(object, result);
	}
	private void assertgetDefault(String object, String result) {
		// TODO Auto-generated method stub
		
	}
}