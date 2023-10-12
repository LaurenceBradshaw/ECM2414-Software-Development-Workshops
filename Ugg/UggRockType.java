public enum UggRockType {
    SPECKILY(7),
    OUCHY_BLACK(20),
    FLOATY(2),
    HOT_HOT_HOT(15);

    private int multiplierValue;

    private UggRockType(int multiplierValue) {
        this.multiplierValue = multiplierValue;
    }

    public int getMultiplierValue() {
        return this.multiplierValue;
    }
}