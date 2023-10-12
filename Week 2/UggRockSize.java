public enum UggRockSize {
    BIGUN(5),
    QUITE_BIGUN(3),
    NOT_SO_BIGUN(1);

    private int multiplierValue;

    private UggRockSize(int multiplierValue) {
        this.multiplierValue = multiplierValue;
    }

    public int getMultiplierValue() {
        return this.multiplierValue;
    }
}
