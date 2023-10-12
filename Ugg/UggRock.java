public class UggRock {
    private UggRockSize size;
    private UggRockType type;
    
    public UggRock(UggRockSize size, UggRockType type) {
        this.size = size;
        this.type = type;
    }

    public UggRockSize getSize() {
        return this.size;
    }

    public UggRockType getType() {
        return this.type;
    }

    public String toString() {
        return getType().toString() + ", " + getSize().toString();
    }

    public int rockValue() {
        return this.size.getMultiplierValue() * this.type.getMultiplierValue();
    }
}
