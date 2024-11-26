class DigitalVideoDisc {

  private String title;
  private String category;
  private String director;
  private int length;
  private float cost;

  private static int nbDigitalVideoDiscs = 0;
  private int id;

  public DigitalVideoDisc(String title, String category, float cost) {
      this.title = title;
      this.category = category;
      this.cost = cost;
      this.id = ++nbDigitalVideoDiscs;
  }

  public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
      this.title = title;
      this.category = category;
      this.director = director;
      this.length = length;
      this.cost = cost;
      this.id = ++nbDigitalVideoDiscs;
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

  public int getId() {
      return id;
  }

  public boolean isMatch(String title) {
      return this.title.equalsIgnoreCase(title);
  }

  @Override
  public String toString() {
      return "DVD - " + title + " - " + category + " - "
              + (director != null ? director + " - " : "")
              + (length > 0 ? length + " mins: " : "")
              + cost + " $";
  }

}

class Cart {
  public static final int MAX_NUMBERS_ORDERED = 20;
  private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
  private int qtyOrdered = 0;

  public Cart() {

  }

  public DigitalVideoDisc[] getItemsOrdered() {
      return itemsOrdered;
  }

  public void setItemsOrdered(DigitalVideoDisc[] itemsOrdered) {
      this.itemsOrdered = itemsOrdered;
  }

  public int getQtyOrdered() {
      return qtyOrdered;
  }

  public void setQtyOrdered(int qtyOrdered) {
      this.qtyOrdered = qtyOrdered;
  }

  public void addDigitalVideoDisc(DigitalVideoDisc disc) {
      if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
          System.out.println("The cart is almost full");
      } else {
          itemsOrdered[qtyOrdered] = disc;
          qtyOrdered++;
          System.out.println("The disc has been added");
      }
  }
// search 
  public void searchById(int id) {
      for (int i = 0; i < qtyOrdered; i++) {
          if (itemsOrdered[i].getId() == id) {
              System.out.println("Found: " + itemsOrdered[i]);
              return; // Dừng ngay khi tìm thấy
          }
      }
      System.out.println("No match found for ID: " + id);
  }
  
  public void searchByTitle(String title) {
      boolean found = false;
      for (int i = 0; i < qtyOrdered; i++) {
          if (itemsOrdered[i].isMatch(title)) {
              System.out.println("Found: " + itemsOrdered[i]);
              found = true;
          }
      }
      if (!found) {
          System.out.println("No match found for title: " + title);
      }
  }
  

  public void printCart() {
      System.out.println("*********************** CART ***********************");
      System.out.println("Ordered Items:");
  
      // Sử dụng vòng lặp for-each (nếu itemsOrdered là một mảng hoặc danh sách)
      for (int i = 0; i < qtyOrdered; i++) {
          System.out.printf("%d. %s%n", i + 1, itemsOrdered[i]);
      }
  
      // Hiển thị tổng chi phí
      System.out.printf("Total cost: %.2f $%n", totalCost());
  
      System.out.println("***************************************************");
  }
  

  public float totalCost() {
      float total = 0;
      for (int i = 0; i < qtyOrdered; i++) {
          total += itemsOrdered[i].getCost();
      }
      return total;
  }

}

public class Bai5 {
  public static void main(String[] args) {

      Cart anOrder = new Cart();

      DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
              "Animation", "Roger Allers", 87, 19.95f);
      anOrder.addDigitalVideoDisc(dvd1);

      DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
              "Science Fiction", "George Lucas", 87, 24.95f);
      anOrder.addDigitalVideoDisc(dvd2);

      DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
              "Animation", 18.99f);
      anOrder.addDigitalVideoDisc(dvd3);

      // System.out.println("Total Cost is: ");
      // System.out.println(anOrder.totalCost());

      anOrder.printCart();

      anOrder.searchById(2);

      anOrder.searchByTitle("Aladdin");

  }
}
=======
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    private static int nbDigitalVideoDiscs = 0;
    private final int id;

    // Constructors
    public DigitalVideoDisc(String title, String category, float cost) {
        this(title, category, null, 0, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public int getLength() { return length; }
    public void setLength(int length) { this.length = length; }

    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }

    public int getId() { return id; }

    // Utility Methods
    public boolean isMatch(String title) {
        return title != null && this.title.equalsIgnoreCase(title);
    }

    @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - " +
               (director != null ? director + " - " : "") +
               (length > 0 ? length + " mins: " : "") +
               cost + " $";
    }
}

class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // Add a DVD to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full!");
        } else {
            itemsOrdered[qtyOrdered++] = disc;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
        }
    }

    // Print the cart's contents
    public void printCart() {
        System.out.println("***********************CART***********************");
        if (qtyOrdered == 0) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Ordered Items:");
            for (int i = 0; i < qtyOrdered; i++) {
                System.out.println((i + 1) + ". " + itemsOrdered[i]);
            }
            System.out.println("Total cost: " + totalCost() + " $");
        }
        System.out.println("***************************************************");
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}

public class Bai5 {
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Create DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        // Add DVDs to the cart
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        // Display cart details
        cart.displayCart();
    }
}


