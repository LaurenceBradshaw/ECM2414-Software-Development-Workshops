public class MyCounter {
    private int count = 0;

    public synchronized void addTwo() {
        this.count += 2;
    }

    public synchronized void subtractTwo() {
        this.count -= 2;
    }

    public int countValue() {
        return this.count;
    }
}
