package test.java.unit;

import net.sf.jabref.BibtexString;
import net.sf.jabref.BibtexStringComparator;
import org.junit.Assert;
import org.junit.Test;

public class BibtexStringComparatorTest
{
  @Test
  public void testRefsTrueIdenticalBStrings()
  {
    BibtexString s1; // = new BibtexString("s1", "BibtexString s1", "foo");
    BibtexString s2; // = new BibtexString("s2", "BibtexString s2", "bar");
    BibtexStringComparator bsc = new BibtexStringComparator(true);

    s1 = new BibtexString("ID", "S", "#ABC# #DEF# #GHI#");
    s2 = new BibtexString("ID", "S", "#ABC# #DEF# #GHI#");
    int comp = bsc.compare(s1, s2);
    Assert.assertEquals(0, comp);
  }

  @Test
  public void testRefsFalseDiffIds()
  {
    BibtexString s1;
    BibtexString s2;
    BibtexStringComparator bsc = new BibtexStringComparator(false);

    s1 = new BibtexString("ID1", "S", "#ABC# #DEF# #GHI#");
    s2 = new BibtexString("ID2", "S", "#ABC# #DEF# #GHI#");
    int comp = bsc.compare(s1, s2);
    Assert.assertEquals(0, comp);
  }

  @Test
  public void testRefsFalseDiffNamesLT()
  {
    BibtexString s1;
    BibtexString s2;
    BibtexStringComparator bsc = new BibtexStringComparator(false);

    s1 = new BibtexString("ID", "A", "#ABC# #DEF# #GHI#");
    s2 = new BibtexString("ID", "B", "#ABC# #DEF# #GHI#");
    int comp = bsc.compare(s1, s2);
    Assert.assertTrue(comp < 0);
  }

  @Test
  public void testRefsFalseDiffNamesGT()
  {
    BibtexString s1;
    BibtexString s2;
    BibtexStringComparator bsc = new BibtexStringComparator(false);

    s1 = new BibtexString("ID", "B", "#ABC# #DEF# #GHI#");
    s2 = new BibtexString("ID", "A", "#ABC# #DEF# #GHI#");
    int comp = bsc.compare(s1, s2);
    Assert.assertTrue(comp > 0);
  }
}
