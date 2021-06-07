package Level3.HomeWork6;
/*
    Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
    Вх: [ 1 2 4 4 2 3 4 ] -> вых: [ ].
    Вх: [ 1 2 44 2 34 1 2 ] -> вых: RuntimeException.
    Вх: [ 1 2 1 7 ] -> вых: RuntimeException.
 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class Test1 {
    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}},
                {new int[]{1, 2, 4, 4, 2, 3, 4}, new int[]{}},
                {new int[]{1, 2, 44, 2, 34, 1, 2}, new int[]{}}, // что тут лучше написать вторым аргументом? new RuntimeException не катит...
                {new int[]{1, 2, 1, 7}, new int[]{}}             // аналогично. в консоли теста всё нормально пишет "В массиве нет 4"
        });
    }

    private int[] in;
    private int[] out;

    public Test1(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }

    private Main getFrom4ToInfinity;

    @Before
    public void startTest() {
        getFrom4ToInfinity = new Main();
    }

    @Test
    public void testFrom4ToInfinity() {
        Assert.assertArrayEquals(out, Main.getFrom4ToInfinity(in));
    }
}

