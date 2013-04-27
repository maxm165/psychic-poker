package nl.hyves.detector;

import org.junit.Test;

public class TwoPairsTest extends DetectorTest {

    @Test
    public void testCheckTrue() {
        assertTrueHands(new TwoPairs(), createTrueHands());
    }

    @Test
    public void testCheckFalse() {
        assertFalseHands(new TwoPairs(), createFalseHands());
    }

    private String[] createTrueHands() {
        return new String[]{
          "AH 2C 9S AD 3C KS QH JS JD KD",
          "KS KH JC JS 4H TC 2C 3C 2D AS",
          "KS JS 4H TC 2C 3C KH JC 2D AS",
          "JC JS 4H KS KH TC 3C AS 2D 2C",
          "4H TC 2C 3C 2D AS KS KH JC JS",
          "KS KH JC AS 4H TC JS 2C 3C 2D" };
    }

    private String[] createFalseHands() {
        return new String[]{
          "KS KH JC AS 4H TC 2C JS 3C 2D",
          "KS JS 4H TC 2C 3C 2D AS KH JC",
          "KS KH JC AS 4H TC 2C QS 3C 2D" };
    }
}
