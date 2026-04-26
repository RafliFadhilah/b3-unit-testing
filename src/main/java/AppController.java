/**
 * AppController.java
 * Controller yang mengatur alur program.
 *
 * Menghubungkan ConsoleView (I/O) dengan Mahasiswa (domain model).
 * Tidak melakukan I/O langsung dan tidak mengandung business logic.
 *
 * Alur program:
 * 1. User input nama mahasiswa
 * 2. User input nilai tugas, UTS, UAS
 * 3. Nilai DIVALIDASI → jika tidak valid, user diminta input ULANG (loop)
 * 4. Setelah valid: hitung nilai akhir, tentukan grade & kelulusan
 * 5. Tampilkan hasil ke layar
 * 6. Tanya apakah ingin input data mahasiswa lain (loop utama)
 */
public class AppController {

    private ConsoleView view;

    /**
     * Konstruktor dengan dependency injection ConsoleView.
     *
     * @param view ConsoleView untuk interaksi I/O
     */
    public AppController(ConsoleView view) {
        this.view = view;
    }

    /**
     * Menjalankan alur utama program.
     * Loop utama: input → validasi → hitung → tampilkan → tanya lanjut.
     */
    public void start() {
        boolean lanjutkan = true;

        view.printHeader();

        while (lanjutkan) {
            view.printSeparator();

            // STEP 1: Input nama mahasiswa
            String nama = view.inputNama();

            // STEP 2 & 3: Input nilai dengan validasi loop otomatis
            Mahasiswa mahasiswa = inputNilaiDenganValidasi(nama);

            // STEP 4: Tampilkan hasil
            view.tampilkanHasil(mahasiswa);

            // STEP 5: Tanya apakah ingin lanjut
            lanjutkan = view.tanyaLanjut();
        }

        view.printFooter();
    }

    /**
     * Meminta input nilai mahasiswa dengan loop validasi otomatis.
     * Selama nilai tidak valid, user diminta input ulang.
     *
     * @param nama Nama mahasiswa
     * @return Mahasiswa yang berisi data valid
     */
    private Mahasiswa inputNilaiDenganValidasi(String nama) {
        Mahasiswa mahasiswa;
        boolean dataValid;

        do {
            double nilaiTugas = view.inputNilai("Nilai Tugas");
            double nilaiUTS   = view.inputNilai("Nilai UTS");
            double nilaiUAS   = view.inputNilai("Nilai UAS");

            mahasiswa = new Mahasiswa(nama, nilaiTugas, nilaiUTS, nilaiUAS);
            dataValid = mahasiswa.isValid();

            if (!dataValid) {
                view.tampilkanPesanTidakValid();
            }

        } while (!dataValid);

        return mahasiswa;
    }
}
