import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * HitungNilaiAkhirTest.java
 * Unit test untuk method Mahasiswa.hitungNilaiAkhir().
 *
 * Rumus: nilai_akhir = (0.3 * tugas) + (0.3 * UTS) + (0.4 * UAS)
 * Setiap @Test menguji tepat 1 skenario.
 */
@DisplayName("Mahasiswa.hitungNilaiAkhir() Tests")
public class HitungNilaiAkhirTest {

    private Mahasiswa sut;

    @BeforeEach
    void setUp() {
        sut = new Mahasiswa();
    }

    @Test
    @DisplayName("Path 1a - Input tidak valid (negatif) harus return -1")
    void returnMinusOne_whenInputNegatif() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", -10, 75, 80);
        double actual;

        // (2) exercise (act, operate)
        actual = sut.hitungNilaiAkhir();

        // (3) verify (assert, check)
        double expected = -1;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    @DisplayName("Path 1b - Input tidak valid (semua 0) harus return -1")
    void returnMinusOne_whenSemuaNilaiNol() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 0, 0, 0);
        double actual;

        // (2) exercise (act, operate)
        actual = sut.hitungNilaiAkhir();

        // (3) verify (assert, check)
        double expected = -1;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    @DisplayName("Path 3a - Input valid, hitung nilai akhir 81.0")
    void returnNilaiAkhir_when80_70_90() {
        // (1) setup (arrange, build)
        // Expected: (0.3 * 80) + (0.3 * 70) + (0.4 * 90) = 24 + 21 + 36 = 81.0
        sut = new Mahasiswa("Test", 80, 70, 90);
        double actual;

        // (2) exercise (act, operate)
        actual = sut.hitungNilaiAkhir();

        // (3) verify (assert, check)
        double expected = 81.0;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    @DisplayName("Path 3b - Nilai akhir minimum valid (10, 10, 10) → 10.0")
    void returnNilaiAkhir_whenNilaiMinimum() {
        // (1) setup (arrange, build)
        // Expected: (0.3 * 10) + (0.3 * 10) + (0.4 * 10) = 3 + 3 + 4 = 10.0
        sut = new Mahasiswa("Test", 10, 10, 10);
        double actual;

        // (2) exercise (act, operate)
        actual = sut.hitungNilaiAkhir();

        // (3) verify (assert, check)
        double expected = 10.0;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    @DisplayName("Path 3c - Nilai akhir maksimum valid (100, 100, 100) → 100.0")
    void returnNilaiAkhir_whenNilaiMaksimum() {
        // (1) setup (arrange, build)
        // Expected: (0.3 * 100) + (0.3 * 100) + (0.4 * 100) = 30 + 30 + 40 = 100.0
        sut = new Mahasiswa("Test", 100, 100, 100);
        double actual;

        // (2) exercise (act, operate)
        actual = sut.hitungNilaiAkhir();

        // (3) verify (assert, check)
        double expected = 100.0;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    @DisplayName("Verifikasi rumus bobot: tugas 30%, UTS 30%, UAS 40%")
    void returnNilaiAkhir_verifikasiRumus() {
        // (1) setup (arrange, build)
        // Expected: (0.3 * 60) + (0.3 * 70) + (0.4 * 80) = 18 + 21 + 32 = 71.0
        sut = new Mahasiswa("Test", 60, 70, 80);
        double actual;

        // (2) exercise (act, operate)
        actual = sut.hitungNilaiAkhir();

        // (3) verify (assert, check)
        double expected = 71.0;
        assertEquals(expected, actual, 0.001);
    }
}
