package nl.hyves.detector;

import org.junit.Test;

public class FullHouseTest extends DetectorTest {

    @Test
    public void testCheckTrue() {
        assertTrueHands(new FullHouse(), createTrueHands());
    }

    @Test
    public void testCheckFalse() {
        assertFalseHands(new FullHouse(), createFalseHands());
    }

    private String[] createTrueHands() {
        return new String[]{
          "2H 2S 3H 3S 3C 2D 9C 3D 6C TH",
          "2H 2S 2H 3S 3C 2D 3D 6C 9C TH",
          "QD AD TC 9C 5H 2H 2S 2H 3S 3C",
          "2H 2S 2H 4D 5D 3S 3C 6C 9C TH",
          "2H 2S 2D 4C JC 3D 3C QD 2C AD",
          "2H 2S 2D 4C JC 3D QC QD QS 3C" };
    }

    private String[] createFalseHands() {
        return new String[]{
          "KS AH 2H 3C 4H KC 2C TC 2D AS",
          "2H 2S 2H 4D 5D 6C 3S 3C 9C TH",
          "2H 2S 2D 2C JC QD 3D 3C 2C AD",
          "2H 2S 2D 2C JC QD 2C AD 3D 3C" };
    }
}
