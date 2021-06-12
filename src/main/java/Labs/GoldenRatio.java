package Labs;

import java.util.Scanner;

public class GoldenRatio {

    public void go(){
        double a;
        double b;
        Scanner in = new Scanner(System.in);
        System.out.println("[ вводите значения типа double через зяпятую ]");
        System.out.println("Введиите последовательно через Enter начало и конец отрезка:");
        a = in.nextDouble();           //-1
        b = in.nextDouble();           //-0.5
        double e;
        System.out.println("Введите требуемую погрешность:");
        e = in.nextDouble();           //0.005
        double c = 0;
        double d = 0;
        c = 0.618*a + 0.382*b;
        d = 0.382*a + 0.618*b;
        int i=0;
        while( Math.abs((a - b)/2) > e ) {
            i++;
            System.out.println("Итерация № " + i + ":");
            System.out.println("a = " + a + "  b = " + b + "  c = " + c + "  d = " + d);
            double fc = 2 * c + Math.pow(c, 2) - 0.2 * Math.pow(c, 5);
            System.out.println("f(c) = " + fc);
            double fd = 2 * d + Math.pow(d, 2) - 0.2 * Math.pow(d, 5);
            System.out.println("f(d) = " + fd);

            if (fc < fd) {
                b = d;
                d = c;
                c = 0.618 * a + 0.382 * b;
            } else {
                a = c;
                c = d;
                d = 0.382 * a + 0.618 * b;
            }
            System.out.println("e = " + Math.abs((a - b) / 2));
        }
    }
}
