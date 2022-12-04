public class Circle extends GeometricFigure {
    private double X;
    private double Y;
    private double R;

    public Circle(double X, double Y, double R) {
        this.X = X;
        this.Y = Y;
        if (R <= 0) throw new RuntimeException("Отрицательный или нулевой радиус!");
        this.R = R;
    }
    @Override
    public double getSquare() {
        return Math.PI * R * R;
    }
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * R;
    }

    @Override
    public String toString() {
        String str;
        str = String.format("Окружность c радиусом R = %s, X = %s, Y = %s", R, X, Y);
        return str;
    }

}
