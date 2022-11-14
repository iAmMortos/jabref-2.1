package test.java.unit;

import net.sf.jabref.BibtexString;
import net.sf.jabref.BibtexStringComparator;
import org.junit.Assert;
import org.junit.Test;

public class BibtexStringComparatorTest
{
  @Test
  public void testBibtexStringComparator()
  {
    BibtexString s1 = new BibtexString("s1", "BibtexString s1", "foo");
    BibtexString s2 = new BibtexString("s2", "BibtexString s2", "bar");

    BibtexStringComparator bsc = new BibtexStringComparator(true);
    int comp = bsc.compare(s1, s2);

    System.out.println("hello");
  }
}
