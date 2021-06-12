package Labs;

public class App {
    public static void main( String[] args ) {

        GradientDescent gradientDescent = new GradientDescent();
        gradientDescent.run();

        ConjugateGradients conjugateGradients = new ConjugateGradients();
        conjugateGradients.run();

        DFP dfp = new DFP();
        dfp.run();

        Newton_sMethod Obj = new Newton_sMethod();
        Obj.run();

    }
}
