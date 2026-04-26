import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * GetStatusKelulusanTest.java
 * Unit test untuk method Mahasiswa.getStatusKelulusan().
 *
 * Setiap @Test menguji tepat 1 skenario.
 */
@DisplayName("Mahasiswa.getStatusKelulusan() Tests")
public class GetStatusKelulusanTest {

    private Mahasiswa sut;

    @BeforeEach
    void setUp() {
        sut = new Mahasiswa();
    }

    @Test
    @DisplayName("Nilai negatif → Tidak Lulus (Nilai Tidak Valid)")
    void returnTidakValid_whenNilaiNegatif() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", -1, 75, 80);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.getStatusKelulusan();

        // (3) verify (assert, check)
        String expected = "Tidak Lulus (Nilai Tidak Valid)";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Nilai akhir >= 60 → Lulus")
    void returnLulus_whenNilaiAkhir60Keatas() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 60, 60, 60);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.getStatusKelulusan();

        // (3) verify (assert, check)
        String expected = "Lulus";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Nilai akhir = 85 → Lulus")
    void returnLulus_whenNilaiAkhir85() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 85, 85, 85);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.getStatusKelulusan();

        // (3) verify (assert, check)
        String expected = "Lulus";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Nilai akhir < 60 → Tidak Lulus")
    void returnTidakLulus_whenNilaiAkhirDibawah60() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 50, 50, 50);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.getStatusKelulusan();

        // (3) verify (assert, check)
        String expected = "Tidak Lulus";
        assertEquals(expected, actual);
    }
}
