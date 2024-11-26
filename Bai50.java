import java.util.ArrayList;

// 1. DigitalVideoDisc
class DigitalVideoDisc {
    private static int idCounter = 1; // Tự động tăng ID
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.id = idCounter++;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.id = idCounter++;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return title + " | Category: " + category + " | Director: " + director +
               " | Length: " + length + " mins | Cost: " + cost + " $";
    }
}

// 2. Cart
class Cart {
    private ArrayList<DigitalVideoDisc> items = new ArrayList<>();

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        items.add(disc);
        System.out.println("The DVD " + disc.getTitle() + " has been added to the cart.");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] discs) {
        for (DigitalVideoDisc disc : discs) {
            addDigitalVideoDisc(disc);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        addDigitalVideoDisc(disc1);
        addDigitalVideoDisc(disc2);
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
            System.out.println("- " + disc);
        }
        System.out.println("Total cost: " + totalCost());
    }

    // Phương thức searchById
    public void searchById(int id) {
        for (DigitalVideoDisc disc : items) {
            if (disc.getId() == id) {
                System.out.println("Found: " + disc);
                return; // Dừng ngay khi tìm thấy
            }
        }
        System.out.println("No match found for ID: " + id);
    }

    public void printCart() {
        System.out.println("*********************** CART ***********************");
        System.out.println("Ordered Items:");
        
        // Sử dụng vòng lặp for-each hoặc for thường để hiển thị danh sách
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, items.get(i));
        }
        
        // Hiển thị tổng chi phí
        System.out.printf("Total cost: %.2f $%n", totalCost());
        
        System.out.println("***************************************************");
    }
    
}

// 3. Aims
class Bai50 {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.println("\n--- Display Cart ---");
        anOrder.printCart(); // Gọi phương thức in giỏ hàng
    }
}

