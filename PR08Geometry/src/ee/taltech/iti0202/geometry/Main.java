package ee.taltech.iti0202.geometry;

import ee.taltech.iti0202.geometry.shapes.Circle;
import ee.taltech.iti0202.geometry.shapes.Shape;
import ee.taltech.iti0202.geometry.shapes.Square;


public class Main {

    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        Shape shape = Shape.createShape(Shape.ShapeType.CIRCLE, Shape.Color.BLUE, 10);
        canvas.drawShape(shape);
        System.out.println(canvas.shapes);
    }

}
