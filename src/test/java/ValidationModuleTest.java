import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ValidationModuleTest.java
 * Unit test untuk class ValidationModule.
 *
 * Mencakup semua path dalam method isValid() dan isInRange().
 *
 * Total Path yang diuji untuk isValid():
 * Path 1 - nilaiTugas < 0           → false
 * Path 2 - nilaiTugas > 100         → false
 * Path 3 - nilaiUTS < 0             → false
 * Path 4 - nilaiUTS > 100           → false
 * Path 5 - nilaiUAS < 0             → false
 * Path 6 - nilaiUAS > 100           → false
 * Path 7 - semua nilai = 0          → false
 * Path 8 - semua nilai valid, != 0  → true
 */
@DisplayName("ValidationModule Tests")
public class ValidationModuleTest {

    private ValidationModule validationModule;

    @BeforeEach
    void setUp() {
        validationModule = new ValidationModule();
    }

    // ===============================
    // Test Method: isValid()
    // ===============================

    @Test
    @DisplayName("Path 1 - NilaiTugas negatif harus return false")
    void testIsValid_NilaiTugasNegatif() {
        // Arrange
        double nilaiTugas = -1;
        double nilaiUTS   = 75;
        double nilaiUAS   = 80;

        // Act
        boolean result = validationModule.isValid(nilaiTugas, nilaiUTS, nilaiUAS);

        // Assert
        assertFalse(result, "Nilai tugas negatif seharusnya tidak valid");
    }

    @Test
    @DisplayName("Path 2 - NilaiTugas lebih dari 100 harus return false")
    void testIsValid_NilaiTugasLebihDari100() {
        // Arrange
        double nilaiTugas = 101;
        double nilaiUTS   = 75;
        double nilaiUAS   = 80;

        // Act
        boolean result = validationModule.isValid(nilaiTugas, nilaiUTS, nilaiUAS);

        // Assert
        assertFalse(result, "Nilai tugas > 100 seharusnya tidak valid");
    }

    @Test
    @DisplayName("Path 3 - NilaiUTS negatif harus return false")
    void testIsValid_NilaiUTSNegatif() {
        // Arrange
        double nilaiTugas = 80;
        double nilaiUTS   = -5;
        double nilaiUAS   = 80;

        // Act
        boolean result = validationModule.isValid(nilaiTugas, nilaiUTS, nilaiUAS);

        // Assert
        assertFalse(result, "Nilai UTS negatif seharusnya tidak valid");
    }

    @Test
    @DisplayName("Path 4 - NilaiUTS lebih dari 100 harus return false")
    void testIsValid_NilaiUTSLebihDari100() {
        // Arrange
        double nilaiTugas = 80;
        double nilaiUTS   = 150;
        double nilaiUAS   = 80;

        // Act
        boolean result = validationModule.isValid(nilaiTugas, nilaiUTS, nilaiUAS);

        // Assert
        assertFalse(result, "Nilai UTS > 100 seharusnya tidak valid");
    }

    @Test
    @DisplayName("Path 5 - NilaiUAS negatif harus return false")
    void testIsValid_NilaiUASNegatif() {
        // Arrange
        double nilaiTugas = 80;
        double nilaiUTS   = 75;
        double nilaiUAS   = -10;

        // Act
        boolean result = validationModule.isValid(nilaiTugas, nilaiUTS, nilaiUAS);

        // Assert
        assertFalse(result, "Nilai UAS negatif seharusnya tidak valid");
    }

    @Test
    @DisplayName("Path 6 - NilaiUAS lebih dari 100 harus return false")
    void testIsValid_NilaiUASLebihDari100() {
        // Arrange
        double nilaiTugas = 80;
        double nilaiUTS   = 75;
        double nilaiUAS   = 200;

        // Act
        boolean result = validationModule.isValid(nilaiTugas, nilaiUTS, nilaiUAS);

        // Assert
        assertFalse(result, "Nilai UAS > 100 seharusnya tidak valid");
    }

    @Test
    @DisplayName("Path 7 - Semua nilai 0 harus return false")
    void testIsValid_SemuaNilaiNol() {
        // Arrange
        double nilaiTugas = 0;
        double nilaiUTS   = 0;
        double nilaiUAS   = 0;

        // Act
        boolean result = validationModule.isValid(nilaiTugas, nilaiUTS, nilaiUAS);

        // Assert
        assertFalse(result, "Semua nilai 0 seharusnya tidak valid");
    }

    @Test
    @DisplayName("Path 8 - Semua nilai valid harus return true")
    void testIsValid_SemuaNilaiValid() {
        // Arrange
        double nilaiTugas = 80;
        double nilaiUTS   = 75;
        double nilaiUAS   = 90;

        // Act
        boolean result = validationModule.isValid(nilaiTugas, nilaiUTS, nilaiUAS);

        // Assert
        assertTrue(result, "Nilai valid seharusnya lolos validasi");
    }

    @Test
    @DisplayName("Nilai tepat 0 (tugas saja) dengan yang lain > 0 masih valid")
    void testIsValid_SatunilaiNolTidakSemuaNol() {
        // Arrange
        double nilaiTugas = 0;
        double nilaiUTS   = 70;
        double nilaiUAS   = 80;

        // Act
        boolean result = validationModule.isValid(nilaiTugas, nilaiUTS, nilaiUAS);

        // Assert
        assertTrue(result, "Nilai 0 di salah satu komponen masih valid jika tidak semua 0");
    }

    @Test
    @DisplayName("Nilai tepat batas atas (100) harus valid")
    void testIsValid_NilaiTepatBatasAtas() {
        // Arrange
        double nilaiTugas = 100;
        double nilaiUTS   = 100;
        double nilaiUAS   = 100;

        // Act
        boolean result = validationModule.isValid(nilaiTugas, nilaiUTS, nilaiUAS);

        // Assert
        assertTrue(result, "Nilai tepat 100 seharusnya valid");
    }

    // ===============================
    // Test Method: isInRange()
    // ===============================

    @Test
    @DisplayName("isInRange - Path 1: nilai negatif → false")
    void testIsInRange_Negatif() {
        assertFalse(validationModule.isInRange(-1), "Nilai negatif seharusnya di luar range");
    }

    @Test
    @DisplayName("isInRange - Path 2: nilai > 100 → false")
    void testIsInRange_LebihDari100() {
        assertFalse(validationModule.isInRange(101), "Nilai > 100 seharusnya di luar range");
    }

    @Test
    @DisplayName("isInRange - Path 3: nilai 0-100 → true")
    void testIsInRange_DalamRange() {
        assertTrue(validationModule.isInRange(50), "Nilai 50 seharusnya dalam range");
        assertTrue(validationModule.isInRange(0), "Nilai 0 seharusnya dalam range");
        assertTrue(validationModule.isInRange(100), "Nilai 100 seharusnya dalam range");
    }
}
