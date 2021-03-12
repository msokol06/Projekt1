package Day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AssertionTest {
    @Test
    public void thisCanPass() throws FileNotFoundException {

        Assert.assertEquals(1, 1);
        String expectedText = "asd";

        Assert.assertEquals("asd", expectedText);

    }


}
