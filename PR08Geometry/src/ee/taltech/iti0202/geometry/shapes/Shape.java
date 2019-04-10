package ee.taltech.iti0202.geometry.shapes;

public abstract class Shape {
    // Factory class

    private ShapeType shapeType;
    private Integer angles;
    private Color color;
    private Integer size;

    public enum Color {
        BLUE, GREEN, RED, YELLOW, BLACK
    }


    public static Shape createShape(ShapeType shapeType, Color color, Integer size) {
        switch (shapeType) {
            case CIRCLE: return new Circle(shapeType, color, size);
            case SQUARE: return new Square(shapeType, color, size);
            case TRIANGLE: return new Triangle(shapeType, color, size);
            default: return null;

        }
    }

    public enum ShapeType {
        SQUARE, CIRCLE, TRIANGLE
    }

    protected Shape(ShapeType shapeType, Color color, Integer size) {
        this.shapeType = shapeType;
        this.color = color;
        this.size = size;
    }



    public void changeSize(Integer size) {
        int previousSize = getSize();
        setSize(previousSize + size);
        System.out.println("Shape " + shapeType + " resized from " + previousSize + " to " + getSize() + " points");
    }

    @Override
    public String toString() {
        return super.toString();
    }


    public ShapeType getShapeType() {
        return shapeType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public Integer getAngles() {
        return angles;
    }

    public void setAngles(Integer angles) {
        this.angles = angles;
    }

    public Color getColor() {
        return color;
    }


    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
