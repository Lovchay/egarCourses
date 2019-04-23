package homework_oop;

public class Triangle extends Point {

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getAngleAB() {
        return angleAB;
    }

    public void setAngleAB(double angleAB) {
        this.angleAB = angleAB;
    }

    /**
     * Специальный метод, называемый конструктор класса.
     * Принимает на вход три параметра:
     * длина стороны А, длина стороны Б,
     * угол между этими сторонами(в градусах)
     */
    public Triangle(double sideA, double sideB, double angleAB) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.angleAB = angleAB;
    }

    private double sideA; //Поле класса, хранит значение стороны А в описываемом треугольнике
    private double sideB; //Поле класса, хранит значение стороны Б в описываемом треугольнике
    private double angleAB; //Поле класса, хранит угла(в градусах) между двумя сторонами в описываемом треугольнике

    /**
     * Метод класса, который рассчитывает площадь треугольника
     */
    public double getSquare() {
        double square = this.sideA * this.sideB * Math.sin(this.angleAB * Math.PI / 180);
        return square;
    }

    /**
     * Метод класса, который рассчитывает периметр треугольника
     */
    public double getPerimeter() {
        double sideC = Math.sqrt(Math.pow(this.sideA, 2) + Math.pow(this.sideB, 2) - 2 * this.sideA * this.sideB * Math.cos(this.angleAB * Math.PI / 180));
        double perimeter = this.sideA + this.sideB + sideC;
        return perimeter;
    }


    String getDescription() {
        return "Треугольник со сторонами: " + this.sideA + ", " + this.sideB + " и углом между ними: " + this.angleAB;
    }

}
