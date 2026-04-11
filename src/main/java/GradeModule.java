/**
 * GradeModule.java
 * Modul untuk menentukan grade/huruf berdasarkan nilai akhir mahasiswa.
 *
 * Kriteria:
 * >= 85        → A
 * 70  - 84     → B
 * 60  - 69     → C
 * 50  - 59     → D
 * < 50         → E
 *
 * Digunakan untuk path testing pada kondisi multi-branch.
 */
public class GradeModule {

    /**
     * Menentukan grade huruf berdasarkan nilai akhir.
     *
     * @param nilaiAkhir Nilai akhir mahasiswa (seharusnya 0-100)
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
    public String tentukanGrade(double nilaiAkhir) {
        // Cek nilai tidak valid
        if (nilaiAkhir < 0) {
            return "INVALID";
        }

        // Tentukan grade berdasarkan nilai akhir
        if (nilaiAkhir >= 80) { // BUG: batas A salah (harusnya 85, jadi 80)
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
     * @param grade Huruf grade ("A", "B", "C", "D", "E")
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
    public String getDeskripsiGrade(String grade) {
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
}
