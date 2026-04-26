import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * GetKeteranganKelulusanTest.java
 * Unit test untuk method Mahasiswa.getKeteranganKelulusan().
 *
 * Setiap @Test menguji tepat 1 skenario.
 */
@DisplayName("Mahasiswa.getKeteranganKelulusan() Tests")
public class GetKeteranganKelulusanTest {

    private Mahasiswa sut;

    @BeforeEach
    void setUp() {
        sut = new Mahasiswa();
    }

    @Test
    @DisplayName("Nilai tidak valid → pesan error")
    void returnPesanError_whenNilaiTidakValid() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", -1, 75, 80);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.getKeteranganKelulusan();

        // (3) verify (assert, check)
        String expected = "Data nilai tidak valid, tidak dapat menentukan kelulusan.";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Mahasiswa lulus → pesan selamat dengan nilai")
    void returnPesanLulus_whenLulus() {
        // (1) setup (arrange, build)
        // NA = (0.3 * 80) + (0.3 * 80) + (0.4 * 80) = 80.0
        sut = new Mahasiswa("Test", 80, 80, 80);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.getKeteranganKelulusan();

        // (3) verify (assert, check)
        String expected = "Selamat! Anda LULUS dengan nilai 80.00";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Mahasiswa tidak lulus → pesan kekurangan poin")
    void returnPesanTidakLulus_whenTidakLulus() {
        // (1) setup (arrange, build)
        // NA = (0.3 * 50) + (0.3 * 50) + (0.4 * 50) = 50.0, selisih = 10.0
        sut = new Mahasiswa("Test", 50, 50, 50);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.getKeteranganKelulusan();

        // (3) verify (assert, check)
        String expected = "Maaf, Anda TIDAK LULUS. Kekurangan 10.00 poin untuk lulus.";
        assertEquals(expected, actual);
    }
}
