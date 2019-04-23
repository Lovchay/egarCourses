package homework_oop;

public class LineSegment extends Point {

    LineSegment(double segmentLength) {
        this.segmentLength = segmentLength;
    }

    double segmentLength; // Длина отрезка

    /**
     * Переопределенный метод класса, который рассчитывает площадь отрезка
     */
    double getSquare() {
        return 0;
    }

    /**
     * Переопределенный метод класса, который рассчитывает периметр отрезка
     */
    double getPerimeter() {
        return this.segmentLength;
    }

    String getDescription() {
        return "Отрезок длиной: " + this.segmentLength;
    }

}
