/**
 * PassStatusModule.java
 * Modul untuk menentukan status kelulusan mahasiswa.
 *
 * Kriteria:
 * nilai_akhir >= 60 → Lulus
 * nilai_akhir < 60  → Tidak Lulus
 *
 * Digunakan untuk path testing pada kondisi kelulusan.
 */
public class PassStatusModule {

    // Batas nilai minimum untuk lulus
    public static final double BATAS_LULUS = 60.0;

    /**
     * Menentukan apakah mahasiswa lulus atau tidak berdasarkan nilai akhir.
     *
     * @param nilaiAkhir Nilai akhir mahasiswa
     * @return true jika lulus (>= 60), false jika tidak lulus (< 60)
     *
     * PATH TESTING NOTES:
     * Path 1: nilaiAkhir < 0 (nilai invalid) → return false
     * Path 2: nilaiAkhir >= 60 → return true (Lulus)
     * Path 3: 0 <= nilaiAkhir < 60 → return false (Tidak Lulus)
     */
    public boolean isLulus(double nilaiAkhir) {
        // Cek apakah nilai tidak valid (negatif atau -1 dari error)
        if (nilaiAkhir < 0) {
            return false;
        }

        // Mahasiswa lulus jika nilai akhir >= 60
        if (nilaiAkhir >= BATAS_LULUS) {
            return true;
        }

        return false;
    }

    /**
     * Mendapatkan status kelulusan dalam bentuk String.
     *
     * @param nilaiAkhir Nilai akhir mahasiswa
     * @return "Lulus" jika nilai >= 60, "Tidak Lulus" jika tidak
     *
     * PATH TESTING NOTES:
     * Path 1: nilaiAkhir < 0 → return "Tidak Lulus (Nilai Tidak Valid)"
     * Path 2: nilaiAkhir >= 60 → return "Lulus"
     * Path 3: 0 <= nilaiAkhir < 60 → return "Tidak Lulus"
     */
    public String getStatusKelulusan(double nilaiAkhir) {
        // Cek nilai tidak valid
        if (nilaiAkhir < 0) {
            return "Tidak Lulus (Nilai Tidak Valid)";
        }

        // Kembalikan status berdasarkan nilai
        if (nilaiAkhir >= BATAS_LULUS) {
            return "Lulus";
        } else {
            return "Tidak Lulus";
        }
    }

    /**
     * Mendapatkan keterangan detail tentang status kelulusan.
     *
     * @param nilaiAkhir Nilai akhir mahasiswa
     * @return Pesan detail status kelulusan
     *
     * PATH TESTING NOTES:
     * Path 1: nilai tidak valid → return pesan error
     * Path 2: nilai >= 60 → return pesan lulus dengan nilai
     * Path 3: nilai < 60 → return pesan tidak lulus dengan selisih yang dibutuhkan
     */
    public String getKeteranganKelulusan(double nilaiAkhir) {
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
}
