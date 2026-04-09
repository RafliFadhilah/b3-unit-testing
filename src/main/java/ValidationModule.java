/**
 * ValidationModule.java
 * Modul untuk memvalidasi input nilai mahasiswa.
 * 
 * Digunakan untuk path testing pada kondisi:
 * - Semua nilai dalam range 0-100 → valid
 * - Ada nilai di luar range (<0 atau >100) → tidak valid
 * - Semua nilai = 0 → tidak valid
 */
public class ValidationModule {

    /**
     * Memvalidasi apakah nilai tugas, UTS, dan UAS memenuhi syarat.
     *
     * @param nilaiTugas Nilai tugas (0-100)
     * @param nilaiUTS   Nilai UTS (0-100)
     * @param nilaiUAS   Nilai UAS (0-100)
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
    public boolean isValid(double nilaiTugas, double nilaiUTS, double nilaiUAS) {
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
     *
     * @param nilai Nilai yang akan dicek
     * @return true jika nilai dalam range [0, 100], false jika tidak
     *
     * PATH TESTING NOTES:
     * Path 1: nilai < 0 → return false
     * Path 2: nilai > 100 → return false
     * Path 3: 0 <= nilai <= 100 → return true
     */
    public boolean isInRange(double nilai) {
        if (nilai < 0) {
            return false;
        }
        if (nilai > 100) {
            return false;
        }
        return true;
    }
}
