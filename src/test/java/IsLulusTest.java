import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * IsLulusTest.java
 * Unit test untuk method Mahasiswa.isLulus().
 *
 * Setiap @Test menguji tepat 1 skenario.
 */
@DisplayName("Mahasiswa.isLulus() Tests")
public class IsLulusTest {

    private Mahasiswa sut;

    @BeforeEach
    void setUp() {
        sut = new Mahasiswa();
    }

    @Test
    @DisplayName("Nilai tidak valid (negatif) → false")
    void returnFalse_whenNilaiTidakValid() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", -1, 75, 80);
        boolean actual;

        // (2) exercise (act, operate)
        actual = sut.isLulus();

        // (3) verify (assert, check)
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Nilai akhir >= 60 → true (Lulus)")
    void returnTrue_whenNilaiAkhir60Keatas() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 60, 60, 60);
        boolean actual;

        // (2) exercise (act, operate)
        actual = sut.isLulus();

        // (3) verify (assert, check)
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Nilai akhir = 100 → true (Lulus)")
    void returnTrue_whenNilaiAkhir100() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 100, 100, 100);
        boolean actual;

        // (2) exercise (act, operate)
        actual = sut.isLulus();

        // (3) verify (assert, check)
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Nilai akhir < 60 → false (Tidak Lulus)")
    void returnFalse_whenNilaiAkhirDibawah60() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 50, 50, 50);
        boolean actual;

        // (2) exercise (act, operate)
        actual = sut.isLulus();

        // (3) verify (assert, check)
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Batas kelulusan - nilai akhir tepat 59 → false")
    void returnFalse_whenNilaiAkhirTepat59() {
        // (1) setup (arrange, build)
        // Nilai (59, 59, 59) → NA = 59.0 → tidak lulus
        sut = new Mahasiswa("Test", 59, 59, 59);
        boolean actual;

        // (2) exercise (act, operate)
        actual = sut.isLulus();

        // (3) verify (assert, check)
        boolean expected = false;
        assertEquals(expected, actual);
    }
}
