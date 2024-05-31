import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.LinkedList;
import java.util.List;

@RunWith(Parameterized.class)
public class DateNextDateOkTest
{
    private int year;
    private int month;
    private int day;
    private Date expected;

    public DateNextDateOkTest(int year, int month, int day, int expectedYear, int expectedMonth, int expectedDay) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.expected = new Date(expectedYear, expectedMonth, expectedDay);
    }

    @Parameters
    public static List<Integer[]> data() {
        List<Integer[]> params = new LinkedList<Integer[]>();
        params.add(new Integer[]{1700, 6, 20, 1700, 6, 21});
        params.add(new Integer[]{2005, 4, 15, 2005, 4, 16});
        params.add(new Integer[]{1901, 7, 20, 1901, 7, 21});
        return params;
    }

    @Test
    public void testNextDate() {
        Date date = new Date(this.year, this.month, this.day);
        Assert.assertEquals(this.expected, date.nextDate());
    }
}