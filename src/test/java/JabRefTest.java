package test.java;

import net.sf.jabref.JabRef;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class JabRefTest
{
  @Test
  public void testJabRefExistence()
  {
    JabRef jabref = new JabRef(new String[0]);
    Assert.assertNotNull(jabref);
  }
}
