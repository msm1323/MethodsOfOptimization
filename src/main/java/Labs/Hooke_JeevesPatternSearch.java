package Labs;

import java.lang.*;

public class Hooke_JeevesPatternSearch {

    private double e = 0.001;
    private double h = 1.0;       //step
    private double a = 2.0;       //coefficient
    private int vec[] = {1, 0, 0, 1};
    private double x1pr;
    private double x2pr;
    private double x1base = -1.0;
    private double x2base = -1.0;

    public double f(double x1, double x2){
        return ( 10*Math.pow( (Math.pow(x1,2)-x2), 2)+Math.pow((x1-1),2) );
    }

    private boolean explSearch(){
        System.out.println("Исследующий поиск:");
        x1pr = x1base;  x2pr = x2base;
        for( int i=0; i<4; i+=2 ){
            System.out.println("f( "+(x1base+h*vec[i])+","+ (x2base+h*vec[i+1]) +") > f("+x1base+", "+x2base+") ?");
            System.out.println( f( x1base+h*vec[i], x2base+h*vec[i+1]) + " > "+ f(x1base, x2base)+"?" );

            if( f( x1base+h*vec[i], x2base+h*(vec[i+1])) < f(x1base, x2base) ){
                System.out.println("Yes!");
                x1base += h*vec[i];  x2base += h*vec[i+1];
                System.out.println("x1base = "+x1base+"\t"+"x2base = "+x2base);
            }else {
                System.out.println("No.");
            }
        }
        if( (x1pr == x1base) && (x2pr == x2base) ){
            return true;
        }else{
            return false;
        }
    }

    private void searchSample() {
        System.out.println("Движение по образцу:");
        x1base = x1pr + a*(x1base - x1pr);
        x2base = x2pr + a*(x2base - x2pr);
        System.out.println("x1base = "+x1base+"\t"+"x2base = "+x2base);
        method();
    }

    public void method(){
        System.out.println("h = "+h);
        if( explSearch() ){
            System.out.println("h < e ?");
            System.out.printf("%s < %s%n", h, e);
            if(h < e){
                System.out.println("Цель достигнута!");
                System.out.println("x1 = "+x1base+"\t"+"x2 = "+x2base);
                System.out.println("f(x1, x2) = "+f(x1base, x2base));
                return ;
            }
            h = h/a;
            method();
        }else{
            searchSample();
        }
    }

}


