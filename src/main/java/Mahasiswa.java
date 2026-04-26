/**
 * Mahasiswa.java
 * Domain entity class untuk merepresentasikan data dan behavior mahasiswa.
 *
 * Class ini menggabungkan state (nama, nilai) dan behavior (validasi,
 * perhitungan nilai akhir, penentuan grade, dan status kelulusan)
 * sesuai prinsip OOP — enkapsulasi, cohesion, dan domain-driven design.
 *
 * Rumus Nilai Akhir:
 *   nilai_akhir = (0.3 * tugas) + (0.3 * UTS) + (0.4 * UAS)
 *
 * Kriteria Grade:
 *   >= 85       → A (Sangat Memuaskan)
 *   70 - 84     → B (Memuaskan)
 *   60 - 69     → C (Cukup)
 *   50 - 59     → D (Kurang)
 *   < 50        → E (Sangat Kurang)
 *
 * Kriteria Kelulusan:
 *   nilai_akhir >= 60 → Lulus
 *   nilai_akhir < 60  → Tidak Lulus
 */
public class Mahasiswa {

    // ===== Private Fields (Enkapsulasi) =====
    private String nama;
    private double nilaiTugas;
    private double nilaiUTS;
    private double nilaiUAS;

    // ===== Konstanta =====
    public static final double BATAS_LULUS = 60.0;

    // ===== Konstruktor =====

    /**
     * Konstruktor default.
     * Semua field diinisialisasi dengan nilai kosong/nol.
     */
    public Mahasiswa() {
        this.nama = "";
        this.nilaiTugas = 0;
        this.nilaiUTS = 0;
        this.nilaiUAS = 0;
    }

    /**
     * Konstruktor dengan parameter lengkap.
     *
     * @param nama       Nama mahasiswa
     * @param nilaiTugas Nilai tugas mahasiswa
     * @param nilaiUTS   Nilai UTS mahasiswa
     * @param nilaiUAS   Nilai UAS mahasiswa
     */
    public Mahasiswa(String nama, double nilaiTugas, double nilaiUTS, double nilaiUAS) {
        this.nama = nama;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
    }

    // ===== Getter =====

    /**
     * Mendapatkan nama mahasiswa.
     *
     * @return Nama mahasiswa
     */
    public String getNama() {
        return nama;
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

    // ===== Setter =====

    /**
     * Mengatur nama mahasiswa.
     * Jika nama null atau hanya spasi, disimpan sebagai string kosong.
     *
     * @param nama Nama mahasiswa
     *
     * PATH TESTING NOTES:
     * Path 1: nama null atau kosong → set sebagai string kosong
     * Path 2: nama valid → set nama (di-trim)
     */
    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            this.nama = "";
        } else {
            this.nama = nama.trim();
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

    // ===== Behavior: Validasi =====

    /**
     * Memvalidasi apakah nilai tugas, UTS, dan UAS memenuhi syarat.
     * Semua nilai harus dalam range 0-100 dan tidak boleh semuanya 0.
     *
     * @return true jika semua nilai valid, false jika tidak valid
     *
     * PATH TESTING NOTES:
     * Path 1: nilaiTugas < 0 → return false
     * Path 2: nilaiTugas > 100 → return false
     * Path 3: nilaiUTS < 0 → return false
     * Path 4: nilaiUTS > 100 → return false
     * Path 5: nilaiUAS < 0 → return false
     * Path 6: nilaiUAS > 100 → return false
     * Path 7: semua nilai = 0 → return false
     * Path 8: semua nilai valid dan bukan semua nol → return true
     */
    public boolean isValid() {
        // Cek apakah nilai tugas berada dalam rentang valid
        if (nilaiTugas < 0 || nilaiTugas > 100) {
            return false;
        }

        // Cek apakah nilai UTS berada dalam rentang valid
        if (nilaiUTS < 0 || nilaiUTS > 100) {
            return false;
        }

        // Cek apakah nilai UAS berada dalam rentang valid
        if (nilaiUAS < 0 || nilaiUAS > 100) {
            return false;
        }

        // Cek apakah semua nilai adalah 0 (tidak valid)
        if (nilaiTugas == 0 && nilaiUTS == 0 && nilaiUAS == 0) {
            return false;
        }

        // Semua kondisi lolos → nilai valid
        return true;
    }

    /**
     * Memvalidasi apakah sebuah nilai tunggal berada dalam range 0-100.
     * Method static karena tidak bergantung pada state instance.
     *
     * @param nilai Nilai yang akan dicek
     * @return true jika nilai dalam range [0, 100], false jika tidak
     *
     * PATH TESTING NOTES:
     * Path 1: nilai < 0 → return false
     * Path 2: nilai > 100 → return false
     * Path 3: 0 <= nilai <= 100 → return true
     */
    public static boolean isInRange(double nilai) {
        if (nilai < 0) {
            return false;
        }
        if (nilai > 100) {
            return false;
        }
        return true;
    }

    // ===== Behavior: Perhitungan Nilai Akhir =====

    /**
     * Menghitung nilai akhir berdasarkan bobot masing-masing komponen.
     * Rumus: nilai_akhir = (0.3 * tugas) + (0.3 * UTS) + (0.4 * UAS)
     *
     * @return Nilai akhir jika valid, -1 jika tidak valid
     *
     * PATH TESTING NOTES:
     * Path 1: Input tidak valid (isValid() return false) → return -1
     * Path 2: Input valid, nilai akhir > 100 → return -1
     * Path 3: Input valid, nilai akhir <= 100 → return nilai_akhir
     */
    public double hitungNilaiAkhir() {
        // Validasi input terlebih dahulu
        if (!isValid()) {
            return -1;
        }

        // Hitung nilai akhir menggunakan bobot yang ditentukan
        double nilaiAkhir = (0.3 * nilaiTugas) + (0.3 * nilaiUTS) + (0.4 * nilaiUAS);

        // Cek apakah hasil perhitungan melebihi 100
        if (nilaiAkhir > 100) {
            return -1;
        }

        return nilaiAkhir;
    }

    // ===== Behavior: Grade =====

    /**
     * Menentukan grade huruf berdasarkan nilai akhir.
     *
     * @return Grade dalam bentuk String ("A", "B", "C", "D", "E", atau "INVALID")
     *
     * PATH TESTING NOTES:
     * Path 1: nilaiAkhir < 0 → return "INVALID"
     * Path 2: nilaiAkhir >= 85 → return "A"
     * Path 3: nilaiAkhir >= 70 (dan < 85) → return "B"
     * Path 4: nilaiAkhir >= 60 (dan < 70) → return "C"
     * Path 5: nilaiAkhir >= 50 (dan < 60) → return "D"
     * Path 6: nilaiAkhir < 50 (dan >= 0) → return "E"
     */
    public String tentukanGrade() {
        double nilaiAkhir = hitungNilaiAkhir();

        // Cek nilai tidak valid
        if (nilaiAkhir < 0) {
            return "INVALID";
        }

        // Tentukan grade berdasarkan nilai akhir
        if (nilaiAkhir >= 85) {
            return "A";
        } else if (nilaiAkhir >= 70) {
            return "B";
        } else if (nilaiAkhir >= 60) {
            return "C";
        } else if (nilaiAkhir >= 50) {
            return "D";
        } else {
            return "E";
        }
    }

    /**
     * Mendapatkan deskripsi lengkap grade.
     *
     * @return Deskripsi grade, atau "Grade tidak diketahui" jika tidak valid
     *
     * PATH TESTING NOTES:
     * Path 1: grade = "A" → return "Sangat Memuaskan"
     * Path 2: grade = "B" → return "Memuaskan"
     * Path 3: grade = "C" → return "Cukup"
     * Path 4: grade = "D" → return "Kurang"
     * Path 5: grade = "E" → return "Sangat Kurang"
     * Path 6: grade lainnya → return "Grade tidak diketahui"
     */
    public String getDeskripsiGrade() {
        String grade = tentukanGrade();
        switch (grade) {
            case "A":
                return "Sangat Memuaskan";
            case "B":
                return "Memuaskan";
            case "C":
                return "Cukup";
            case "D":
                return "Kurang";
            case "E":
                return "Sangat Kurang";
            default:
                return "Grade tidak diketahui";
        }
    }

    // ===== Behavior: Status Kelulusan =====

    /**
     * Menentukan apakah mahasiswa lulus atau tidak berdasarkan nilai akhir.
     *
     * @return true jika lulus (>= 60), false jika tidak lulus (< 60)
     *
     * PATH TESTING NOTES:
     * Path 1: nilaiAkhir < 0 (nilai invalid) → return false
     * Path 2: nilaiAkhir >= 60 → return true (Lulus)
     * Path 3: 0 <= nilaiAkhir < 60 → return false (Tidak Lulus)
     */
    public boolean isLulus() {
        double nilaiAkhir = hitungNilaiAkhir();

        if (nilaiAkhir < 0) {
            return false;
        }

        if (nilaiAkhir >= BATAS_LULUS) {
            return true;
        }

        return false;
    }

    /**
     * Mendapatkan status kelulusan dalam bentuk String.
     *
     * @return "Lulus" jika nilai >= 60, "Tidak Lulus" jika tidak
     *
     * PATH TESTING NOTES:
     * Path 1: nilaiAkhir < 0 → return "Tidak Lulus (Nilai Tidak Valid)"
     * Path 2: nilaiAkhir >= 60 → return "Lulus"
     * Path 3: 0 <= nilaiAkhir < 60 → return "Tidak Lulus"
     */
    public String getStatusKelulusan() {
        double nilaiAkhir = hitungNilaiAkhir();

        if (nilaiAkhir < 0) {
            return "Tidak Lulus (Nilai Tidak Valid)";
        }

        if (nilaiAkhir >= BATAS_LULUS) {
            return "Lulus";
        } else {
            return "Tidak Lulus";
        }
    }

    /**
     * Mendapatkan keterangan detail tentang status kelulusan.
     *
     * @return Pesan detail status kelulusan
     *
     * PATH TESTING NOTES:
     * Path 1: nilai tidak valid → return pesan error
     * Path 2: nilai >= 60 → return pesan lulus dengan nilai
     * Path 3: nilai < 60 → return pesan tidak lulus dengan selisih yang dibutuhkan
     */
    public String getKeteranganKelulusan() {
        double nilaiAkhir = hitungNilaiAkhir();

        if (nilaiAkhir < 0) {
            return "Data nilai tidak valid, tidak dapat menentukan kelulusan.";
        }

        if (nilaiAkhir >= BATAS_LULUS) {
            return String.format("Selamat! Anda LULUS dengan nilai %.2f", nilaiAkhir);
        } else {
            double selisih = BATAS_LULUS - nilaiAkhir;
            return String.format("Maaf, Anda TIDAK LULUS. Kekurangan %.2f poin untuk lulus.", selisih);
        }
    }

    // ===== Utility =====

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
        if (nama == null || nama.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Menampilkan ringkasan data mahasiswa.
     *
     * @return String ringkasan data mahasiswa
     */
    @Override
    public String toString() {
        return String.format(
            "Mahasiswa: %s | Tugas: %.2f | UTS: %.2f | UAS: %.2f",
            nama, nilaiTugas, nilaiUTS, nilaiUAS
        );
    }
}
