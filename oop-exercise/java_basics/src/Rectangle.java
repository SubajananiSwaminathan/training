public class Rectangle extends Shape {
    final double height;
    final double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public String getShape() {
        return "Rectangle";
    }

    public double getArea() {
        return height * width;
    }

    public double getPerimeter() {
        return 2 * (height + width);
    }
}
