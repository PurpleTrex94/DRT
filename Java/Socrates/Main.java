package Socrates;


class Animal {
    protected String color;
    protected int legNumber;

    // Constructor with validations
    public Animal(String color, int legNumber) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color cannot be null or empty.");
        }
        if (legNumber <= 0 || legNumber > 100) { // Arbitrary maximum limit for sanity
            throw new IllegalArgumentException("Leg number must be between 1 and 100.");
        }
        this.color = color;
        this.legNumber = legNumber;
    }
}

// Cat class extending Animal
class Cat extends Animal {
    public Cat(String color) {
        super(color, 4); 
    }

    public String move() {
        return "I'm moving with " + legNumber + " legs!";
    }
}

// Bug class extending Animal
class Bug extends Animal {
    public Bug(String color, int legNumber) {
        super(color, legNumber);
        if (legNumber < 6 || legNumber % 2 != 0) { 
            throw new IllegalArgumentException("Bugs must have at least 6 legs and an even number of legs.");
        }
    }

    public String move() {
        return "I'm moving with " + legNumber + " legs!";
    }
}

// Bird class extending Animal
class Bird extends Animal {
    private boolean canFly;

    public Bird(String color, boolean canFly) {
        super(color, 2); 
        this.canFly = canFly;
    }

    public String move() {
        return canFly ? "I'm flying!" : "I'm moving with " + legNumber + " legs!";
    }
}

// Main class to test functionality
public class Main {
    public static void main(String[] args) {
        try {
            // Valid examples
            Cat cat = new Cat("Black");
            Bug bug = new Bug("Green", 6);
            Bird birdFlying = new Bird("Blue", true);
            Bird birdWalking = new Bird("Brown", false);

            System.out.println(cat.move());
            System.out.println(bug.move());
            System.out.println(birdFlying.move());
            System.out.println(birdWalking.move());

            
            // Cat invalidCat = new Cat(""); // Invalid color
            // Bug invalidBug = new Bug("Red", 5); // Invalid leg number
            // Bird invalidBird = new Bird(null, true); // Null color
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
