package Labs;

public class ConjugateGradientsFR {
    //значение функции в точке
    private double function(double first, double second)
    {
        double function = 5*first + 4*first*second+ Math.pow(second, 2) - 16* Math.pow(first, 2) - 12*second;
        return function;
    }

    //значение производной по х1 в точке
    private double functionGradFirst(double first, double second)
    {
        return -32 * first + 4 * second + 5;//20 * first - 4 * second - 20 * Math.Sqrt(5) ;
    }

    //значение производной по х2 в точке
    private double functionGradSecond(double first, double second)
    {
        return 4 * first + 2 * second - 12;//- 4 * first + 14 * second - 4 * Math.Sqrt(5);
    }

    //критерий остановки
    private double Stop(double first, double second)
    {
        double function = Math.sqrt(Math.pow(first, 2) + Math.pow(second, 2));
        return function;
    }

    protected void run()
    {
        //начальные значения переменных
        double first = 1;
        double second = 1;
        //погрешность
        double eps = 0.001;
        //значение функции в начальной точке
        double functionValue = function(first, second);
        //градиент
        double[] grad = new double[2];
        //критерий остановки
        double modGrad = 0;
        //-градиент
        double[] d = new double[2];
        //шаг
        double h = 0.001;
        //новые значения переменных
        double newFirst = first;
        double newSecond = second;
        double newModGrad = modGrad;

        grad[0] = functionGradFirst(first, second);
        grad[1] = functionGradSecond(first, second);
        modGrad = Stop(grad[0], grad[1]);
        d[0] = -grad[0];
        d[1] = -grad[1];

        int i = 0;

        while (modGrad > eps)
        {
            System.out.println("\n-------");
            System.out.println("(" + first + ", " + second + ")");
            System.out.println("f(x1, x2) = " + functionValue);

            //поиск минимального шага для данной итерации
            double minFunctionValue = functionValue;
            double step = 0.01;
            while (step < 1)
            {
                if(function(first - h * grad[0], second - h * grad[1]) < minFunctionValue)
                {
                    minFunctionValue = function(first - h * grad[0], second - h * grad[1]);
                    h = step;
                }
                step = step + 0.01;
            }
            //считаем новое значение точек
            newFirst = first + h * d[0];
            newSecond = second + h * d[1];
            //пересчитываем градиент
            grad[0] = functionGradFirst(newFirst, newSecond);
            grad[1] = functionGradSecond(newFirst, newSecond);
            newModGrad = Stop(grad[0], grad[1]);

            //шаг для d
            double t = (Math.pow(newModGrad, 2)) / (Math.pow(modGrad, 2));
            d[0] = grad[0] - t * d[0];
            d[1] = grad[1] - t * d[1];

            first = newFirst;
            second = newSecond;

            functionValue = function(first, second);
            modGrad = newModGrad;
            System.out.println("Критерий погрешности: " + modGrad);
            i++;
        }
        System.out.println("-------");
        System.out.println("Минимальное значение функции\nf(x1, x2) = 000\nдостигается в точке:");
        System.out.println("(" + first + ", " + second + ")");
        System.out.println("f(x1, x2) = " + function(first, second));
        System.out.println("Критерий погрешности: " + modGrad);
        //System.out.println("Шагов: " + (i-1).toString());
        //Console.ReadKey();
    }
}
