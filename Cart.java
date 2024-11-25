import java.util.ArrayList;

public class Cart {
    private ArrayList<DigitalVideoDisc> items = new ArrayList<>();
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        items.add(disc);
        System.out.println("The DVD " + disc.getTitle() + " has been added to the cart.");
    }
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            addDigitalVideoDisc(dvd);
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (items.remove(disc)) {
            System.out.println("The DVD " + disc.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println("The DVD " + disc.getTitle() + " was not found in the cart.");
        }
    }
    public float totalCost() {
        float total = 0;
        for (DigitalVideoDisc disc : items) {
            total += disc.getCost();
        }
        return total;
    }
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