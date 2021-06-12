package Labs;

import static Labs.Support.*;

public class ConjugateGradients {

    //критерий остановки
    private double stop(double x1, double x2)
    {
        return ( Math.sqrt(Math.pow(x1, 2) + Math.pow(x2, 2)) );
    }

    protected void run() {
        System.out.println("\nМЕТОД СОПРЯЖЁННЫХ ГРАДИЕНТОВ");
        double x1 = 1;
        double x2 = 1;
        double eps = 0.001;
        double[] grad = new double[2];
        double[] d = new double[2];
        double[][] A = new double[2][2];
        A[0][0] = -32;
        A[0][1] = 4;
        A[1][0] = 4;
        A[1][1] = 1;

        double h, t;
        double newx1;
        double newx2;
        grad[0] = fl1(x1, x2);
        grad[1] = fl2(x1, x2);
        d[0] = -grad[0];
        d[1] = -grad[1];
        double modGrad = stop(grad[0], grad[1]);

        while (modGrad > eps)
        {
            System.out.println("(" + x1 + ", " + x2 + ")\nf(x1, x2) = " + fun(x1, x2));
            grad[0] = fl1(x1, x2);
            grad[1] = fl2(x1, x2);
            h = -(grad[0] * d[0] + grad[1] * d[1]) /
                    ((d[0] * A[0][0] + d[1] * A[1][0]) * d[0] + (d[0] * A[0][1] + d[1] * A[1][1]) * d[1]);
            newx1 = x1 + h * d[0];
            newx2 = x2 + h * d[1];
            grad[0] = fl1(newx1, newx2);
            grad[1] = fl2(newx1, newx2);
            t = ((grad[0] * A[0][0] + grad[1] * A[1][0]) * d[0] + (grad[0] * A[0][1] + grad[1] * A[1][1]) * d[1]) /
                    ((d[0] * A[0][0] + d[1] * A[1][0]) * d[0] + (d[0] * A[0][1] + d[1] * A[1][1]) * d[1]);
            d[0] = -grad[0] + t * d[0];
            d[1] = -grad[1] + t * d[1];
            x1 = newx1;
            x2 = newx2;
            modGrad = stop(grad[0], grad[1]);
        }
        System.out.println("point of min: (" + x1 + ", " + x2 + ")\nf(x1, x2) = " + fun(x1, x2));
    }
}
