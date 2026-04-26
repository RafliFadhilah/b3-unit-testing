import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TentukanGradeTest.java
 * Unit test untuk method Mahasiswa.tentukanGrade().
 *
 * Kriteria Grade:
 *   >= 85       → A
 *   70 - 84     → B
 *   60 - 69     → C
 *   50 - 59     → D
 *   < 50        → E
 *   invalid     → INVALID
 *
 * Setiap @Test menguji tepat 1 skenario.
 */
@DisplayName("Mahasiswa.tentukanGrade() Tests")
public class TentukanGradeTest {

    private Mahasiswa sut;

    @BeforeEach
    void setUp() {
        sut = new Mahasiswa();
    }

    @Test
    @DisplayName("Nilai tidak valid (negatif) harus return INVALID")
    void returnINVALID_whenNilaiTidakValid() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", -1, 75, 80);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.tentukanGrade();

        // (3) verify (assert, check)
        String expected = "INVALID";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Nilai akhir >= 85 harus return A (nilai 85, 90, 85 → 86.5)")
    void returnA_whenNilaiAkhir85Keatas() {
        // (1) setup (arrange, build)
        // (0.3 * 85) + (0.3 * 90) + (0.4 * 85) = 25.5 + 27 + 34 = 86.5
        sut = new Mahasiswa("Test", 85, 90, 85);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.tentukanGrade();

        // (3) verify (assert, check)
        String expected = "A";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Nilai akhir = 100 harus return A")
    void returnA_whenNilaiAkhir100() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 100, 100, 100);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.tentukanGrade();

        // (3) verify (assert, check)
        String expected = "A";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Nilai akhir range 70-84 harus return B (70, 70, 70 → 70.0)")
    void returnB_whenNilaiAkhir70() {
        // (1) setup (arrange, build)
        // (0.3 * 70) + (0.3 * 70) + (0.4 * 70) = 21 + 21 + 28 = 70.0
        sut = new Mahasiswa("Test", 70, 70, 70);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.tentukanGrade();

        // (3) verify (assert, check)
        String expected = "B";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Nilai akhir range 70-84 harus return B (80, 80, 80 → 80.0)")
    void returnB_whenNilaiAkhir80() {
        // (1) setup (arrange, build)
        // (0.3 * 80) + (0.3 * 80) + (0.4 * 80) = 24 + 24 + 32 = 80.0
        sut = new Mahasiswa("Test", 80, 80, 80);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.tentukanGrade();

        // (3) verify (assert, check)
        String expected = "B";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Nilai akhir range 60-69 harus return C (65, 65, 65 → 65.0)")
    void returnC_whenNilaiAkhir65() {
        // (1) setup (arrange, build)
        // (0.3 * 65) + (0.3 * 65) + (0.4 * 65) = 19.5 + 19.5 + 26 = 65.0
        sut = new Mahasiswa("Test", 65, 65, 65);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.tentukanGrade();

        // (3) verify (assert, check)
        String expected = "C";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Nilai akhir range 50-59 harus return D (55, 55, 55 → 55.0)")
    void returnD_whenNilaiAkhir55() {
        // (1) setup (arrange, build)
        // (0.3 * 55) + (0.3 * 55) + (0.4 * 55) = 16.5 + 16.5 + 22 = 55.0
        sut = new Mahasiswa("Test", 55, 55, 55);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.tentukanGrade();

        // (3) verify (assert, check)
        String expected = "D";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Nilai akhir < 50 harus return E (30, 30, 30 → 30.0)")
    void returnE_whenNilaiAkhir30() {
        // (1) setup (arrange, build)
        // (0.3 * 30) + (0.3 * 30) + (0.4 * 30) = 9 + 9 + 12 = 30.0
        sut = new Mahasiswa("Test", 30, 30, 30);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.tentukanGrade();

        // (3) verify (assert, check)
        String expected = "E";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Batas A-B: nilai akhir tepat 85 harus A (nilai 85 semua → 85.0)")
    void returnA_whenNilaiAkhirTepat85() {
        // (1) setup (arrange, build)
        // (0.3 * 85) + (0.3 * 85) + (0.4 * 85) = 25.5 + 25.5 + 34 = 85.0
        sut = new Mahasiswa("Test", 85, 85, 85);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.tentukanGrade();

        // (3) verify (assert, check)
        String expected = "A";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Batas B-C: nilai akhir tepat 70 harus B")
    void returnB_whenNilaiAkhirTepat70() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 70, 70, 70);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.tentukanGrade();

        // (3) verify (assert, check)
        String expected = "B";
        assertEquals(expected, actual);
    }
}
