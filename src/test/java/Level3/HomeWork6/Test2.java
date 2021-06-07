package Level3.HomeWork6;
/*
    [ 1 1 1 4 4 1 4 4 ] -> true
    [ 1 1 1 1 1 1 ] -> false
    [ 4 4 4 4 ] -> false
    [ 1 4 4 1 1 4 3 ] -> false
 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Test2 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 1, 4, 4, 1, 4, 4}, true},
                {new int[]{1, 1, 1, 1, 1, 1}, false},
                {new int[]{4, 4, 4, 4}, false},
                {new int[]{1, 4, 4, 1, 1, 4, 3}, false}
        });
    }
    private int[] in;
    private boolean out;

    public Test2(int[] in, boolean out) {
        this.in = in;
        this.out = out;
    }

    private Main check1And4;

    @Before
    public void startTest() {
        check1And4 = new Main();
    }

    @Test
    public void testCheck1And4() {
        Assert.assertEquals(Main.check1And4(in), out);
    }
}
