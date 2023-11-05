package P1;

public class Parabola {
    private final int a;
    private final int b;
    private final int c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String metoda1(Parabola p){
        double x1 = p.xVarf();
        double x2 = xVarfCurent();
        double y1 = p.yVarf();
        double y2 = yVarfCurent();

        double xParabola = (x1 + x2) / 2;
        double yParabola = (y1 + y2) / 2;

        return ("X: " + xParabola + " Y: " + yParabola);
    }

    public static String metoda2(Parabola p1, Parabola p2){
        double x1 = p1.xVarf();
        double x2 = p2.xVarf();
        double y1 = p1.yVarf();
        double y2 = p2.yVarf();

        //coordonatele varfului parabolei
        double xParabola = (x1 + x2) / 2;
        double yParabola = (y1 + y2) / 2;

        return ("X: " + xParabola + " Y: " + yParabola);
    }

    public double metoda3(Parabola p){
        double x1 = p.xVarf();
        double x2 = xVarfCurent();
        double y1 = p.yVarf();
        double y2 = yVarfCurent();

        //double xParabola = (x1 + x2) / 2;
        //double yParabola = (y1 + y2) / 2;

        return Math.hypot(x2 - x1, y2 - y1);
    }

    public static double metoda4(Parabola p1, Parabola p2){
        double x1 = p1.xVarf();
        double x2 = p2.xVarf();
        double y1 = p1.yVarf();
        double y2 = p2.yVarf();

        //coordonatele varfului parabolei
        //double xParabola = (x1 + x2) / 2;
        //double yParabola = (y1 + y2) / 2;

        return Math.hypot(x2 - x1, y2 - y1);
    }
    public double xVarf(){
        return -b/(2.0 * a);
    }

    public double xVarfCurent(){
        return -this.b/(2.0 * this.a);
    }

    public double yVarf(){
        double delta = (-b * b) + 4 * a * c;
        return delta / 4 * a;
    }
    public double yVarfCurent(){
        double delta = (-this.b * this.b) + 4 * this.a * this.c;
        return delta / 4 * this.a;
    }
    @Override
    public String toString(){
        return ("f(x) = " + a + " * x^2 + " + b + " * x + " + c);
    }
}
