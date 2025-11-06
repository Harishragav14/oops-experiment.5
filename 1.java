import java.util.Scanner;

class Cake {
    protected String name;
    protected String flavor;
    protected double price;

    public Cake(String name, String flavor, double price) {
        this.name = name;
        this.flavor = flavor;
        this.price = price;
    }

    public double calculatePrice() {
        return price;   // base price (default)
    }

    public void display() {
        System.out.println("\nCake Name: " + name);
        System.out.println("Flavor: " + flavor);
        System.out.println("Base Price: " + price);
    }
}

class OrderCake extends Cake {
    private double weight;   // in kg

    public OrderCake(String name, String flavor, double price, double weight) {
        super(name, flavor, price);
        this.weight = weight;
    }

    @Override
    public double calculatePrice() {
        return price * weight;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Weight (kg): " + weight);
        System.out.println("Total Price: " + calculatePrice());
    }
}

class ReadyMadeCake extends Cake {
    private int quantity;

    public ReadyMadeCake(String name, String flavor, double price, int quantity) {
        super(name, flavor, price);
        this.quantity = quantity;
    }

    @Override
    public double calculatePrice() {
        return price * quantity;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + calculatePrice());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cake cake;

        while (true) {
            System.out.println("\n------ Cake Menu ------");
            System.out.println("1. Order Cake (Weight-based)");
            System.out.println("2. Ready Made Cake (Quantity-based)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }

            sc.nextLine(); // clear buffer

            System.out.print("Enter Cake Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Flavor: ");
            String flavor = sc.nextLine();

            System.out.print("Enter Base Price: ");
            double price = sc.nextDouble();

            switch (choice) {
                case 1:
                    System.out.print("Enter Weight (kg): ");
                    double weight = sc.nextDouble();
                    cake = new OrderCake(name, flavor, price, weight);
                    cake.display();
                    break;

                case 2:
                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    cake = new ReadyMadeCake(name, flavor, price, quantity);
                    cake.display();
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}

