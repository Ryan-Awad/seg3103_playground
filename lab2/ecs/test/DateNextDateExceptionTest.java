import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.LinkedList;
import java.util.List;

@RunWith(Parameterized.class)
public class DateNextDateExceptionTest
{
    private int year;
    private int month;
    private int day;

    public DateNextDateExceptionTest(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Parameters
    public static List<Integer[]> data() {
        List<Integer[]> params = new LinkedList<Integer[]>();
        params.add(new Integer[]{1500, 2, 31});
        params.add(new Integer[]{1500, 2, 29});
        params.add(new Integer[]{-1, 10, 20});
        return params;
    }

    @Test
    public void testNextDate() {
        Date date = new Date(this.year, this.month, this.day);
        Assert.assertThrows(IllegalArgumentException.class, date::nextDate);
    }
}