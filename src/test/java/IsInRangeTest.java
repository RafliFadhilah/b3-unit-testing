import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * IsInRangeTest.java
 * Unit test untuk method static Mahasiswa.isInRange().
 *
 * Setiap @Test menguji tepat 1 skenario path testing.
 */
@DisplayName("Mahasiswa.isInRange() Tests")
public class IsInRangeTest {

    private Mahasiswa sut;

    @BeforeEach
    void setUp() {
        sut = new Mahasiswa();
    }

    @Test
    @DisplayName("Path 1 - Nilai negatif harus return false")
    void returnFalse_whenNilaiNegatif() {
        // (1) setup (arrange, build)
        double nilai = -1;
        boolean actual;

        // (2) exercise (act, operate)
        actual = Mahasiswa.isInRange(nilai);

        // (3) verify (assert, check)
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Path 2 - Nilai lebih dari 100 harus return false")
    void returnFalse_whenNilaiLebihDari100() {
        // (1) setup (arrange, build)
        double nilai = 101;
        boolean actual;

        // (2) exercise (act, operate)
        actual = Mahasiswa.isInRange(nilai);

        // (3) verify (assert, check)
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Path 3a - Nilai 50 (tengah range) harus return true")
    void returnTrue_whenNilaiDiTengahRange() {
        // (1) setup (arrange, build)
        double nilai = 50;
        boolean actual;

        // (2) exercise (act, operate)
        actual = Mahasiswa.isInRange(nilai);

        // (3) verify (assert, check)
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Path 3b - Nilai tepat 0 (batas bawah) harus return true")
    void returnTrue_whenNilaiTepatNol() {
        // (1) setup (arrange, build)
        double nilai = 0;
        boolean actual;

        // (2) exercise (act, operate)
        actual = Mahasiswa.isInRange(nilai);

        // (3) verify (assert, check)
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Path 3c - Nilai tepat 100 (batas atas) harus return true")
    void returnTrue_whenNilaiTepat100() {
        // (1) setup (arrange, build)
        double nilai = 100;
        boolean actual;

        // (2) exercise (act, operate)
        actual = Mahasiswa.isInRange(nilai);

        // (3) verify (assert, check)
        boolean expected = true;
        assertEquals(expected, actual);
    }
}
