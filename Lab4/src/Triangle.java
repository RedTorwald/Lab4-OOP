
public class Triangle extends Polygon {

    public int type = 0;
    public Triangle(double[] sides) {
        super(sides);
        if (sides[0] == sides[1] && sides[1] == sides[2]) type = 1;
        else if (sides[0] == sides[1] || sides[0] == sides[2] || sides[1] == sides[2]) type = 2;
        else type = 3;
    }

    public Triangle(double base, double side) {
        super(new double[]{base, side, side});
        if (2*side <= base){
            throw new RuntimeException("Фигура не является треугольником!");
        }
        if (base == side) type = 1;
        else type = 2;
    }

    public Triangle(double side) {
        super(new double[]{side, side, side});
        type = 1;
    }
    public Triangle(double side1, double side2, double side3) {
        super(new double[]{side1, side2, side3});
        type = 3;
    }

    @Override
    public double getSquare() {
        double p=getPerimeter()/2;
        double S = p;
        for (double side : sides){
            S *= p-side;
        }
        return Math.sqrt(S);
    }

    @Override
    public String toString() {
        String str;
        switch (type) {
            case 1: str = String.format("Равносторонний треугольник со стороной: %s", sides[0]); break;
            case 2: str = String.format("Равнобедренный треугольник с основание: %s и боковая стороной: %s", sides[0], sides[1]); break;
            default: str = String.format("Треугольник со сторонами: %s, %s, %s", sides[0], sides[1], sides[2] ); break;
        }
        return str;
    }
}
