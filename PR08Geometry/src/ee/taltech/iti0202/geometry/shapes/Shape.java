package ee.taltech.iti0202.geometry.shapes;

public class Shape {

    private ShapeType shapeType;
    private Integer angles;
    private Color color;
    private Integer size;

    public enum Color {
        BLUE, GREEN, RED, YELLOW, BLACK
    }

    public enum ShapeType {
        SQUARE, CIRCLE, TRIANGLE
    }

    public Shape(ShapeType shapeType, Integer angles, Color color, Integer size) {
        this.shapeType = shapeType;
        this.angles = angles;
        this.color = color;
        this.size = size;
    }

    public void draw() {
        String draw = "Shape: " + shapeType + ", Number of angles: " + angles + ", Color: " + color + ", Size: " + size;
        System.out.println(draw);
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
