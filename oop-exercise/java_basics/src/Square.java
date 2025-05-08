public class Square extends Shape {
    final double side;

    public Square(double side) {
        this.side = side;
    }

    public String getShape() {
        return "Square";
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return 4 * side;
    }
}
