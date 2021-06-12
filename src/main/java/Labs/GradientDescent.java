package Labs;

import static Labs.Support.*;

public class GradientDescent {

    public double modGr(double x1, double x2) {
        System.out.println("g[0] = "+fl1(x1, x2)+"\tg[1] = "+fl2(x1, x2));
        double f = Math.sqrt( Math.pow(fl1(x1, x2), 2) + Math.pow(fl2(x1, x2), 2) );
        return f;
    }

    public void run() {
        System.out.println("\n МЕТОД ГРАДИЕНТНОГО СПУСКА");
        double x1 = 1.0;
        double x2 = 1.0;
        double h = 0.01;
        while (modGr(x1, x2) > 0.001) {
            x1 = x1 - h*fl1(x1, x2);
            x2 = x2 - h*fl2(x1, x2);
        }
        System.out.println(modGr(x1, x2) + " " + x1 + " " + x2 + " " + fun(x1, x2));
    }

}
