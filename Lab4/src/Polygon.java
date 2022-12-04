public abstract class Polygon extends GeometricFigure {

    protected int amountSides;
    protected double[] sides;

    public Polygon(double[] sides) {
        this.amountSides = sides.length;
        this.sides = sides;

        if (amountSides < 3){
            throw new RuntimeException("Некорректный многоульник!");
        }

        double sum = 0, max = 0;
        for (double side : sides) {
            sum += side;
            max = Math.max(max, side);
        }
        if (sum <= max*2){
            throw new RuntimeException("Некорректный многоульник!");
        }
    }
    @Override
    public double getPerimeter() {
        double P = 0;
        for (double side : sides) P += side;
        return P;
    }

}
