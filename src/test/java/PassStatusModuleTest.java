import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * PassStatusModuleTest.java
 * Unit test untuk class PassStatusModule.
 *
 * Mencakup semua path dalam method isLulus() dan getStatusKelulusan():
 *
 * isLulus():
 * Path 1 - nilaiAkhir < 0 (nilai invalid)     → false
 * Path 2 - nilaiAkhir >= 60                   → true (Lulus)
 * Path 3 - 0 <= nilaiAkhir < 60               → false (Tidak Lulus)
 *
 * getStatusKelulusan():
 * Path 1 - nilaiAkhir < 0 → "Tidak Lulus (Nilai Tidak Valid)"
 * Path 2 - nilaiAkhir >= 60 → "Lulus"
 * Path 3 - 0 <= nilaiAkhir < 60 → "Tidak Lulus"
 */
@DisplayName("PassStatusModule Tests")
public class PassStatusModuleTest {

    private PassStatusModule passStatusModule;

    @BeforeEach
    void setUp() {
        passStatusModule = new PassStatusModule();
    }

    // ===============================
    // Test Method: isLulus()
    // ===============================

    @Test
    @DisplayName("Path 1 - Nilai negatif (invalid) harus return false")
    void testIsLulus_NilaiTidakValid() {
        // Arrange & Act
        boolean result = passStatusModule.isLulus(-1);

        // Assert
        assertFalse(result, "Nilai negatif (error dari CalculationModule) harus tidak lulus");
    }

    @Test
    @DisplayName("Path 2 - Nilai >= 60 harus return true (Lulus)")
    void testIsLulus_Lulus() {
        assertTrue(passStatusModule.isLulus(60),  "Nilai tepat 60 harus lulus");
        assertTrue(passStatusModule.isLulus(75),  "Nilai 75 harus lulus");
        assertTrue(passStatusModule.isLulus(100), "Nilai 100 harus lulus");
    }

    @Test
    @DisplayName("Path 3 - Nilai < 60 harus return false (Tidak Lulus)")
    void testIsLulus_TidakLulus() {
        assertFalse(passStatusModule.isLulus(59), "Nilai 59 harus tidak lulus");
        assertFalse(passStatusModule.isLulus(30), "Nilai 30 harus tidak lulus");
        assertFalse(passStatusModule.isLulus(0),  "Nilai 0 harus tidak lulus");
    }

    @Test
    @DisplayName("Batas kelulusan - tepat di 59 vs 60")
    void testIsLulus_BatasKelulusan() {
        assertFalse(passStatusModule.isLulus(59.99), "Nilai 59.99 harus tidak lulus");
        assertTrue(passStatusModule.isLulus(60.0),   "Nilai 60.0 harus lulus");
    }

    // ===============================
    // Test Method: getStatusKelulusan()
    // ===============================

    @Test
    @DisplayName("getStatusKelulusan - Path 1: nilai negatif")
    void testGetStatusKelulusan_NilaiNegatif() {
        String result = passStatusModule.getStatusKelulusan(-1);
        assertEquals("Tidak Lulus (Nilai Tidak Valid)", result);
    }

    @Test
    @DisplayName("getStatusKelulusan - Path 2: nilai >= 60 → Lulus")
    void testGetStatusKelulusan_Lulus() {
        assertEquals("Lulus", passStatusModule.getStatusKelulusan(60));
        assertEquals("Lulus", passStatusModule.getStatusKelulusan(85));
        assertEquals("Lulus", passStatusModule.getStatusKelulusan(100));
    }

    @Test
    @DisplayName("getStatusKelulusan - Path 3: nilai < 60 → Tidak Lulus")
    void testGetStatusKelulusan_TidakLulus() {
        assertEquals("Tidak Lulus", passStatusModule.getStatusKelulusan(59));
        assertEquals("Tidak Lulus", passStatusModule.getStatusKelulusan(0));
    }

    // ===============================
    // Test Method: getKeteranganKelulusan()
    // ===============================

    @Test
    @DisplayName("getKeteranganKelulusan - nilai tidak valid")
    void testGetKeteranganKelulusan_NilaiTidakValid() {
        String result = passStatusModule.getKeteranganKelulusan(-1);
        assertTrue(result.contains("tidak valid"), "Harus menyebut 'tidak valid'");
    }

    @Test
    @DisplayName("getKeteranganKelulusan - mahasiswa lulus")
    void testGetKeteranganKelulusan_Lulus() {
        String result = passStatusModule.getKeteranganKelulusan(80);
        assertTrue(result.contains("LULUS"), "Harus mengandung kata LULUS");
    }

    @Test
    @DisplayName("getKeteranganKelulusan - mahasiswa tidak lulus + selisih")
    void testGetKeteranganKelulusan_TidakLulus() {
        String result = passStatusModule.getKeteranganKelulusan(50);
        assertTrue(result.contains("TIDAK LULUS"), "Harus mengandung kata TIDAK LULUS");
        assertTrue(result.contains("10"), "Harus menyebutkan selisih dari batas lulus (60-50=10)");
    }

    // ===============================
    // Test Konstanta BATAS_LULUS
    // ===============================

    @Test
    @DisplayName("Konstanta BATAS_LULUS harus bernilai 60")
    void testKonstantaBatasLulus() {
        assertEquals(60.0, PassStatusModule.BATAS_LULUS, 0.001,
                     "Konstanta batas lulus harus 60.0");
    }
}
