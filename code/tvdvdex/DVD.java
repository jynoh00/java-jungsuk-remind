package tvdvdex;

public class DVD {
    protected int counter;

    public void play() { System.out.println("playing DVD"); }
    public void stop() { System.out.println("stopping DVD"); }
    public void reset() { System.out.println("reset DVD"); }
    public int getCounter() { return counter; }
    public void setCounter(int c) { counter = c; }
}