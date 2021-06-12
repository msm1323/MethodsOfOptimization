package Labs;

import java.util.ArrayList;
import java.lang.*;

public class ConjugateDirection {
    private double dirs[] = { 0.0, 1.0, 1.0, 0.0, 0.0, 1.0 };
    private ArrayList<Point> xlist = new ArrayList<>();
    private int it = 0;
    private double e = 0.001;

    ConjugateDirection(){
        Point Obj = new Point();
        Obj.x = 1.0;
        Obj.y = 1.0;
        xlist.add(Obj);
    }

    public class Point{
        private double x;
        private double y;
    }

    private double fl1(double x1, double x2){
        return ( 5+4*x2-32*x1 );
    }

    private double fl2(double x1, double x2){
        return ( 4*x1+2*x2-12 );
    }

    private double[] grad(double x1, double x2){
        double gr[] = {fl1(x1, x2), fl2(x1, x2)};
        return (gr);
    }

    private double fun( double x1, double x2 ){
        //5*x1 + 4*x1*x2 + Math.pow(x2,2) - 16* Math.pow(x1,2) - 12*x2
        return (5*x1 + 4*x1*x2 + Math.pow(x2,2) - 16* Math.pow(x1,2) - 12*x2 );
    }

    public void method(){
        double[] p = grad(xlist.get(xlist.size()-1).x, xlist.get(xlist.size()-1).y);
        System.out.println( "Grad f = "+p[0] +"; "+ p[1] );
        System.out.println("Итерация №" + it);
        check(grad(xlist.get(xlist.size()-1).x, xlist.get(xlist.size()-1).y));

        double h;
        for(int i=0; i<6; i+=2){
            double x = xlist.get(xlist.size()-1).x;
            double y = xlist.get(xlist.size()-1).y;
            System.out.println("x = "+x+"; y = "+y);
            h = -( (5*dirs[i]+4*x*dirs[i+1]+4*dirs[i]*y+2*y*dirs[i+1]-32*x*dirs[i]-12*dirs[i+1])/
                    (8*dirs[i]*dirs[i+1]+2*Math.pow(dirs[i+1], 2)-32*Math.pow(dirs[i], 2))  );
            System.out.println("h = "+h);
            Point Obj = new Point();
            Obj.x = xlist.get(xlist.size()-1).x + h*dirs[i];
            Obj.y = xlist.get(xlist.size()-1).y + h*dirs[i+1];
            System.out.println("new point = "+Obj.x+"; "+Obj.y);
            xlist.add(Obj);
        }
        dirs[0] = xlist.get(xlist.size()-1).x - xlist.get(xlist.size()-3).x;
        dirs[1] = xlist.get(xlist.size()-1).y - xlist.get(xlist.size()-3).y;
        dirs[4] = dirs[0];
        dirs[5] = dirs[1];
        it++;
        method();
    }

    private void check( double[] gr){
        System.out.println("CHECK:");
        double[] p = grad(xlist.get(xlist.size()-1).x, xlist.get(xlist.size()-1).y);
        System.out.println( "Grad f "+p[0] +"; "+ p[1] );
        System.out.println( Math.sqrt( Math.pow(gr[0], 2) + Math.pow(gr[1], 2) )+" < "+e+" ?");
        if( Math.sqrt( Math.pow(gr[0], 2) + Math.pow(gr[1], 2) ) < e ) {
            System.out.println("Цель достигнута!");
            System.out.println("point = "+ xlist.get(xlist.size()-1).x+"; "+xlist.get(xlist.size()-1).y);
            System.out.println(" f = "+ fun( xlist.get(xlist.size()-1).x, xlist.get(xlist.size()-1).y) );
            System.exit(0);
        }
    }
}




