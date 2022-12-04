public class RegularPolygon extends Polygon{

    public RegularPolygon(int N, double side) {
        super(new double[]{side, side, side});
        if (N < 3) throw new RuntimeException("Не является многоугольником!");
        this.amountSides = N;
    }
    @Override
    public double getSquare() {
        return sides[0]*sides[0]*amountSides/4/Math.tan(Math.toRadians(180./amountSides));
    }
    @Override
    public double getPerimeter() {
        return amountSides*sides[0];
    }

    @Override
    public String toString() {
        String str;
        switch (amountSides) {
            case 3: str = String.format("Равносторонний треугольник со стороной %s", sides[0]); break;
            case 4: str = String.format("Квадрат со стороной %s", sides[0]); break;
            default: str = String.format("Правильный %s-угольник со стороной %s", amountSides, sides[0]); break;
        }
        return str;
    }

}
