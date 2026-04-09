/**
 * CalculationModule.java
 * Modul untuk menghitung nilai akhir mahasiswa.
 *
 * Rumus:
 * nilai_akhir = (0.3 * tugas) + (0.3 * uts) + (0.4 * uas)
 *
 * Digunakan untuk path testing pada kondisi:
 * - Nilai tidak valid → return -1
 * - Nilai akhir > 100 → return -1
 * - Nilai valid dan hasil <= 100 → return nilai_akhir
 */
public class CalculationModule {

    private ValidationModule validator;

    /**
     * Konstruktor default, membuat instance ValidationModule baru.
     */
    public CalculationModule() {
        this.validator = new ValidationModule();
    }

    /**
     * Konstruktor dengan dependency injection untuk memudahkan unit testing.
     *
     * @param validator Instance ValidationModule yang digunakan
     */
    public CalculationModule(ValidationModule validator) {
        this.validator = validator;
    }

    /**
     * Menghitung nilai akhir berdasarkan bobot masing-masing komponen.
     * Rumus: nilai_akhir = (0.3 * tugas) + (0.3 * uts) + (0.4 * uas)
     *
     * @param nilaiTugas Nilai tugas mahasiswa
     * @param nilaiUTS   Nilai UTS mahasiswa
     * @param nilaiUAS   Nilai UAS mahasiswa
     * @return Nilai akhir jika valid, -1 jika tidak valid
     *
     * PATH TESTING NOTES:
     * Path 1: Input tidak valid (validator return false) → return -1
     * Path 2: Input valid, nilai akhir > 100 → return -1
     * Path 3: Input valid, nilai akhir <= 100 → return nilai_akhir
     */
    public double hitungNilaiAkhir(double nilaiTugas, double nilaiUTS, double nilaiUAS) {
        // Validasi input terlebih dahulu
        if (!validator.isValid(nilaiTugas, nilaiUTS, nilaiUAS)) {
            return -1; // Return -1 jika input tidak valid
        }

        // Hitung nilai akhir menggunakan bobot yang ditentukan
        double nilaiAkhir = (0.3 * nilaiTugas) + (0.3 * nilaiUTS) + (0.4 * nilaiUAS);

        // Cek apakah hasil perhitungan melebihi 100
        if (nilaiAkhir > 100) {
            return -1; // Tidak mungkin, tapi tetap dicek sebagai safety
        }

        return nilaiAkhir;
    }

    /**
     * Menghitung nilai akhir tanpa validasi (untuk pengujian kalkulasi murni).
     *
     * @param nilaiTugas Nilai tugas mahasiswa
     * @param nilaiUTS   Nilai UTS mahasiswa
     * @param nilaiUAS   Nilai UAS mahasiswa
     * @return Nilai akhir hasil perhitungan
     */
    public double hitungNilaiAkhirTanpaValidasi(double nilaiTugas, double nilaiUTS, double nilaiUAS) {
        return (0.3 * nilaiTugas) + (0.3 * nilaiUTS) + (0.4 * nilaiUAS);
    }
}
