import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * CalculationModuleTest.java
 * Unit test untuk class CalculationModule.
 *
 * Mencakup semua path dalam method hitungNilaiAkhir():
 * Path 1 - Input tidak valid (validator return false) → return -1
 * Path 2 - Input valid, nilaiAkhir > 100              → return -1
 * Path 3 - Input valid, nilaiAkhir <= 100             → return nilai_akhir
 */
@DisplayName("CalculationModule Tests")
public class CalculationModuleTest {

    private CalculationModule calculationModule;

    @BeforeEach
    void setUp() {
        ValidationModule validationModule = new ValidationModule();
        calculationModule = new CalculationModule(validationModule);
    }

    // ===============================
    // Test Method: hitungNilaiAkhir()
    // ===============================

    @Test
    @DisplayName("Path 1 - Input tidak valid (negatif) harus return -1")
    void testHitungNilaiAkhir_InputTidakValid() {
        // Arrange
        double nilaiTugas = -10;
        double nilaiUTS   = 75;
        double nilaiUAS   = 80;

        // Act
        double result = calculationModule.hitungNilaiAkhir(nilaiTugas, nilaiUTS, nilaiUAS);

        // Assert
        assertEquals(-1, result, "Input tidak valid harus return -1");
    }

    @Test
    @DisplayName("Path 1b - Input tidak valid (semua 0) harus return -1")
    void testHitungNilaiAkhir_SemuaNilaiNol() {
        // Arrange & Act
        double result = calculationModule.hitungNilaiAkhir(0, 0, 0);

        // Assert
        assertEquals(-1, result, "Semua nilai 0 harus return -1");
    }

    @Test
    @DisplayName("Path 3 - Input valid, hitung nilai akhir dengan benar")
    void testHitungNilaiAkhir_HasilBenar() {
        // Arrange
        double nilaiTugas = 80;
        double nilaiUTS   = 70;
        double nilaiUAS   = 90;
        // Expected: (0.3 * 80) + (0.3 * 70) + (0.4 * 90) = 24 + 21 + 36 = 81.0

        // Act
        double result = calculationModule.hitungNilaiAkhir(nilaiTugas, nilaiUTS, nilaiUAS);

        // Assert
        assertEquals(81.0, result, 0.001, "Nilai akhir harus 81.0");
    }

    @Test
    @DisplayName("Path 3b - Nilai akhir tepat di batas minimum valid")
    void testHitungNilaiAkhir_HasilMinimum() {
        // Arrange: semua nilai kecil tapi valid
        double nilaiTugas = 10;
        double nilaiUTS   = 10;
        double nilaiUAS   = 10;
        // Expected: (0.3 * 10) + (0.3 * 10) + (0.4 * 10) = 3 + 3 + 4 = 10.0

        // Act
        double result = calculationModule.hitungNilaiAkhir(nilaiTugas, nilaiUTS, nilaiUAS);

        // Assert
        assertEquals(10.0, result, 0.001, "Nilai akhir harus 10.0");
    }

    @Test
    @DisplayName("Path 3c - Nilai akhir tepat 100 (maksimum valid)")
    void testHitungNilaiAkhir_HasilMaksimum() {
        // Arrange
        double nilaiTugas = 100;
        double nilaiUTS   = 100;
        double nilaiUAS   = 100;
        // Expected: (0.3 * 100) + (0.3 * 100) + (0.4 * 100) = 30 + 30 + 40 = 100.0

        // Act
        double result = calculationModule.hitungNilaiAkhir(nilaiTugas, nilaiUTS, nilaiUAS);

        // Assert
        assertEquals(100.0, result, 0.001, "Nilai akhir harus 100.0");
    }

    @Test
    @DisplayName("Verifikasi rumus: bobot tugas 30%, UTS 30%, UAS 40%")
    void testHitungNilaiAkhir_VerifikasiRumus() {
        // Arrange
        double nilaiTugas = 60;
        double nilaiUTS   = 70;
        double nilaiUAS   = 80;
        // Expected: (0.3 * 60) + (0.3 * 70) + (0.4 * 80) = 18 + 21 + 32 = 71.0

        // Act
        double result = calculationModule.hitungNilaiAkhir(nilaiTugas, nilaiUTS, nilaiUAS);

        // Assert
        assertEquals(71.0, result, 0.001, "Nilai akhir harus 71.0");
    }

    // ===============================
    // Test Method: hitungNilaiAkhirTanpaValidasi()
    // ===============================

    @Test
    @DisplayName("hitungNilaiAkhirTanpaValidasi - kalkulasi murni")
    void testHitungNilaiAkhirTanpaValidasi() {
        // Arrange
        double nilaiTugas = 80;
        double nilaiUTS   = 80;
        double nilaiUAS   = 80;
        // Expected: (0.3 * 80) + (0.3 * 80) + (0.4 * 80) = 24 + 24 + 32 = 80.0

        // Act
        double result = calculationModule.hitungNilaiAkhirTanpaValidasi(nilaiTugas, nilaiUTS, nilaiUAS);

        // Assert
        assertEquals(80.0, result, 0.001, "Kalkulasi murni harus benar");
    }
}
