package Labs;

import static Labs.Support.*;

public class DFP {

    public void run () {
        System.out.println("\nМЕТОД ДЭВИДОНА-ФЛЕТЧЕРА-ПАУЭЛЛА");
        double x1 = 1.0;
        double x2 = 1.0;
        double h = 0.0001;
        double[][] A = new double[2][2];
        double[][] An = new double[2][2];
        A[0][0] = 1;
        A[1][1] = 1;
        double t = minT(x1, x2, A);
        double X1 = x1-t*A[0][0]*((fun(x1+h, x2) - fun(x1, x2))/h);
        double X2 = x2-t*A[1][1]*((fun(x1, x2+h) - fun(x1, x2))/h);
        while (Math.abs(fun(X1, X2) - fun(x1, x2)) > 0.02) {
            double dg1 = ((fun(X1+h, X2) - fun(X1, X2))/h) - ((fun(x1+h, x2) - fun(x1, x2))/h);
            double dg2 = ((fun(X1, X2+h) - fun(X1, X2))/h) - ((fun(x1, x2+h) - fun(x1, x2))/h);
            double dlx1 = X1 - x1;
            double dlx2 = X2 - x2;
            An[0][0] = (Math.pow(dlx1,2))/(dlx1*dg1+dlx2*dg2) - (A[0][0]*A[0][0]*dg1*dg1)/(dg1*dg1*A[0][0] + dg2*dg2*A[1][1]);
            An[1][1] = (Math.pow(dlx2,2))/(dlx1*dg1+dlx2*dg2) - (A[1][1]*A[1][1]*dg2*dg2)/(dg1*dg1*A[0][0] + dg2*dg2*A[1][1]);
            A[0][0] = A[0][0] + An[0][0];
            A[1][1] = A[1][1] + An[1][1];

            x1 = X1;
            x2 = X2;
            t = minT(x1,x2,A);
            X1 = x1-t*A[0][0]*((fun(x1+h, x2) - fun(x1, x2))/h);
            X2 = x2-t*A[1][1]*((fun(x1, x2+h) - fun(x1, x2))/h);
        }
        System.out.println("Module Gradient = "+modGr(x1, x2) + "\nx1 = " + x1 + "\nx2 = " + x2 + "\nf = " + fun(x1, x2));
    }

    public double minT (double x1, double x2, double [][] A) {
        double t = 0.01;
        double h = 0.00001;
        double minT = t;
        double F = fun(x1, x2);
        while (t < 1) {
            double X1 = x1-t*A[0][0]*((fun(x1+h, x2) - fun(x1, x2))/h);
            double X2 = x2-t*A[1][1]*((fun(x1, x2+h) - fun(x1, x2))/h);
            if (fun(X1, X2) < F) {
                F = fun(X1, X2);
                minT = t;
            }
            t = t + 0.01;
        }
        return minT;
    }
    
}

