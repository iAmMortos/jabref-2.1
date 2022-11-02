package test.java.integration;

import net.sf.jabref.JabRef;
import org.junit.Assert;
import org.junit.Test;

public class JabRefIntegrationTests
{
  @Test
  public void testJabRefExistence()
  {
    JabRef jabref = new JabRef(new String[0]);
    Assert.assertNotNull(jabref);
  }
}
