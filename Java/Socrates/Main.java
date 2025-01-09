package Socrates;


class Animal {
    protected String color;
    protected int legNumber;

    public Animal(String color, int legNumber) {
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
        if (canFly) {
            return "I'm flying";
        } else {
            return "I'm moving with " + legNumber + " legs!";
        }
    }
}

// Main class to test functionality
public class Main {
    public static void main(String[] args) {
        // Create instances of each class
        Cat cat = new Cat("Black");
        Bug bug = new Bug("Green", 6);
        Bird birdFlying = new Bird("Blue", true);
        Bird birdWalking = new Bird("Brown", false);

        // Test the move method
        System.out.println(cat.move());
        System.out.println(bug.move()); 
        System.out.println(birdFlying.move()); 
        System.out.println(birdWalking.move()); 
    }
}

