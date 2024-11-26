import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
//
public class Bai8 {
    public static void main(String[] args) {
        try {
            Random r = new Random(123);

            // Đo thời gian với việc nối chuỗi bằng toán tử '+'
            long start = System.currentTimeMillis();
            String s = "";
            for (int i = 0; i < 65536; i++) {
                s += r.nextInt(2); // Nối trực tiếp
            }
            long duration = System.currentTimeMillis() - start;
            System.out.println("Using '+' operator: " + duration + " ms");

            // Đo thời gian với StringBuilder
            r = new Random(123); // Reset lại Random
            start = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 65536; i++) {
                sb.append(r.nextInt(2)); // Nối bằng StringBuilder
            }
            s = sb.toString();
            duration = System.currentTimeMillis() - start;
            System.out.println("Using StringBuilder: " + duration + " ms");

            // Đọc tệp nhị phân và chuyển đổi thành chuỗi
            String filename = "test.exe";
            byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

            long startTime = System.currentTimeMillis();
            StringBuilder outputBuilder = new StringBuilder(inputBytes.length);
            for (byte b : inputBytes) {
                outputBuilder.append((char) b); // Chuyển đổi byte thành ký tự
            }
            String outputString = outputBuilder.toString();
            long endTime = System.currentTimeMillis();

            System.out.println("Reading and converting file: " + (endTime - startTime) + " ms");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
