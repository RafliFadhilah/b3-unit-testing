import java.util.Scanner;

/**
 * MainApp.java
 * Program utama untuk "Pengolahan Nilai Mahasiswa".
 *
 * Scanner hanya ada di class ini (sesuai prinsip separation of concerns).
 * Semua logika bisnis didelegasikan ke modul terpisah.
 *
 * Alur program (sesuai PDF poin 3d):
 * 1. User input nama mahasiswa
 * 2. User input nilai tugas, UTS, UAS
 * 3. Nilai DIVALIDASI → jika tidak valid, user diminta input ULANG (loop)
 * 4. Setelah valid: hitung nilai akhir, tentukan grade & kelulusan
 * 5. Tampilkan hasil ke layar
 * 6. Tanya apakah ingin input data mahasiswa lain (loop utama)
 */
public class MainApp {

    // ===== Inisialisasi semua modul =====
    private static ValidationModule validationModule = new ValidationModule();
    private static CalculationModule calculationModule = new CalculationModule(validationModule);
    private static GradeModule gradeModule = new GradeModule();
    private static PassStatusModule passStatusModule = new PassStatusModule();

    /**
     * Method utama program.
     *
     * @param args Argumen command line (tidak digunakan)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean lanjutkan = true;

        printHeader();

        // Loop utama: user bisa input berkali-kali
        while (lanjutkan) {
            System.out.println("\n" + "=".repeat(50));

            // ── STEP 1: Input nama mahasiswa ──
            String nama = inputNama(scanner);

            // ── STEP 2 & 3: Input nilai dengan validasi loop otomatis ──
            // Sesuai PDF poin 3d: "selama menghasilkan tidak valid, user diminta input sampai benar"
            InputModule inputData = inputNilaiDenganValidasi(scanner, nama);

            // ── STEP 4: Proses komputasi dan tampilkan hasil ──
            tampilkanHasil(inputData);

            // ── STEP 5: Tanya apakah ingin lanjut ──
            lanjutkan = tanyaLanjut(scanner);
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("  Terima kasih telah menggunakan sistem ini!");
        System.out.println("=".repeat(50));
        scanner.close();
    }

    /**
     * Menampilkan header program.
     */
    private static void printHeader() {
        System.out.println("=".repeat(50));
        System.out.println("     SISTEM PENGOLAHAN NILAI MAHASISWA");
        System.out.println("=".repeat(50));
    }

    /**
     * Meminta input nama mahasiswa dari user.
     *
     * @param scanner Scanner untuk membaca input
     * @return Nama mahasiswa yang diinput
     */
    private static String inputNama(Scanner scanner) {
        System.out.print("\nMasukkan Nama Mahasiswa: ");
        return scanner.nextLine();
    }

    /**
     * Meminta input nilai dari user.
     * Melakukan retry jika input bukan angka yang valid (NumberFormatException).
     *
     * @param scanner Scanner untuk membaca input
     * @param label   Label jenis nilai (Tugas/UTS/UAS)
     * @return Nilai yang diinput sebagai double
     */
    private static double inputNilai(Scanner scanner, String label) {
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
     * Meminta input nilai mahasiswa dengan loop validasi otomatis.
     * SESUAI PDF POIN 3d: selama nilai tidak valid, user diminta input ulang.
     *
     * @param scanner Scanner untuk membaca input
     * @param nama    Nama mahasiswa
     * @return InputModule yang berisi data valid
     *
     * PATH TESTING NOTES:
     * Path 1: nilai langsung valid pada percobaan pertama → keluar loop
     * Path 2: nilai tidak valid (range/semua nol) → tampilkan pesan + loop ulang
     */
    private static InputModule inputNilaiDenganValidasi(Scanner scanner, String nama) {
        double nilaiTugas, nilaiUTS, nilaiUAS;
        boolean dataValid = false;

        do {
            // Input tiga komponen nilai
            nilaiTugas = inputNilai(scanner, "Nilai Tugas");
            nilaiUTS   = inputNilai(scanner, "Nilai UTS");
            nilaiUAS   = inputNilai(scanner, "Nilai UAS");

            // Panggil ValidationModule untuk cek kevalidan
            dataValid = validationModule.isValid(nilaiTugas, nilaiUTS, nilaiUAS);

            // Jika tidak valid, beri tahu user dan minta input ulang
            if (!dataValid) {
                System.out.println("\n  [!] Data TIDAK VALID! Aturan:");
                System.out.println("      - Semua nilai harus antara 0 dan 100");
                System.out.println("      - Tidak boleh semua nilai bernilai 0");
                System.out.println("  Silakan masukkan kembali nilai mahasiswa.\n");
            }

        } while (!dataValid); // Loop ulang selama data tidak valid

        return new InputModule(nama, nilaiTugas, nilaiUTS, nilaiUAS);
    }

    /**
     * Menampilkan hasil komputasi nilai akhir, grade, dan kelulusan.
     * Method ini hanya dipanggil setelah data dipastikan valid.
     *
     * @param inputData Objek InputModule berisi data mahasiswa yang sudah valid
     */
    private static void tampilkanHasil(InputModule inputData) {
        // Hitung nilai akhir
        double nilaiAkhir = calculationModule.hitungNilaiAkhir(
            inputData.getNilaiTugas(),
            inputData.getNilaiUTS(),
            inputData.getNilaiUAS()
        );

        // Tentukan grade
        String grade = gradeModule.tentukanGrade(nilaiAkhir);
        String deskripsiGrade = gradeModule.getDeskripsiGrade(grade);

        // Tentukan status kelulusan
        String status = passStatusModule.getStatusKelulusan(nilaiAkhir);
        String keterangan = passStatusModule.getKeteranganKelulusan(nilaiAkhir);

        // Tampilkan ringkasan input
        System.out.println("\n--- HASIL PENGOLAHAN NILAI ---");
        System.out.println("Nama        : " + inputData.getNamaMahasiswa());
        System.out.printf("Tugas (30%%) : %.2f%n", inputData.getNilaiTugas());
        System.out.printf("UTS   (30%%) : %.2f%n", inputData.getNilaiUTS());
        System.out.printf("UAS   (40%%) : %.2f%n", inputData.getNilaiUAS());
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
     * @param scanner Scanner untuk membaca input
     * @return true jika user ingin lanjut, false jika ingin keluar
     *
     * PATH TESTING NOTES:
     * Path 1: input "y" → return true
     * Path 2: input selain "y" → return false
     */
    private static boolean tanyaLanjut(Scanner scanner) {
        System.out.print("\nInput data mahasiswa lagi? (y/n): ");
        String jawaban = scanner.nextLine().trim().toLowerCase();

        if (jawaban.equals("y")) {
            return true;
        }
        return false;
    }
}
