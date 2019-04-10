package ee.taltech.iti0202.geometry;

import ee.taltech.iti0202.geometry.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class Canvas {

    List<Shape> shapes = new ArrayList<>();

    public void drawShape(Shape shape) {
        shapes.add(shape);
        String draw = "Shape: " + shape.getShapeType() + ", Color: " + shape.getColor() + ", Size: " + shape.getSize();
        System.out.println(draw);
    }
}
