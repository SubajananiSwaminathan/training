abstract class Shape {
    abstract double getArea();
    abstract double getPerimeter();
    abstract String getShape();

    public static void printDetails(Shape shape) {
        System.out.println("----------");
        System.out.println("\nShape: " + shape.getShape());
        System.out.println("\nProperties:");
        if (shape instanceof Square square) {
            System.out.println("Side = " + square.side);
        } else if (shape instanceof Rectangle rectangle) {
            System.out.println("Height = " + rectangle.height);
            System.out.println("Width = " + rectangle.width);
        } else if (shape instanceof Circle circle) {
            System.out.println("Radius = " + circle.radius);
        }
        System.out.printf("\nArea = %.2f\n", shape.getArea());
        System.out.printf("Perimeter = %.2f\n", shape.getPerimeter());
    }
}
