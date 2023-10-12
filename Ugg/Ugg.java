import java.util.Random;

public class Ugg {
    enum UggRockSize {
        BIGUN(5),
        QUITE_BIGUN(3),
        NOT_SO_BIGUN(1);

        private final int multiplierValue;

        private UggRockSize(int multiplierValue) {
            this.multiplierValue = multiplierValue;
        }

        public int getMultiplierValue() {
            return this.multiplierValue;
        }

        public static UggRockSize getRandom() {
            Random rng = new Random();
            int index = (int) Math.floor(rng.nextDouble() * 9.0);
            UggRockSize[] sizes = {UggRockSize.NOT_SO_BIGUN, UggRockSize.NOT_SO_BIGUN, UggRockSize.NOT_SO_BIGUN, UggRockSize.NOT_SO_BIGUN, UggRockSize.NOT_SO_BIGUN, UggRockSize.NOT_SO_BIGUN, 
                                UggRockSize.QUITE_BIGUN, UggRockSize.QUITE_BIGUN,
                                UggRockSize.BIGUN
            };

            return sizes[index];
        }
    }
    
    enum UggRockType {
        SPECKILY(7),
        OUCHY_BLACK(20),
        FLOATY(2),
        HOT_HOT_HOT(15);

        private final int multiplierValue;

        private UggRockType(int multiplierValue) {
            this.multiplierValue = multiplierValue;
        }

        public int getMultiplierValue() {
            return this.multiplierValue;
        }

        public static UggRockType getRandom() {
            Random rng = new Random();
            int index = (int) Math.floor(rng.nextDouble() * 4.0);
            
            UggRockType[] types = { UggRockType.FLOATY, UggRockType.HOT_HOT_HOT, UggRockType.OUCHY_BLACK,
                UggRockType.SPECKILY };
            return types[index];
        }
    }

    public static class UggRock {
        private final UggRockSize size;
        private final UggRockType type;

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

        @Override
        public String toString() {
            return getType().toString() + ", " + getSize().toString();
        }

        public int rockValue() {
            return this.size.getMultiplierValue() * this.type.getMultiplierValue();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable(){
            public void run() {
                for (int i = 0; i < 20; i++) {
                    UggRock rock = drawRock();
                    System.out.println(Thread.currentThread().getName() + " got " + rock.toString());
                }
            }
        }, "Thread 2");
        Thread t2 = new Thread(new Runnable(){
            public void run() {
                for (int i = 0; i < 20; i++) {
                    UggRock rock = drawRock();
                    System.out.println(Thread.currentThread().getName() + " got " + rock.toString());
                }
            }
        }, "Thread 1");

        t1.start();
        t2.start();
    }

    public static UggRock drawRock() {
        return new UggRock(UggRockSize.getRandom(), UggRockType.getRandom());
    }
}
