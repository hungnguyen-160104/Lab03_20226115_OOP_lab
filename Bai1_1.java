class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }
}

class Cart {
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    private static final int MAX_NUMBERS_ORDERED = 10; // Maximum limit for ordered items

    // Adding a single DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full.");
        } else {
            itemsOrdered[qtyOrdered++] = disc;
            System.out.println("The DVD " + disc.getTitle() + " has been added to the cart.");
        }
    }

    // Adding multiple DVDs using varargs
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc dvd : dvds) {
            if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full.");
                break;
            }
            itemsOrdered[qtyOrdered++] = dvd;
            System.out.println("The DVD " + dvd.getTitle() + " has been added to the cart.");
        }
    }

    // Removing a DVD
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                found = true;
                // Shift all subsequent items to the left
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[--qtyOrdered] = null; // Reduce qtyOrdered and clear the last element
                System.out.println("The DVD " + disc.getTitle() + " has been removed from the cart.");
                break;
            }
        }
        if (!found) {
            System.out.println("The DVD " + disc.getTitle() + " was not found in the cart.");
        }
    }

    // Calculating total cost
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    // Displaying cart contents
    public void displayCart() {
        System.out.println("Items in the cart:");
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            System.out.println("- " + disc.getTitle() + " | Category: " + disc.getCategory() +
                    " | Director: " + disc.getDirector() +
                    " | Length: " + disc.getLength() +
                    " | Cost: " + disc.getCost());
        }
        System.out.println("Total cost: " + totalCost());
    }
}

public class Bai1_1 {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // Adding multiple DVDs
        anOrder.addDigitalVideoDisc(
            new DigitalVideoDisc("Frozen", "Animation", "Chris Buck", 102, 22.95f),
            new DigitalVideoDisc("The Matrix", "Science Fiction", "The Wachowskis", 136, 29.95f)
        );

        // Displaying total cost
        System.out.println("Total Cost is: " + anOrder.totalCost());
        // Displaying cart contents
        anOrder.displayCart();
    }
}
