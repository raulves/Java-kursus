package ee.taltech.iti0202.geometry.shapes;


public class Circle extends Shape {

    public Circle(ShapeType shapeType, Color color, Integer size) {
        super(shapeType, color, size);
    }

    @Override
    public void changeSize(Integer size) {
        int previousSize = super.getSize();
        super.setSize(previousSize + size);
        System.out.println("Shape " + super.getShapeType() + " resized from " + previousSize + " to "
                + super.getSize() + " points");
    }
}
