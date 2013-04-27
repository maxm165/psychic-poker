package nl.hyves.detector;

import org.junit.Test;

public class HighestCardTest extends DetectorTest {

    @Test
    public void testCheckTrue() {
        assertTrueHands(new HighestCard(), createTrueHands());
    }

    private String[] createTrueHands() {
        return new String[]{
          "KS JC TS 4H 9C 2C 3C AD QS KH",
          "KS JC TS 4H 9C 2C 3C AD QS 4H" };
    }
}
