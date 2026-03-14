package ch09;

import java.io.File;
import java.util.Scanner;

public class ScannerEx2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("data2.txt"));
        int totalSum = 0;
        int cnt = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Scanner sc2 = new Scanner(line).useDelimiter(",");
            int sum = 0;

            while (sc2.hasNextInt()) {
                sum += sc2.nextInt();
            }

            System.out.println(line + ", sum = " + sum);
            totalSum += sum;
            cnt++;
        }

        System.out.println("Line: " + cnt + ", Total: " + totalSum);
    }
}
