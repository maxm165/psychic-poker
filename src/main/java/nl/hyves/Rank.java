package nl.hyves;

public enum Rank {
    ACE("A"),
    RANK2("2"),
    RANK3("3"),
    RANK4("4"),
    RANK5("5"),
    RANK6("6"),
    RANK7("7"),
    RANK8("8"),
    RANK9("9"),
    TEN("T"),
    JACK("J"),
    QUEEN("Q"),
    KING("K");

    private final String shortName;

    private Rank(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public static Rank getRankByName(final String rankName) {
        for (Rank rank : Rank.values()) {
            if (rank.getShortName().equals(rankName)) {
                return rank;
            }
        }
        throw new IllegalArgumentException("illegal rank name: " + rankName);
    }
}
