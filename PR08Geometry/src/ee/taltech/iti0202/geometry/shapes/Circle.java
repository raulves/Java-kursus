package ee.taltech.iti0202.geometry.shapes;


public class Circle extends Shape {

    public Circle(ShapeType shapeType, Integer angles, Color color, Integer size) {
        super(shapeType, angles, color, size);
    }

    @Override
    public void draw() {
        String draw = "Shape: " + super.getShapeType() + ", Color: " + super.getColor() + ", Radius: " + super.getSize();
        System.out.println(draw);
    }

    @Override
    public void changeSize(Integer size) {
        int previousSize = super.getSize();
        super.setSize(previousSize + size);
        System.out.println("Shape " + super.getShapeType() + " resized from " + previousSize + " to " + super.getSize() + " points");
    }
}
