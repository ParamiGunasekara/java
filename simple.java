// 1. Abstraction: Create an abstract class Vehicle
abstract class Vehicle {
    private String brand; // Encapsulation: Private field with getter and setter methods
    private String color;

    // Constructor to initialize brand and color
    public Vehicle(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    // Abstract method to be implemented by child classes
    abstract void displayInfo();

    // Encapsulation: Public getter for brand
    public String getBrand() {
        return brand;
    }

    // Encapsulation: Public setter for brand
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Encapsulation: Public getter for color
    public String getColor() {
        return color;
    }

    // Encapsulation: Public setter for color
    public void setColor(String color) {
        this.color = color;
    }
}

// 2. Inheritance: Create a Car class that extends Vehicle
class Car extends Vehicle {
    private int speed; // Additional attribute specific to Car

    // Constructor
    public Car(String brand, String color, int speed) {
        super(brand, color); // Call the parent class constructor
        this.speed = speed;
    }

    // Method to display Car information (Polymorphism through method overriding)
    @Override
    void displayInfo() {
        System.out.println("Car Brand: " + getBrand() + ", Color: " + getColor() + ", Speed: " + speed + " km/h");
    }

    // Polymorphism: Method Overloading - Two methods with the same name but different parameters
    public void accelerate() {
        speed += 10;
        System.out.println("The car accelerates. New speed: " + speed + " km/h");
    }

    public void accelerate(int increment) {
        speed += increment;
        System.out.println("The car accelerates by " + increment + " km/h. New speed: " + speed + " km/h");
    }
}

// 3. Inheritance: Create a Bike class that extends Vehicle
class Bike extends Vehicle {
    private boolean hasCarrier; // Additional attribute specific to Bike

    // Constructor
    public Bike(String brand, String color, boolean hasCarrier) {
        super(brand, color); // Call the parent class constructor
        this.hasCarrier = hasCarrier;
    }

    // Method to display Bike information (Polymorphism through method overriding)
    @Override
    void displayInfo() {
        System.out.println("Bike Brand: " + getBrand() + ", Color: " + getColor() + ", Has Carrier: " + hasCarrier);
    }
}

// Main class named 'Simple' to demonstrate the 4 pillars of OOP
public class Simple {
    public static void main(String[] args) {
        // 4. Polymorphism: Creating objects of different types using the parent class reference
        Vehicle myCar = new Car("Toyota", "Red", 120);
        Vehicle myBike = new Bike("Yamaha", "Blue", true);

        // Display information of the Car and Bike using overridden methods
        myCar.displayInfo(); // Calls Car's displayInfo method
        myBike.displayInfo(); // Calls Bike's displayInfo method

        // Cast to Car to access Car-specific methods
        if (myCar instanceof Car) {
            Car car = (Car) myCar;
            car.accelerate();          // Method Overloading (no parameter)
            car.accelerate(20);        // Method Overloading (with parameter)
        }

        // Accessing encapsulated fields using getters and setters
        myBike.setColor("Black");      // Changing color using encapsulation
        System.out.println("Updated Bike Color: " + myBike.getColor());
    }
}

