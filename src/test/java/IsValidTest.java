import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * IsValidTest.java
 * Unit test untuk method Mahasiswa.isValid().
 *
 * Setiap @Test menguji tepat 1 skenario path testing.
 */
@DisplayName("Mahasiswa.isValid() Tests")
public class IsValidTest {

    private Mahasiswa sut;

    @BeforeEach
    void setUp() {
        sut = new Mahasiswa();
    }

    @Test
    @DisplayName("Path 1 - NilaiTugas negatif harus return false")
    void returnFalse_whenNilaiTugasNegatif() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", -1, 75, 80);
        boolean actual;

        // (2) exercise (act, operate)
        actual = sut.isValid();

        // (3) verify (assert, check)
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Path 2 - NilaiTugas lebih dari 100 harus return false")
    void returnFalse_whenNilaiTugasLebihDari100() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 101, 75, 80);
        boolean actual;

        // (2) exercise (act, operate)
        actual = sut.isValid();

        // (3) verify (assert, check)
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Path 3 - NilaiUTS negatif harus return false")
    void returnFalse_whenNilaiUTSNegatif() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 80, -5, 80);
        boolean actual;

        // (2) exercise (act, operate)
        actual = sut.isValid();

        // (3) verify (assert, check)
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Path 4 - NilaiUTS lebih dari 100 harus return false")
    void returnFalse_whenNilaiUTSLebihDari100() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 80, 150, 80);
        boolean actual;

        // (2) exercise (act, operate)
        actual = sut.isValid();

        // (3) verify (assert, check)
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Path 5 - NilaiUAS negatif harus return false")
    void returnFalse_whenNilaiUASNegatif() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 80, 75, -10);
        boolean actual;

        // (2) exercise (act, operate)
        actual = sut.isValid();

        // (3) verify (assert, check)
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Path 6 - NilaiUAS lebih dari 100 harus return false")
    void returnFalse_whenNilaiUASLebihDari100() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 80, 75, 200);
        boolean actual;

        // (2) exercise (act, operate)
        actual = sut.isValid();

        // (3) verify (assert, check)
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Path 7 - Semua nilai 0 harus return false")
    void returnFalse_whenSemuaNilaiNol() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 0, 0, 0);
        boolean actual;

        // (2) exercise (act, operate)
        actual = sut.isValid();

        // (3) verify (assert, check)
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Path 8 - Semua nilai valid harus return true")
    void returnTrue_whenSemuaNilaiValid() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 80, 75, 90);
        boolean actual;

        // (2) exercise (act, operate)
        actual = sut.isValid();

        // (3) verify (assert, check)
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Satu nilai 0 tapi bukan semua nol - masih valid")
    void returnTrue_whenSatuNilaiNolTidakSemuaNol() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 0, 70, 80);
        boolean actual;

        // (2) exercise (act, operate)
        actual = sut.isValid();

        // (3) verify (assert, check)
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Nilai tepat batas atas (100) harus valid")
    void returnTrue_whenNilaiTepatBatasAtas() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 100, 100, 100);
        boolean actual;

        // (2) exercise (act, operate)
        actual = sut.isValid();

        // (3) verify (assert, check)
        boolean expected = true;
        assertEquals(expected, actual);
    }
}
