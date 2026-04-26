import java.util.Scanner;

/**
 * MainApp.java
 * Entry point program "Pengolahan Nilai Mahasiswa".
 *
 * Method main hanya bertugas:
 * 1. Membuat instance Scanner
 * 2. Membuat instance ConsoleView (I/O)
 * 3. Membuat instance AppController (alur program)
 * 4. Menjalankan controller
 */
public class MainApp {

    /**
     * Method utama program.
     *
     * @param args Argumen command line (tidak digunakan)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleView view = new ConsoleView(scanner);
        AppController controller = new AppController(view);
        controller.start();
        scanner.close();
    }
}
