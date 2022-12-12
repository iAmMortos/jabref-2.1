package test.java.unit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import net.sf.jabref.CheckBoxMessage;

class CheckBoxMessageTest {
	
	String MESSAGE = "Hello, World!";
	String CHECKBOX_TEXT = "I'm a checkbox!";
	private static Object lock = new Object();

	@Test
	void testInitialization() {
		CheckBoxMessage cbm = new CheckBoxMessage(MESSAGE, CHECKBOX_TEXT, false);
		Assert.assertNotNull(cbm);
	}

	@Test
	void testInitNullMessage() {
		CheckBoxMessage cbm = new CheckBoxMessage(null, CHECKBOX_TEXT, false);
		Assert.assertNotNull(cbm);
	}
	
	@Test
	void testInitNullCBText() {
		CheckBoxMessage cbm = new CheckBoxMessage(MESSAGE, null, false);
		Assert.assertNotNull(cbm);
	}
	
	@Test
	void testInitNullStrings() {
		CheckBoxMessage cbm = new CheckBoxMessage(null, null, false);
		Assert.assertNotNull(cbm);
	}
	
	@Test
	void testInitDefaultValueTrue() {
		CheckBoxMessage cbm = new CheckBoxMessage(MESSAGE, CHECKBOX_TEXT, true);
		Assert.assertEquals(cbm.isSelected(), true);
	}
	
	@Test
	void testInitDefaultValueFalse() {
		CheckBoxMessage cbm = new CheckBoxMessage(MESSAGE, CHECKBOX_TEXT, false);
		Assert.assertEquals(cbm.isSelected(), false);
	}
}
