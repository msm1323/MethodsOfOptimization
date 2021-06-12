package Labs;

public class Support {

    protected static double fun( double x1, double x2 ){
        return (5*x1 + 4*x1*x2 + Math.pow(x2,2) - 16* Math.pow(x1,2) - 12*x2 );
    }

    protected static double modGr(double x1, double x2) {
        return ( Math.sqrt(Math.pow(fl1(x1, x2), 2) + Math.pow(fl2(x1, x2), 2)) );
    }

    protected static double fl1(double x1, double x2){
        return ( 5+4*x2-32*x1 );
    }

    protected static double fl2(double x1, double x2){
        return ( 4*x1+2*x2-12 );
    }

}
