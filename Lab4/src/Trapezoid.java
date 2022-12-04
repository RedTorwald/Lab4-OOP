public class Trapezoid extends Polygon {

    private double h;
    public Trapezoid(double[] sides) {
        super(sides);
        double a = Math.abs(sides[0] - sides[1]);
        Triangle triangle = new Triangle(new double[]{a, sides[2], sides[3]});
        h = triangle.getSquare()*2/a;
    }

    @Override
    public double getSquare() {
        return (sides[0]+sides[1])*h/2;
    }

    @Override
    public String toString() {
        return String.format("Трапеция с основаниями: %s и %s и боковыми сторонами: %s и %s", sides[0], sides[1], sides[2], sides[3]);
    }
}
