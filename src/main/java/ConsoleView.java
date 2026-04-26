import java.util.Scanner;

/**
 * ConsoleView.java
 * Class yang bertanggung jawab untuk semua interaksi I/O dengan user.
 *
 * Prinsip: Tidak ada business logic di class ini.
 * Hanya menangani Scanner (input) dan System.out.println (output).
 */
public class ConsoleView {

    private Scanner scanner;

    /**
     * Konstruktor dengan dependency injection Scanner.
     *
     * @param scanner Scanner untuk membaca input dari user
     */
    public ConsoleView(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Menampilkan header program.
     */
    public void printHeader() {
        System.out.println("=".repeat(50));
        System.out.println("     SISTEM PENGOLAHAN NILAI MAHASISWA");
        System.out.println("=".repeat(50));
    }

    /**
     * Menampilkan footer/pesan penutup program.
     */
    public void printFooter() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("  Terima kasih telah menggunakan sistem ini!");
        System.out.println("=".repeat(50));
    }

    /**
     * Meminta input nama mahasiswa dari user.
     *
     * @return Nama mahasiswa yang diinput
     */
    public String inputNama() {
        System.out.print("\nMasukkan Nama Mahasiswa: ");
        return scanner.nextLine();
    }

    /**
     * Meminta input nilai dari user.
     * Melakukan retry jika input bukan angka yang valid (NumberFormatException).
     *
     * @param label Label jenis nilai (Tugas/UTS/UAS)
     * @return Nilai yang diinput sebagai double
     */
    public double inputNilai(String label) {
        double nilai = 0;
        boolean inputValid = false;

        while (!inputValid) {
            System.out.print("Masukkan " + label + " (0-100): ");
            try {
                nilai = Double.parseDouble(scanner.nextLine());
                inputValid = true;
            } catch (NumberFormatException e) {
                System.out.println("  [ERROR] Input harus berupa angka! Silakan ulangi.");
            }
        }

        return nilai;
    }

    /**
     * Menampilkan pesan bahwa data tidak valid dan aturan yang harus dipenuhi.
     */
    public void tampilkanPesanTidakValid() {
        System.out.println("\n  [!] Data TIDAK VALID! Aturan:");
        System.out.println("      - Semua nilai harus antara 0 dan 100");
        System.out.println("      - Tidak boleh semua nilai bernilai 0");
        System.out.println("  Silakan masukkan kembali nilai mahasiswa.\n");
    }

    /**
     * Menampilkan hasil pengolahan nilai mahasiswa.
     *
     * @param mahasiswa Objek Mahasiswa yang datanya akan ditampilkan
     */
    public void tampilkanHasil(Mahasiswa mahasiswa) {
        double nilaiAkhir = mahasiswa.hitungNilaiAkhir();
        String grade = mahasiswa.tentukanGrade();
        String deskripsiGrade = mahasiswa.getDeskripsiGrade();
        String status = mahasiswa.getStatusKelulusan();
        String keterangan = mahasiswa.getKeteranganKelulusan();

        System.out.println("\n--- HASIL PENGOLAHAN NILAI ---");
        System.out.println("Nama        : " + mahasiswa.getNama());
        System.out.printf("Tugas (30%%) : %.2f%n", mahasiswa.getNilaiTugas());
        System.out.printf("UTS   (30%%) : %.2f%n", mahasiswa.getNilaiUTS());
        System.out.printf("UAS   (40%%) : %.2f%n", mahasiswa.getNilaiUAS());
        System.out.println("-".repeat(30));
        System.out.printf("Nilai Akhir : %.2f%n", nilaiAkhir);
        System.out.println("Grade       : " + grade + " (" + deskripsiGrade + ")");
        System.out.println("Status      : " + status);
        System.out.println();
        System.out.println(keterangan);
    }

    /**
     * Menanyakan apakah user ingin melanjutkan input data mahasiswa lagi.
     *
     * @return true jika user ingin lanjut, false jika ingin keluar
     */
    public boolean tanyaLanjut() {
        System.out.print("\nInput data mahasiswa lagi? (y/n): ");
        String jawaban = scanner.nextLine().trim().toLowerCase();

        if (jawaban.equals("y")) {
            return true;
        }
        return false;
    }

    /**
     * Menampilkan pemisah antar data mahasiswa.
     */
    public void printSeparator() {
        System.out.println("\n" + "=".repeat(50));
    }
}
