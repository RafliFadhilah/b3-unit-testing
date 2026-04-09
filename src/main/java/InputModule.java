/**
 * InputModule.java
 * Modul untuk memproses dan mengelola data input nilai mahasiswa.
 *
 * Catatan: Scanner/IO TIDAK ada di class ini.
 * Class ini hanya bertugas untuk menyimpan dan mengelola data input
 * agar bisa diuji secara unit tanpa bergantung pada Scanner.
 */
public class InputModule {

    private double nilaiTugas;
    private double nilaiUTS;
    private double nilaiUAS;
    private String namaMahasiswa;

    /**
     * Konstruktor default.
     */
    public InputModule() {
        this.nilaiTugas = 0;
        this.nilaiUTS = 0;
        this.nilaiUAS = 0;
        this.namaMahasiswa = "";
    }

    /**
     * Konstruktor dengan parameter (memudahkan pengujian).
     *
     * @param namaMahasiswa Nama mahasiswa
     * @param nilaiTugas    Nilai tugas
     * @param nilaiUTS      Nilai UTS
     * @param nilaiUAS      Nilai UAS
     */
    public InputModule(String namaMahasiswa, double nilaiTugas, double nilaiUTS, double nilaiUAS) {
        this.namaMahasiswa = namaMahasiswa;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
    }

    // ------------------- Setter -------------------

    /**
     * Mengatur nama mahasiswa.
     *
     * @param namaMahasiswa Nama mahasiswa
     *
     * PATH TESTING NOTES:
     * Path 1: nama null atau kosong → set sebagai string kosong
     * Path 2: nama valid → set nama
     */
    public void setNamaMahasiswa(String namaMahasiswa) {
        if (namaMahasiswa == null || namaMahasiswa.trim().isEmpty()) {
            this.namaMahasiswa = "";
        } else {
            this.namaMahasiswa = namaMahasiswa.trim();
        }
    }

    /**
     * Mengatur nilai tugas.
     *
     * @param nilaiTugas Nilai tugas mahasiswa
     */
    public void setNilaiTugas(double nilaiTugas) {
        this.nilaiTugas = nilaiTugas;
    }

    /**
     * Mengatur nilai UTS.
     *
     * @param nilaiUTS Nilai UTS mahasiswa
     */
    public void setNilaiUTS(double nilaiUTS) {
        this.nilaiUTS = nilaiUTS;
    }

    /**
     * Mengatur nilai UAS.
     *
     * @param nilaiUAS Nilai UAS mahasiswa
     */
    public void setNilaiUAS(double nilaiUAS) {
        this.nilaiUAS = nilaiUAS;
    }

    // ------------------- Getter -------------------

    /**
     * Mendapatkan nama mahasiswa.
     *
     * @return Nama mahasiswa
     */
    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    /**
     * Mendapatkan nilai tugas.
     *
     * @return Nilai tugas
     */
    public double getNilaiTugas() {
        return nilaiTugas;
    }

    /**
     * Mendapatkan nilai UTS.
     *
     * @return Nilai UTS
     */
    public double getNilaiUTS() {
        return nilaiUTS;
    }

    /**
     * Mendapatkan nilai UAS.
     *
     * @return Nilai UAS
     */
    public double getNilaiUAS() {
        return nilaiUAS;
    }

    /**
     * Memeriksa apakah nama mahasiswa sudah diset dengan benar.
     *
     * @return true jika nama tidak kosong, false jika kosong
     *
     * PATH TESTING NOTES:
     * Path 1: nama kosong → return false
     * Path 2: nama tidak kosong → return true
     */
    public boolean isNamaValid() {
        if (namaMahasiswa == null || namaMahasiswa.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Menampilkan ringkasan data input.
     *
     * @return String ringkasan data mahasiswa
     */
    @Override
    public String toString() {
        return String.format(
            "Mahasiswa: %s | Tugas: %.2f | UTS: %.2f | UAS: %.2f",
            namaMahasiswa, nilaiTugas, nilaiUTS, nilaiUAS
        );
    }
}
