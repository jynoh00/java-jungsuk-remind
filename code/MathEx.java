// Math.rint()는 round()처럼 소수점 첫 째자리에서 반올림하지만, 반환값이 double
// rint()는 반올림 메서드이나, 두 정수의 정가운데 있는 값이면 가장 가까운 짝수 정수로 반환한다.
// 양수와 달리 음수에서는 Math.floor()로 버림을 하면 작은 수가 된다. (-1.5 => -2, 1.5 => 1)
public class MathEx {
    public static void main(String[] args) {
        double val = 90.7552d;
        System.out.println(Math.round(val)); // 91
        System.out.println(Math.round(val*100)); // 9076
        System.out.println(Math.round(val*100)/100); // 9076/100 => 90
        System.out.println(Math.round(val*100)/100.0); // 9076/100.0 => 90.76

        System.out.println(Math.ceil(1.1)); // 2.0
        System.out.println(Math.floor(1.5)); // 1.0
        System.out.println(Math.round(1.1)); // 1
        System.out.println(Math.round(1.5)); // 2
        System.out.println(Math.rint(1.5)); // 2.0
        System.out.println(Math.round(-1.5)); // -1
        System.out.println(Math.rint(-1.5)); // -2.0
        System.out.println(Math.ceil(-1.5)); // -1.0
        System.out.println(Math.floor(-1.5)); // -2.0

        System.out.println(Math.rint(2.5)); // 2.0

        System.out.println(Math.rint(-2.5));
        System.out.println(Math.round(-2.5));
    }
}
