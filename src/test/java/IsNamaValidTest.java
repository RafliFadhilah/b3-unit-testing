import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * IsNamaValidTest.java
 * Unit test untuk method Mahasiswa.isNamaValid().
 *
 * Setiap @Test menguji tepat 1 skenario.
 */
@DisplayName("Mahasiswa.isNamaValid() Tests")
public class IsNamaValidTest {

    private Mahasiswa sut;

    @BeforeEach
    void setUp() {
        sut = new Mahasiswa();
    }

    @Test
    @DisplayName("Nama null → false")
    void returnFalse_whenNamaNull() {
        // (1) setup (arrange, build)
        sut.setNama(null);
        boolean actual;

        // (2) exercise (act, operate)
        actual = sut.isNamaValid();

        // (3) verify (assert, check)
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Nama kosong → false")
    void returnFalse_whenNamaKosong() {
        // (1) setup (arrange, build)
        sut.setNama("");
        boolean actual;

        // (2) exercise (act, operate)
        actual = sut.isNamaValid();

        // (3) verify (assert, check)
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Nama terisi → true")
    void returnTrue_whenNamaTerisi() {
        // (1) setup (arrange, build)
        sut.setNama("Andi");
        boolean actual;

        // (2) exercise (act, operate)
        actual = sut.isNamaValid();

        // (3) verify (assert, check)
        boolean expected = true;
        assertEquals(expected, actual);
    }
}
