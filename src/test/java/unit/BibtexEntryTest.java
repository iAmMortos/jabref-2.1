package test.java.unit;

import org.junit.Assert;
import org.junit.Test;

import net.sf.jabref.BibtexEntry;
import net.sf.jabref.BibtexEntryType;

public class BibtexEntryTest
{	
	private static final String CUSTOM_ID = "My ID";

	@Test
	public void testBibtexEntryCustomConstructor()
	{
		BibtexEntry entry = new BibtexEntry(CUSTOM_ID);
		Assert.assertEquals(BibtexEntryType.OTHER, entry.getType());
	}
	
	@Test
	public void testBibtexEntryConstructorNPE()
	{
		Boolean caught = false;
		
		try
		{
			new BibtexEntry(null);
		}
		catch(NullPointerException ex)
		{
			caught = true;
		}
		
		Assert.assertTrue(caught);
	}
	
	@Test
	public void testBibtexEntryGetOptionalFields()
	{
		BibtexEntry entry = new BibtexEntry(CUSTOM_ID, BibtexEntryType.BOOK);
		Assert.assertEquals(BibtexEntryType.BOOK.getOptionalFields(), entry.getOptionalFields());
	}

	@Test
	public void testBibtexEntryGetRequiredFields()
	{
		BibtexEntry entry = new BibtexEntry(CUSTOM_ID, BibtexEntryType.BOOK);
		Assert.assertEquals(BibtexEntryType.BOOK.getRequiredFields(), entry.getRequiredFields());
	}

	@Test
	public void testBibtexEntryGetGeneralFields()
	{
		BibtexEntry entry = new BibtexEntry(CUSTOM_ID, BibtexEntryType.BOOK);
		Assert.assertEquals(BibtexEntryType.BOOK.getGeneralFields(), entry.getGeneralFields());
	}
	
	@Test
	public void testSetTypeToNull()
	{
		BibtexEntry entry = new BibtexEntry(CUSTOM_ID);
		Boolean caught = false;
		
		try
		{
			entry.setType(null);
		}
		catch (NullPointerException ex)
		{
			caught = true;
		}
		
		Assert.assertTrue(caught);
	}
	
}
