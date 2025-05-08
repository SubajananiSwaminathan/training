import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shape shape = null;

        System.out.println("Select a shape by entering its number: ");
        System.out.println("1. Square");
        System.out.println("2. Rectangle");
        System.out.println("3. Circle");
        int choice = scanner.nextInt();

        System.out.println("\nProperties");
        switch (choice) {
            case 1:
                System.out.print("Side length: ");
                double side = scanner.nextDouble();
                shape = new Square(side);
                break;
            case 2:
                System.out.print("Height: ");
                double height = scanner.nextDouble();
                System.out.print("Width: ");
                double width = scanner.nextDouble();
                shape = new Rectangle(height, width);
                break;
            case 3:
                System.out.print("Radius: ");
                double radius = scanner.nextDouble();
                shape = new Circle(radius);
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(0);
        }

        Shape.printDetails(shape);

        scanner.close();
    }

}
