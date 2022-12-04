public class Parallelogram extends Polygon{

    public double angle;
    public int type = 1;
    public Parallelogram(double side1, double side2, double angle) {
        super(new double[]{side1, side2, side1, side2});
        if (angle <= 0){
            throw new RuntimeException("Отрицательный или нулевой угол!");
        }
        this.angle = angle;
        if (angle == 90 && side1 == side2) type = 4;
        else if (angle == 90) type = 3;
        else if (side1 == side2) type = 2;
        else type = 1;
    }
    public Parallelogram(double side1, double angle) {
        super(new double[]{side1, side1, side1, side1});
        if (angle <= 0){
            throw new RuntimeException("Отрицательный или нулевой угол!");
        }
        this.angle = angle;
        if (angle == 90) type = 4;
        else type = 2;
    }

    @Override
    public double getSquare() {
        return sides[0]*sides[1]*Math.sin(Math.toRadians(angle));
    }

    @Override
    public String toString() {
        String str;
        switch (type) {
            case 4: str = String.format("Квадрат со стороной %s", sides[0]); break;
            case 3: str = String.format("Прямоугольник со сторонами %s и %s", sides[0], sides[1]); break;
            case 2: str = String.format("Ромб со стороной %s и углом %s°", sides[0], Math.min(angle, 180-angle)); break;
            default: str = String.format("Параллелограм\nСмежные стороны: %s и %s\nУгол наклона: %s°", sides[0], sides[1], Math.min(angle, 180-angle)); break;
        }
        return str;
    }
}
