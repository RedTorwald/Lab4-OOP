import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    //---------------------------------------------------------------------------------------
    private static Scanner in = new Scanner(System.in);
    private static final ArrayList<GeometricFigure> figures = new ArrayList<>();
    private static GeometricFigure figure=null;
    public static void startMenu(){mainMenu();}

    //---------------------------------------------------------------------------------------
    private static String report(GeometricFigure figure) {
        return String.format("%s\n%s: %.3f\nПлощадь: %.3f", figure.toString(),
                        figure.getClass() == Circle.class ? "Длина окружности" : "Периметр",
                        figure.getPerimeter(), figure.getSquare());
    }
    //---------------------------------------------------------------------------------------
    public static int checkPoint(){
        Scanner scan = new Scanner(System.in);
        int redPoint;
        try{
            redPoint=Integer.parseInt(scan.nextLine());
        }
        catch(NumberFormatException e){
            System.out.println("Некорректный ввод! Введите число.");
            redPoint=checkPoint();
        }
        return redPoint;
    }
    //---------------------------------------------------------------------------------------
    private static void printAll() {
        if (figures.isEmpty()) {
            System.out.println("Данные для отображения отсутствуют");
        }
        else
        {
            System.out.printf("Количество фигур в списке = %s", figures.size());
            System.out.println();
            for (GeometricFigure fig : figures){
                System.out.println(fig);
            }
        }
    }
    //---------------------------------------------------------------------------------------
    private static void printAllSquare() {
        if (figures.isEmpty()) {
            System.out.println("Данные для отображения отсутствуют");
        }
        else
        {
            System.out.printf("Количество фигур в списке = %s", figures.size());
            System.out.println();
            for (GeometricFigure fig : figures){

                if (fig.getClass()==Circle.class){System.out.println("Окружность");}
                else if (fig.getClass()==Triangle.class){System.out.println("Треугольник");}
                else if (fig.getClass()==Parallelogram.class){System.out.println("Параллелограмм");}
                else if (fig.getClass()==Trapezoid.class){System.out.println("Трапеция");}
                else if (fig.getClass()==RegularPolygon.class){System.out.println("Правильный многоугольник");}
                System.out.printf("Площадь = %s", fig.getSquare());
                System.out.println();
            }
        }
    }
    //---------------------------------------------------------------------------------------
    private static void search() {
        if (figures.isEmpty()) {
            System.out.println("Данные для отображения отсутствуют");
        }
        else {
            int point =-1;
            do{
                System.out.println("+=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+");
                System.out.println("|.............Поиск...............|");
                System.out.println("| [1]- Поиск фигуры          -[1] |");
                System.out.println("| [2]- Удаление фигуры       -[2] |");
                System.out.println("| [0]- Перейти в меню        -[0] |");
                System.out.println("+=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+");

                point=checkPoint();
                switch (point) {
                    case 1:
                        if (figures.size()!=0){
                            System.out.printf("Введите индекс элемента (от 0 до %s)", figures.size() - 1);

                            System.out.println("Введите индекс");

                            int index = checkPoint();

                            if (index >= figures.size() || index < 0){
                                System.out.println("Индекс вне диапозона!");
                                break;
                            }
                            if (index > -1){
                                figure = figures.get(index);
                                System.out.println(figure);
                            }
                        }
                        else{
                            System.out.println("Список пуст");
                        }
                        break;
                    case 2:
                        if (figures.size()!=0){
                            System.out.printf("Введите индекс элемента (от 0 до %s)", figures.size() - 1);
                            System.out.println("Введите индекс");

                            int index1 = checkPoint();

                            if (index1 >= figures.size()|| index1 < 0){
                                System.out.println("Индекс вне диапозона!");
                                break;
                            }

                            if (index1 > -1) {
                                figure = figures.get(index1);
                                figures.remove(figure);
                            }
                        }
                        else{
                            System.out.println("Список пуст");
                        }
                        break;
                    case 0:
                        System.out.println("Перейти в меню");
                        break;
                    default:
                        System.out.println("Неверный ввод пункта!");
                }
            }while (point!=0);
        }
    }
    //---------------------------------------------------------------------------------------
    private static void mainMenu(){
        int point =-1;
        do{
            System.out.println("+=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-+");
            System.out.println("|............Главное.Меню................|");
            System.out.println("| [1]- Добавить фигуру в список     -[1] |");
            System.out.println("| [2]- Поиск и удаление фигуры      -[2] |");
            System.out.println("| [3]- Вывод элементов списка       -[3] |");
            System.out.println("| [4]- Вывод площадей всех фигур    -[4] |");
            System.out.println("| [0]- Выход из программы           -[0] |");
            System.out.println("+=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-+");

            point=checkPoint();
            switch (point) {
                case 1:
                    choiceMenu();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    printAll();
                    break;
                case 4:
                    printAllSquare();
                    break;
                case 0:
                    System.out.println("Выход из программы");
                    break;
                default:
                    System.out.println("Неверный ввод пункта!");
            }
        }while (point!=0);
    }
    //---------------------------------------------------------------------------------------
    private static void choiceMenu(){
        int point =-1;
        do{
            System.out.println("+=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+");
            System.out.println("|..........Выбор фигуры...........|");
            System.out.println("| [1]- Окружность            -[1] |");
            System.out.println("| [2]- Треугольник           -[2] |");
            System.out.println("| [3]- Параллелограмм        -[3] |");
            System.out.println("| [4]- Трапеция              -[4] |");
            System.out.println("| [5]- Правильный N угольник -[5] |");
            System.out.println("| [0]- Перейти в меню        -[0] |");
            System.out.println("+=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+");

            point=checkPoint();
            switch (point) {
                case 1:
                    circleInput();
                    break;
                case 2:
                    triangleInput();
                    break;
                case 3:
                    parallelogramInput();
                    break;
                case 4:
                    trapezoidInput();
                    break;
                case 5:
                    regularPolygonInput();
                    break;
                case 0:
                    System.out.println("Переход в главное меню");
                    break;
                default:
                    System.out.println("Неверный ввод пункта!");
            }
        }while (point!=0);
    }
    //---------------------------------------------------------------------------------------
    private static void circleInput(){
        int point =-1;
        do {
            System.out.println("+=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-+");
            System.out.println("|.........Ввод окуржности..........|");
            System.out.println("| [1]- Задать окружность      -[1] |");
            System.out.println("| [0]- Перейти к выбору фигур -[0] |");
            System.out.println("+=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-+");
            point = checkPoint();
            try{
                switch (point) {
                    case 1:
                        System.out.println("Введите X");
                        double X = Double.parseDouble(in.nextLine());

                        System.out.println("Введите Y");
                        double Y = Double.parseDouble(in.nextLine());

                        System.out.println("Введите радиус");
                        double R = Double.parseDouble(in.nextLine());

                        if (R<0){
                            throw new RuntimeException("Радиус не может быть отрицательным! Повторите ввод.");
                        }
                        GeometricFigure circle=new Circle(X,Y,R);
                        System.out.println(report(circle));

                        figures.add(circle);

                    break;
                    case 0:
                        System.out.println("Переход в главное меню");
                    break;
                    default:
                        System.out.println("Неверный ввод пункта!");
                }
            }
            catch (Exception e)                  {System.out.println(e.getMessage());}
        }while (point!=0);
    }
    //---------------------------------------------------------------------------------------
    private static void triangleInput(){

        int point =-1;
        do {
            System.out.println("+=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+");
            System.out.println("|..............Ввод треугольника..............|");
            System.out.println("| [1]- Ввод произвольного треугольника   -[1] |");
            System.out.println("| [2]- Ввод равнобедренного треугольника -[2] |");
            System.out.println("| [3]- Ввод равностороннего треугольника -[3] |");
            System.out.println("| [0]- Перейти к выбору фигур            -[0] |");
            System.out.println("+=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+");
            point = checkPoint();
            try{
                switch (point) {
                    case 1:
                        double[] list=new double[6];
                        double X;
                        double Y;

                        for (int i=0; i<3; i++) {
                            System.out.printf("Введите X%s \n", i+1);
                            X= Double.parseDouble(in.nextLine());
                            System.out.printf("Введите Y%s \n", i+1);
                            Y= Double.parseDouble(in.nextLine());
                            list[i*2]+=X;
                            list[i*2+1]+=Y;
                        }
                        double side1=Math.sqrt((list[0]-list[2])*(list[0]-list[2]) + (list[1]-list[3])*(list[1]-list[3]));
                        double side2=Math.sqrt((list[2]-list[4])*(list[2]-list[4]) + (list[3]-list[5])*(list[3]-list[5]));
                        double side3=Math.sqrt((list[0]-list[4])*(list[0]-list[4]) + (list[1]-list[5])*(list[1]-list[5]));
                        GeometricFigure triangle=new Triangle(side1, side2, side3);

                        System.out.println(report(triangle));

                        figures.add(triangle);
                        break;
                    case 2:
                        System.out.println("Введите основание треугольника");
                        double base = Double.parseDouble(in.nextLine());
                        System.out.println("Введите боковую сторону треугольника");
                        double side4 = Double.parseDouble(in.nextLine());
                        triangle=new Triangle(base, side4);
                        System.out.println(report(triangle));

                        figures.add(triangle);

                        break;
                    case 3:
                        System.out.println("Введите сторону треугольника");
                        double side = Double.parseDouble(in.nextLine());
                        triangle=new Triangle(side);
                        System.out.println(report(triangle));

                        figures.add(triangle);

                        break;
                    case 0:
                        System.out.println("Переход в главное меню");
                        break;
                    default:
                        System.out.println("Неверный ввод пункта!");
                }
            }
            catch (Exception e)                  {System.out.println(e.getMessage());}
        }while (point!=0);
    }
    //---------------------------------------------------------------------------------------
    private static void parallelogramInput(){

        int point =-1;
        do {
            System.out.println("+=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-+");
            System.out.println("|.......Ввод параллелограмма.......|");
            System.out.println("| [1]- Ввод параллелограмма   -[1] |");
            System.out.println("| [2]- Ввод прямоугольника    -[2] |");
            System.out.println("| [3]- Ввод ромба             -[3] |");
            System.out.println("| [4]- Ввод квадрата          -[4] |");
            System.out.println("| [0]- Перейти к выбору фигур -[0] |");
            System.out.println("+=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-+");
            point = checkPoint();
            try{
                switch (point) {
                    case 1:
                        double[] list=new double[6];
                        double X;
                        double Y;

                        for (int i=0; i<3; i++) {
                            System.out.printf("Введите X%s \n", i+1);
                            X= Double.parseDouble(in.nextLine());
                            System.out.printf("Введите Y%s \n", i+1);
                            Y= Double.parseDouble(in.nextLine());
                            list[i*2]+=X;
                            list[i*2+1]+=Y;
                        }
                        double side1=Math.sqrt((list[0]-list[2])*(list[0]-list[2]) + (list[1]-list[3])*(list[1]-list[3]));
                        double side2=Math.sqrt((list[0]-list[4])*(list[0]-list[4]) + (list[1]-list[5])*(list[1]-list[5]));
                        double a=(list[2]*list[4]+list[3]*list[5])/(Math.sqrt(list[2]*list[2]+list[3]*list[3])  *  Math.sqrt(list[4]*list[4]+list[5]*list[5]));

                        double rad = Math.acos(a);
                        double angle=(180 / Math.PI) * rad;

                        GeometricFigure parallelogram=new Parallelogram(side1, side2, angle);
                        System.out.println(a);
                        System.out.println(report(parallelogram));

                        figures.add(parallelogram);

                        break;
                    case 2:
                        System.out.println("Введите первую сторону прямоугольника");
                        double side3 = Double.parseDouble(in.nextLine());
                        System.out.println("Введите вторую сторону прямоугольника");
                        double side4 = Double.parseDouble(in.nextLine());
                        System.out.println("Введите угол");
                        double angle1 = 90;
                        parallelogram=new Parallelogram(side3, side4, angle1);
                        System.out.println(report(parallelogram));
                        figures.add(parallelogram);

                        break;
                    case 3:
                        System.out.println("Введите сторону ромба");
                        double side5 = Double.parseDouble(in.nextLine());
                        System.out.println("Введите угол");
                        double angle2 = Double.parseDouble(in.nextLine());
                        parallelogram=new Parallelogram(side5, angle2);
                        System.out.println(report(parallelogram));

                        figures.add(parallelogram);

                        break;
                    case 4:
                        System.out.println("Введите сторону квадрата");
                        double side6 = Double.parseDouble(in.nextLine());
                        System.out.println("Введите угол");
                        double angle3 = 90;
                        parallelogram=new Parallelogram(side6, angle3);
                        System.out.println(report(parallelogram));

                        figures.add(parallelogram);

                        break;
                    case 0:
                        System.out.println("Переход в главное меню");
                        break;
                    default:
                        System.out.println("Неверный ввод пункта!");
                }
            }
            catch (Exception e)                  {System.out.println(e.getMessage());}
        }while (point!=0);
    }
    //---------------------------------------------------------------------------------------
    private static void trapezoidInput(){
        int point =-1;
        do {
            System.out.println("+=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-+");
            System.out.println("|..........Ввод трапеции...........|");
            System.out.println("| [1]- Ввод трапеции          -[1] |");
            System.out.println("| [0]- Перейти к выбору фигур -[0] |");
            System.out.println("+=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-+");
            point = checkPoint();
            try{
                switch (point) {
                    case 1:
                        double[] list=new double[8];
                        double X;
                        double Y;

                        for (int i=0; i<4; i++) {
                            System.out.printf("Введите X%s \n", i+1);
                            X= Double.parseDouble(in.nextLine());
                            System.out.printf("Введите Y%s \n", i+1);
                            Y= Double.parseDouble(in.nextLine());
                            list[i*2]+=X;
                            list[i*2+1]+=Y;
                        }
                        double side1=Math.sqrt((list[0]-list[6])*(list[0]-list[6]) + (list[1]-list[7])*(list[1]-list[7]));
                        double side2=Math.sqrt((list[2]-list[4])*(list[2]-list[4]) + (list[3]-list[5])*(list[3]-list[5]));
                        double side3=Math.sqrt((list[0]-list[2])*(list[0]-list[2]) + (list[1]-list[3])*(list[1]-list[3]));
                        double side4=Math.sqrt((list[4]-list[6])*(list[4]-list[6]) + (list[5]-list[7])*(list[5]-list[7]));

                        double[] lines=new double[]{side1, side2, side3, side4};
                        GeometricFigure trapezoid=new Trapezoid(lines);
                        System.out.println(report(trapezoid));

                        figures.add(trapezoid);

                        break;
                    case 0:
                        System.out.println("Переход в главное меню");
                        break;
                    default:
                        System.out.println("Неверный ввод пункта!");
                }
            }
            catch (Exception e)                  {System.out.println(e.getMessage());}
        }while (point!=0);
    }
    //---------------------------------------------------------------------------------------
    private static void regularPolygonInput(){
        int point =-1;
        do {
            System.out.println("+=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-+");
            System.out.println("|.......Ввод многоугольника........|");
            System.out.println("| [1]- Ввод многоугольника    -[1] |");
            System.out.println("| [0]- Перейти к выбору фигур -[0] |");
            System.out.println("+=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-+");
            point = checkPoint();
            try{
                switch (point) {
                case 1:
                    System.out.println("Введите количество сторон");
                    int amountSides = Integer.parseInt(in.nextLine());
                    System.out.println("Введите длину стороны");
                    double side = Double.parseDouble(in.nextLine());
                    GeometricFigure polygon=new RegularPolygon(amountSides, side);
                    System.out.println(report(polygon));

                    figures.add(polygon);
                    break;
                case 0:
                    System.out.println("Переход в главное меню");
                    break;
                default:
                    System.out.println("Неверный ввод пункта!");
                }
            }
            catch (Exception e)                  {System.out.println(e.getMessage());}
        }while (point!=0);
    }
    //---------------------------------------------------------------------------------------
}