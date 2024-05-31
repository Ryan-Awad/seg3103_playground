import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {
    @Test
    void TC1() {
        Date d = new Date(1700, 6, 20);
        assertEquals(new Date(1700, 6, 21), d.nextDate());
    }

    @Test
    void TC2() {
        Date d = new Date(2005, 4, 15);
        assertEquals(new Date(2005, 4, 16), d.nextDate());
    }

    @Test
    void TC3() {
        Date d = new Date(1901, 7, 20);
        assertEquals(new Date(1901, 7, 21), d.nextDate());
    }

    @Test
    void TC4() {
        Date d = new Date(3456, 3, 27);
        assertEquals(new Date(3456, 3, 28), d.nextDate());
    }

    @Test
    void TC5() {
        Date d = new Date(1500, 2, 17);
        assertEquals(new Date(1500, 2, 18), d.nextDate());
    }

    @Test
    void TC6() {
        Date d = new Date(1700, 6, 29);
        assertEquals(new Date(1700, 6, 30), d.nextDate());
    }

    @Test
    void TC7() {
        Date d = new Date(1800, 11, 29);
        assertEquals(new Date(1800, 11, 30), d.nextDate());
    }

    @Test
    void TC8() {
        Date d = new Date(3453, 1, 29);
        assertEquals(new Date(3453, 1, 30), d.nextDate());
    }

    @Test
    void TC9() {
        Date d = new Date(444, 2, 29);
        assertEquals(new Date(444, 3, 1), d.nextDate());
    }

    @Test
    void TC10() {
        Date d = new Date(2005, 4, 30);
        assertEquals(new Date(2005, 5, 1), d.nextDate());
    }

    @Test
    void TC11() {
        Date d = new Date(3453, 1, 30);
        assertEquals(new Date(3453, 1, 31), d.nextDate());
    }

    @Test
    void TC12() {
        Date d = new Date(3456, 3, 30);
        assertEquals(new Date(3456, 3, 31), d.nextDate());
    }

    @Test
    void TC13() {
        Date d = new Date(1901, 7, 31);
        assertEquals(new Date(1901, 8, 1), d.nextDate());
    }

    @Test
    void TC14() {
        Date d = new Date(3453, 1, 31);
        assertEquals(new Date(3453, 2, 1), d.nextDate());
    }

    @Test
    void TC15() {
        Date d = new Date(3456, 12, 31);
        assertEquals(new Date(3457, 1, 1), d.nextDate());
    }

    @Test
    void TC16() {
        Date d = new Date(1500, 2, 31);
        assertThrows(IllegalArgumentException.class, d::nextDate);
    }

    @Test
    void TC17() {
        Date d = new Date(1500, 2, 29);
        assertThrows(IllegalArgumentException.class, d::nextDate);
    }

    @Test
    void TC18() {
        Date d = new Date(-1, 10, 20);
        assertThrows(IllegalArgumentException.class, d::nextDate);
    }

    @Test
    void TC19() {
        Date d = new Date(1458, 15, 12);
        assertThrows(IllegalArgumentException.class, d::nextDate);
    }

    @Test
    void TC20() {
        Date d = new Date(1975, 6, -50);
        assertThrows(IllegalArgumentException.class, d::nextDate);
    }
}