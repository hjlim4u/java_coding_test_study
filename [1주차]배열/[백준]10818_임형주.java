import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int min = 1000000;
        int max = -1000000;
        scanner.nextLine();
        String numbers = scanner.nextLine();
        Scanner numScanner = new Scanner(numbers).useDelimiter(" +");
        while (numScanner.hasNextInt()) {
            int num = numScanner.nextInt();
            min = min <= num ? min : num;
            max = max >= num ? max : num;
        }
        System.out.println(min+" "+max);
    }
}