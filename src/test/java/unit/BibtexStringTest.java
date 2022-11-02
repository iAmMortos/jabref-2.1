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
  public void testBibtexStringSetters()
  {
    BibtexString bibtexString = new BibtexString(ID, NAME, CONTENT);
    bibtexString.setId(NEW_ID);
    bibtexString.setName(NEW_NAME);
    bibtexString.setContent(NEW_CONTENT);
    Assert.assertEquals(bibtexString.getId(), NEW_ID);
    Assert.assertEquals(bibtexString.getName(), NEW_NAME);
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
}
