import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * InputModuleTest.java
 * Unit test untuk class InputModule.
 *
 * Mencakup semua method getter, setter, dan isNamaValid().
 *
 * Path Testing untuk isNamaValid():
 * Path 1 - nama null  → return false
 * Path 2 - nama kosong → return false
 * Path 3 - nama valid  → return true
 *
 * Path Testing untuk setNamaMahasiswa():
 * Path 1 - nama null/kosong → set string kosong
 * Path 2 - nama valid       → set nama dengan trim
 */
@DisplayName("InputModule Tests")
public class InputModuleTest {

    private InputModule inputModule;

    @BeforeEach
    void setUp() {
        inputModule = new InputModule();
    }

    // ===============================
    // Test Konstruktor
    // ===============================

    @Test
    @DisplayName("Konstruktor default - semua field diinisialisasi dengan benar")
    void testKonstruktorDefault() {
        InputModule input = new InputModule();
        assertEquals("", input.getNamaMahasiswa());
        assertEquals(0, input.getNilaiTugas(), 0.001);
        assertEquals(0, input.getNilaiUTS(), 0.001);
        assertEquals(0, input.getNilaiUAS(), 0.001);
    }

    @Test
    @DisplayName("Konstruktor dengan parameter - nilai tersimpan dengan benar")
    void testKonstruktorDenganParameter() {
        InputModule input = new InputModule("Budi", 80, 75, 90);
        assertEquals("Budi", input.getNamaMahasiswa());
        assertEquals(80, input.getNilaiTugas(), 0.001);
        assertEquals(75, input.getNilaiUTS(), 0.001);
        assertEquals(90, input.getNilaiUAS(), 0.001);
    }

    // ===============================
    // Test Setter & Getter
    // ===============================

    @Test
    @DisplayName("setNamaMahasiswa - Path 1: nama null → disimpan sebagai empty string")
    void testSetNama_Null() {
        inputModule.setNamaMahasiswa(null);
        assertEquals("", inputModule.getNamaMahasiswa(), "Nama null harus disimpan sebagai string kosong");
    }

    @Test
    @DisplayName("setNamaMahasiswa - Path 1b: nama kosong → disimpan sebagai empty string")
    void testSetNama_Kosong() {
        inputModule.setNamaMahasiswa("   ");
        assertEquals("", inputModule.getNamaMahasiswa(), "Nama spasi harus disimpan sebagai string kosong");
    }

    @Test
    @DisplayName("setNamaMahasiswa - Path 2: nama valid → tersimpan dengan trim")
    void testSetNama_Valid() {
        inputModule.setNamaMahasiswa("  Budi Santoso  ");
        assertEquals("Budi Santoso", inputModule.getNamaMahasiswa(), "Nama harus tersimpan tanpa spasi ekstra");
    }

    @Test
    @DisplayName("setNilaiTugas dan getNilaiTugas - nilai tersimpan dengan benar")
    void testSetGetNilaiTugas() {
        inputModule.setNilaiTugas(85.5);
        assertEquals(85.5, inputModule.getNilaiTugas(), 0.001);
    }

    @Test
    @DisplayName("setNilaiUTS dan getNilaiUTS - nilai tersimpan dengan benar")
    void testSetGetNilaiUTS() {
        inputModule.setNilaiUTS(70.0);
        assertEquals(70.0, inputModule.getNilaiUTS(), 0.001);
    }

    @Test
    @DisplayName("setNilaiUAS dan getNilaiUAS - nilai tersimpan dengan benar")
    void testSetGetNilaiUAS() {
        inputModule.setNilaiUAS(90.0);
        assertEquals(90.0, inputModule.getNilaiUAS(), 0.001);
    }

    // ===============================
    // Test Method: isNamaValid()
    // ===============================

    @Test
    @DisplayName("isNamaValid - Path 1: nama null → false")
    void testIsNamaValid_Null() {
        inputModule.setNamaMahasiswa(null);
        assertFalse(inputModule.isNamaValid(), "Nama null harus tidak valid");
    }

    @Test
    @DisplayName("isNamaValid - Path 2: nama kosong → false")
    void testIsNamaValid_Kosong() {
        inputModule.setNamaMahasiswa("");
        assertFalse(inputModule.isNamaValid(), "Nama kosong harus tidak valid");
    }

    @Test
    @DisplayName("isNamaValid - Path 3: nama terisi → true")
    void testIsNamaValid_Valid() {
        inputModule.setNamaMahasiswa("Andi");
        assertTrue(inputModule.isNamaValid(), "Nama terisi harus valid");
    }

    // ===============================
    // Test Method: toString()
    // ===============================

    @Test
    @DisplayName("toString - menghasilkan representasi string yang benar")
    void testToString() {
        InputModule input = new InputModule("Sari", 80, 75, 90);
        String result = input.toString();
        assertTrue(result.contains("Sari"), "toString harus mengandung nama mahasiswa");
        assertTrue(result.contains("80"), "toString harus mengandung nilai tugas");
        assertTrue(result.contains("75"), "toString harus mengandung nilai UTS");
        assertTrue(result.contains("90"), "toString harus mengandung nilai UAS");
    }
}
