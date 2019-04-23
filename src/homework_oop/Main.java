package homework_oop;

import homework_oop.Triangle;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Triangle triangle1 = new Triangle(5, 17, 35);
//        System.out.println("Площадь треугольника1: "+triangle1.getSquare());
//        System.out.println("Периметр треугольника1: "+triangle1.getPerimeter());
//
//        //Значения 6, 8, 60 попадают в конструктор класса Triangle
//        Triangle triangle2 = new Triangle(6, 8, 60);
//        System.out.println("Площадь треугольника1: "+triangle2.getSquare());
//        System.out.println("Периметр треугольника1: "+triangle2.getPerimeter());

        //ArrayList - Это специальная структура данных в java,
        // позволяющая хранить объекты определенного типа в массиве.
        ArrayList figures = new ArrayList();

        //добавляем три разных объекта в массив figures
        figures.add(new Point());
        figures.add(new LineSegment(133));
        figures.add(new Triangle(10, 17, 55));

        for (int i = 0; i < figures.size(); i++) {
            //для каждого объекта, который находится в массиве
            //выводим его описание, периметр и площадь
            Point figure = (Point) figures.get(i);
            System.out.println(figure.getDescription());
            System.out.println("Периметр фигуры: "+figure.getPerimeter());
            System.out.println("Площадь фигуры: "+figure.getSquare());
        }

    }
}
