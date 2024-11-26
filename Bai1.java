import java.util.ArrayList;

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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}

class Cart {
    private ArrayList<DigitalVideoDisc> items = new ArrayList<>();
    private int qtyOrdered = 0;
    private final int MAX_NUMBERS_ORDERED = 10; // Maximum limit for ordered items

    // Adding a single DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full");
        } else {
            items.add(disc);
            qtyOrdered++;
            System.out.println("The DVD " + disc.getTitle() + " has been added to the cart.");
        }
    }

    // Adding an array of DVDs
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (int i = 0; i < dvdList.length; i++) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                items.add(dvdList[i]);
                qtyOrdered++;
                System.out.println("The disc " + dvdList[i].getTitle() + " has been added.");
            } else {
                System.out.println("The cart is full");
                break;
            }
        }
    }

    // Adding two DVDs
    public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        addDigitalVideoDisc(disc1);
        addDigitalVideoDisc(disc2);
    }

    // Removing a DVD
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (items.remove(disc)) {
            System.out.println("The DVD " + disc.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println("The DVD " + disc.getTitle() + " was not found in the cart.");
        }
    }

    // Calculating total cost
    public float totalCost() {
        float total = 0;
        for (DigitalVideoDisc disc : items) {
            total += disc.getCost();
        }
        return total;
    }

    // Displaying cart contents
    public void displayCart() {
        System.out.println("Items in the cart:");
        for (DigitalVideoDisc disc : items) {
            System.out.println("- " + disc.getTitle() + " | Category: " + disc.getCategory() +
                    " | Director: " + disc.getDirector() +
                    " | Length: " + disc.getLength() +
                    " | Cost: " + disc.getCost());
        }
        System.out.println("Total cost: " + totalCost());
    }
}

public class Bai1 {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // Adding an array of DVDs
        DigitalVideoDisc[] newDvds = {
            new DigitalVideoDisc("Frozen", "Animation", "Chris Buck", 102, 22.95f),
            new DigitalVideoDisc("The Matrix", "Science Fiction", "The Wachowskis", 136, 29.95f)
        };
        anOrder.addDigitalVideoDisc(newDvds);

        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
    }
}
