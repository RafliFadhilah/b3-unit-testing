import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * GradeModuleTest.java
 * Unit test untuk class GradeModule.
 *
 * Mencakup semua path dalam method tentukanGrade():
 * Path 1 - nilaiAkhir < 0  → "INVALID"
 * Path 2 - nilaiAkhir >= 85 → "A"
 * Path 3 - 70 <= nilaiAkhir < 85 → "B"
 * Path 4 - 60 <= nilaiAkhir < 70 → "C"
 * Path 5 - 50 <= nilaiAkhir < 60 → "D"
 * Path 6 - nilaiAkhir < 50 → "E"
 */
@DisplayName("GradeModule Tests")
public class GradeModuleTest {

    private GradeModule gradeModule;

    @BeforeEach
    void setUp() {
        gradeModule = new GradeModule();
    }

    // ===============================
    // Test Method: tentukanGrade()
    // ===============================

    @Test
    @DisplayName("Path 1 - Nilai negatif harus return INVALID")
    void testTentukanGrade_NilaiNegatif() {
        // Arrange & Act
        String result = gradeModule.tentukanGrade(-1);

        // Assert
        assertEquals("INVALID", result, "Nilai negatif harus return INVALID");
    }

    @Test
    @DisplayName("Path 2 - Nilai >= 85 harus return A")
    void testTentukanGrade_GradeA() {
        assertEquals("A", gradeModule.tentukanGrade(85),  "Nilai 85 harus grade A");
        assertEquals("A", gradeModule.tentukanGrade(90),  "Nilai 90 harus grade A");
        assertEquals("A", gradeModule.tentukanGrade(100), "Nilai 100 harus grade A");
    }

    @Test
    @DisplayName("Path 3 - Nilai 70-84 harus return B")
    void testTentukanGrade_GradeB() {
        assertEquals("B", gradeModule.tentukanGrade(70), "Nilai 70 harus grade B");
        assertEquals("B", gradeModule.tentukanGrade(77), "Nilai 77 harus grade B");
        assertEquals("B", gradeModule.tentukanGrade(84), "Nilai 84 harus grade B");
    }

    @Test
    @DisplayName("Path 4 - Nilai 60-69 harus return C")
    void testTentukanGrade_GradeC() {
        assertEquals("C", gradeModule.tentukanGrade(60), "Nilai 60 harus grade C");
        assertEquals("C", gradeModule.tentukanGrade(65), "Nilai 65 harus grade C");
        assertEquals("C", gradeModule.tentukanGrade(69), "Nilai 69 harus grade C");
    }

    @Test
    @DisplayName("Path 5 - Nilai 50-59 harus return D")
    void testTentukanGrade_GradeD() {
        assertEquals("D", gradeModule.tentukanGrade(50), "Nilai 50 harus grade D");
        assertEquals("D", gradeModule.tentukanGrade(55), "Nilai 55 harus grade D");
        assertEquals("D", gradeModule.tentukanGrade(59), "Nilai 59 harus grade D");
    }

    @Test
    @DisplayName("Path 6 - Nilai < 50 harus return E")
    void testTentukanGrade_GradeE() {
        assertEquals("E", gradeModule.tentukanGrade(49), "Nilai 49 harus grade E");
        assertEquals("E", gradeModule.tentukanGrade(30), "Nilai 30 harus grade E");
        assertEquals("E", gradeModule.tentukanGrade(0),  "Nilai 0 harus grade E");
    }

    @Test
    @DisplayName("Batas nilai - tepat di perbatasan grade")
    void testTentukanGrade_BatasNilai() {
        // Tepat di batas A-B: 84 → B, 85 → A
        assertEquals("B", gradeModule.tentukanGrade(84), "Nilai 84 harus grade B");
        assertEquals("A", gradeModule.tentukanGrade(85), "Nilai 85 harus grade A");

        // Tepat di batas B-C: 69 → C, 70 → B
        assertEquals("C", gradeModule.tentukanGrade(69), "Nilai 69 harus grade C");
        assertEquals("B", gradeModule.tentukanGrade(70), "Nilai 70 harus grade B");

        // Tepat di batas C-D: 59 → D, 60 → C
        assertEquals("D", gradeModule.tentukanGrade(59), "Nilai 59 harus grade D");
        assertEquals("C", gradeModule.tentukanGrade(60), "Nilai 60 harus grade C");

        // Tepat di batas D-E: 49 → E, 50 → D
        assertEquals("E", gradeModule.tentukanGrade(49), "Nilai 49 harus grade E");
        assertEquals("D", gradeModule.tentukanGrade(50), "Nilai 50 harus grade D");
    }

    // ===============================
    // Test Method: getDeskripsiGrade()
    // ===============================

    @Test
    @DisplayName("getDeskripsiGrade - semua grade valid")
    void testGetDeskripsiGrade_SemuaGrade() {
        assertEquals("Sangat Memuaskan", gradeModule.getDeskripsiGrade("A"));
        assertEquals("Memuaskan",        gradeModule.getDeskripsiGrade("B"));
        assertEquals("Cukup",            gradeModule.getDeskripsiGrade("C"));
        assertEquals("Kurang",           gradeModule.getDeskripsiGrade("D"));
        assertEquals("Sangat Kurang",    gradeModule.getDeskripsiGrade("E"));
    }

    @Test
    @DisplayName("getDeskripsiGrade - grade tidak diketahui")
    void testGetDeskripsiGrade_GradeTidakValid() {
        assertEquals("Grade tidak diketahui", gradeModule.getDeskripsiGrade("INVALID"));
        assertEquals("Grade tidak diketahui", gradeModule.getDeskripsiGrade("Z"));
        assertEquals("Grade tidak diketahui", gradeModule.getDeskripsiGrade(""));
    }
}
