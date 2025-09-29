package Opgave;

public class Marsvin {
    private String name;
    private String race;
    private int foder;

    public Marsvin(String name,String race, int foder) {
        this.name = name;
        this.race = race;
        this.foder = foder;
    }
    public String getName() {
        return name;
    }
    public String getRace() {
        return race;
    }
    public int getFoder() {
        return foder;
    }
    @Override
    public String toString() {
        return name + ": " + race + ": " + foder;
    }
}
