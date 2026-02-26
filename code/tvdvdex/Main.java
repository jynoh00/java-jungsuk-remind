package tvdvdex;

public class Main {
    public static void main(String[] args) {
        TvDVD tvDVD = new TvDVD();

        tvDVD.play();
        tvDVD.stop();
        tvDVD.reset();

        System.out.println(tvDVD.getCounter());
        tvDVD.setCounter(30);
        System.out.println(tvDVD.getCounter());
    }
}
