package Labs;

import static Labs.Support.*;

public class Newton_sMethod{

    private double[] multiplication(double grX, double grY){
        double[] g = new double[2];
        g[0] = 2*grX - 4*grY;
        g[1] = (-4)*grX - 32*grY;
        return g;
    }

    public void run(){
        System.out.println("\nМЕТОД НЬЮТОНА");
        //5*x1 + 4*x1*x2 + Math.pow(x2,2) - 16* Math.pow(x1,2) - 12*x2
        double e = 0.001;
        double x1 = 1;
        double x2 = 1;
        double[] g = new double[2];
        double modGr;
        int i=1;
        while(true) {
            System.out.println("Итерация № "+ i);
            g[0] = fl1(x1, x2);
            g[1] = fl2(x1, x2);
            System.out.println("Gradient = ("+g[0]+", "+g[1]+")");
            modGr = Math.sqrt(Math.pow(g[0], 2) + Math.pow(g[1], 2));
            System.out.println(modGr+" < "+e+" ?");
            if(modGr<e){
                System.out.println("Yes!");
                System.out.println("point of min: ("+ x1+", "+x2+")");
                System.out.println("f = "+fun(x1, x2));
                break;
            }
            System.out.println("No.");
            g = multiplication(g[0], g[1]);
            x1 = x1 + (g[0])/80 ;       //x1!?
            x2 = x2+ (g[1])/80 ;
            System.out.println("new point: ("+ x1+", "+x2+")");
            i++;
        }
    }

}
