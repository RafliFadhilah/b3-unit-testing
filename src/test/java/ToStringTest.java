import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ToStringTest.java
 * Unit test untuk method Mahasiswa.toString().
 *
 * Setiap @Test menguji tepat 1 skenario.
 */
@DisplayName("Mahasiswa.toString() Tests")
public class ToStringTest {

    private Mahasiswa sut;

    @BeforeEach
    void setUp() {
        sut = new Mahasiswa("Sari", 80, 75, 90);
    }

    @Test
    @DisplayName("toString mengandung nama mahasiswa")
    void containsNama() {
        // (1) setup (arrange, build)
        String actual;

        // (2) exercise (act, operate)
        actual = sut.toString();

        // (3) verify (assert, check)
        boolean expected = true;
        assertEquals(expected, actual.contains("Sari"));
    }

    @Test
    @DisplayName("toString mengandung nilai tugas")
    void containsNilaiTugas() {
        // (1) setup (arrange, build)
        String actual;

        // (2) exercise (act, operate)
        actual = sut.toString();

        // (3) verify (assert, check)
        boolean expected = true;
        assertEquals(expected, actual.contains("80"));
    }

    @Test
    @DisplayName("toString mengandung nilai UTS")
    void containsNilaiUTS() {
        // (1) setup (arrange, build)
        String actual;

        // (2) exercise (act, operate)
        actual = sut.toString();

        // (3) verify (assert, check)
        boolean expected = true;
        assertEquals(expected, actual.contains("75"));
    }

    @Test
    @DisplayName("toString mengandung nilai UAS")
    void containsNilaiUAS() {
        // (1) setup (arrange, build)
        String actual;

        // (2) exercise (act, operate)
        actual = sut.toString();

        // (3) verify (assert, check)
        boolean expected = true;
        assertEquals(expected, actual.contains("90"));
    }
}
