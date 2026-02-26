package tvdvdex;

public class TvDVD extends Tv{
    DVD dvd = new DVD();

    public void play() { dvd.play(); }
    public void stop() { dvd.stop(); }
    public void reset() { dvd.reset(); }
    public int getCounter() { return dvd.getCounter(); }
    public void setCounter(int c) { dvd.setCounter(c); }
}
