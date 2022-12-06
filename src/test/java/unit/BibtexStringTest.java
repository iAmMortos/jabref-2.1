package test.java.unit;

import net.sf.jabref.BibtexString;
import org.junit.Assert;
import org.junit.Test;

public class BibtexStringTest
{
  private static final String ID = "id";
  private static final String NAME = "name";
  private static final String CONTENT = "content";
  private static final String NEW_ID = "new id";
  private static final String NEW_NAME = "new name";
  private static final String NEW_CONTENT = "new content";

  @Test
  public void testBibtexStringConstructAndGetters()
  {
    BibtexString bibtexString = new BibtexString(ID, NAME, CONTENT);
    Assert.assertEquals(bibtexString.getId(), ID);
    Assert.assertEquals(bibtexString.getName(), NAME);
    Assert.assertEquals(bibtexString.getContent(), CONTENT);
  }

  @Test
  public void testBibtexStringSetId()
  {
    BibtexString bibtexString = new BibtexString(ID, NAME, CONTENT);
    bibtexString.setId(NEW_ID);
    Assert.assertEquals(bibtexString.getId(), NEW_ID);
  }

  @Test
  public void testBibtexStringSetName()
  {
    BibtexString bibtexString = new BibtexString(ID, NAME, CONTENT);
    bibtexString.setName(NEW_NAME);
    Assert.assertEquals(bibtexString.getName(), NEW_NAME);
  }

  @Test
  public void testBibtexStringSetContent()
  {
    BibtexString bibtexString = new BibtexString(ID, NAME, CONTENT);
    bibtexString.setContent(NEW_CONTENT);
    Assert.assertEquals(bibtexString.getContent(), NEW_CONTENT);
  }

  @Test
  public void testBibtexStringClone()
  {
    BibtexString bibtexString = new BibtexString(ID, NAME, CONTENT);
    BibtexString bibtexClone = (BibtexString) bibtexString.clone();
    Assert.assertEquals(bibtexString.getId(), bibtexClone.getId());
    Assert.assertEquals(bibtexString.getName(), bibtexClone.getName());
    Assert.assertEquals(bibtexString.getContent(), bibtexClone.getContent());
  }
  
  @Test
  public void testBibtexStringNullContent()
  {
	  BibtexString bibtexString1 = new BibtexString(ID, NAME, null);
	  Assert.assertNotNull(bibtexString1.getContent());
  }

  @Test
  public void testBibtexStringBlankContent()
  {
	  BibtexString bibtexString2 = new BibtexString(ID, NAME, "");
	  
	  Assert.assertEquals("", bibtexString2.getContent());
  }

  @Test
  public void testBibtexStringExplicitContent()
  {
	  BibtexString bibtexString3 = new BibtexString(ID, NAME, CONTENT);
	  
	  Assert.assertEquals(CONTENT, bibtexString3.getContent());
  }

  @Test
  public void testBibtexStringContentNullVsBlankString()
  {
	  BibtexString bibtexString1 = new BibtexString(ID, NAME, null);
	  BibtexString bibtexString2 = new BibtexString(ID, NAME, "");
	  
	  Assert.assertNotEquals(bibtexString1, bibtexString2);
  }
}
