package test.java.unit;

import net.sf.jabref.BibtexString;
import org.junit.Assert;
import org.junit.Test;

public class BibtexStringTest
{
  @Test
  public void testBibtexStringConstructAndGetters()
  {
    BibtexString bibtexString = new BibtexString("id", "name", "content");
    Assert.assertEquals(bibtexString.getId(), "id");
    Assert.assertEquals(bibtexString.getName(), "name");
    Assert.assertEquals(bibtexString.getContent(), "content");
  }

  @Test
  public void testBibtexStringSetters()
  {
    BibtexString bibtexString = new BibtexString("id", "name", "content");
    bibtexString.setId("new id");
    bibtexString.setName("new name");
    bibtexString.setContent("new content");
    Assert.assertEquals(bibtexString.getId(), "new id");
    Assert.assertEquals(bibtexString.getName(), "new name");
    Assert.assertEquals(bibtexString.getContent(), "new content");
  }

  @Test
  public void testBibtexStringClone()
  {
    BibtexString bibtexString = new BibtexString("id", "name", "content");
    BibtexString bibtexClone = (BibtexString) bibtexString.clone();
    Assert.assertEquals(bibtexString.getId(), bibtexClone.getId());
    Assert.assertEquals(bibtexString.getName(), bibtexClone.getName());
    Assert.assertEquals(bibtexString.getContent(), bibtexClone.getContent());
  }
}
