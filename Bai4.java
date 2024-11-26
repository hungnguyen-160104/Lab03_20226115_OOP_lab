class DigitalVideoDisc {
  private String title;
  private String category;
  private String director;
  private int length;
  private float cost;

  // Thuộc tính lớp
  private static int nbDigitalVideoDiscs = 0;

  // Thuộc tính đối tượng
  private final int id;

  // Constructor
  public DigitalVideoDisc(String title, String category, float cost) {
      this(title, category, null, 0, cost); // Gọi constructor đầy đủ với giá trị mặc định
  }

  public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
      this.title = title;
      this.category = category;
      this.director = director;
      this.length = length;
      this.cost = cost;
      this.id = ++nbDigitalVideoDiscs; // Tự động tăng và gán ID
  }

  // Getters
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

  public int getId() {
      return id;
  }

  // Getter thuộc tính lớp
  public static int getNbDigitalVideoDiscs() {
      return nbDigitalVideoDiscs;
  }
}

class Cart {
  private static final int MAX_NUMBERS_ORDERED = 20;
  private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
  private int qtyOrdered = 0;

  // Thêm DVD vào giỏ hàng
  public void addDigitalVideoDisc(DigitalVideoDisc disc) {
      if (qtyOrdered < MAX_NUMBERS_ORDERED) {
          itemsOrdered[qtyOrdered++] = disc;
          System.out.println("Added DVD: " + disc.getTitle());
      } else {
          System.out.println("The cart is full. Cannot add more DVDs.");
      }
  }

  // Lấy danh sách DVD trong giỏ hàng
  public DigitalVideoDisc[] getItemsOrdered() {
      return itemsOrdered;
  }

  // Lấy số lượng DVD hiện tại
  public int getQtyOrdered() {
      return qtyOrdered;
  }
}

public class Bai4 {
  public static void main(String[] args) {
      Cart cart = new Cart();

      DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
      DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
      DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

      // Hiển thị thông tin DVD
      System.out.println("DVD 1 ID: " + dvd1.getId());
      System.out.println("DVD 2 ID: " + dvd2.getId());
      System.out.println("DVD 3 ID: " + dvd3.getId());

      // Tổng số DVD đã tạo
      System.out.println("Total DVDs created: " + DigitalVideoDisc.getNbDigitalVideoDiscs());

      // Thêm DVD vào giỏ hàng
      cart.addDigitalVideoDisc(dvd1);
      cart.addDigitalVideoDisc(dvd2);
      cart.addDigitalVideoDisc(dvd3);

      // Kiểm tra số lượng DVD trong giỏ hàng
      System.out.println("Number of DVDs in the cart: " + cart.getQtyOrdered());
  }
}
