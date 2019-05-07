import java.util.Scanner;

public class Engine implements Runnable {
    private final Scanner scanner;

    public Engine(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        System.out.print("N = ");

        short n = Short.parseShort(this.scanner.nextLine());

        while (n % 2 == 0) {
            System.out.println("N should be odd!");
            System.out.print("N = ");

            n = Short.parseShort(this.scanner.nextLine());
        }

        try {
            Draw draw = new DrawImpl(n);

            System.out.println(draw.getPrint());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
