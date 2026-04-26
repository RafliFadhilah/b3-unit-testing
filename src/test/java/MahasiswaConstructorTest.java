import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * MahasiswaConstructorTest.java
 * Unit test untuk konstruktor class Mahasiswa.
 */
@DisplayName("Mahasiswa Constructor Tests")
public class MahasiswaConstructorTest {

    private Mahasiswa sut;

    @BeforeEach
    void setUp() {
        sut = new Mahasiswa();
    }

    @Test
    @DisplayName("Konstruktor default - nama diinisialisasi string kosong")
    void defaultConstructor_namaKosong() {
        // (1) setup (arrange, build)
        String actual;

        // (2) exercise (act, operate)
        actual = sut.getNama();

        // (3) verify (assert, check)
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Konstruktor default - nilaiTugas diinisialisasi 0")
    void defaultConstructor_nilaiTugasNol() {
        // (1) setup (arrange, build)
        double actual;

        // (2) exercise (act, operate)
        actual = sut.getNilaiTugas();

        // (3) verify (assert, check)
        double expected = 0;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    @DisplayName("Konstruktor default - nilaiUTS diinisialisasi 0")
    void defaultConstructor_nilaiUTSNol() {
        // (1) setup (arrange, build)
        double actual;

        // (2) exercise (act, operate)
        actual = sut.getNilaiUTS();

        // (3) verify (assert, check)
        double expected = 0;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    @DisplayName("Konstruktor default - nilaiUAS diinisialisasi 0")
    void defaultConstructor_nilaiUASNol() {
        // (1) setup (arrange, build)
        double actual;

        // (2) exercise (act, operate)
        actual = sut.getNilaiUAS();

        // (3) verify (assert, check)
        double expected = 0;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    @DisplayName("Konstruktor parameter - nama tersimpan dengan benar")
    void paramConstructor_namaTersimpan() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Budi", 80, 75, 90);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.getNama();

        // (3) verify (assert, check)
        String expected = "Budi";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Konstruktor parameter - nilaiTugas tersimpan dengan benar")
    void paramConstructor_nilaiTugasTersimpan() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Budi", 80, 75, 90);
        double actual;

        // (2) exercise (act, operate)
        actual = sut.getNilaiTugas();

        // (3) verify (assert, check)
        double expected = 80;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    @DisplayName("Konstruktor parameter - nilaiUTS tersimpan dengan benar")
    void paramConstructor_nilaiUTSTersimpan() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Budi", 80, 75, 90);
        double actual;

        // (2) exercise (act, operate)
        actual = sut.getNilaiUTS();

        // (3) verify (assert, check)
        double expected = 75;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    @DisplayName("Konstruktor parameter - nilaiUAS tersimpan dengan benar")
    void paramConstructor_nilaiUASTersimpan() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Budi", 80, 75, 90);
        double actual;

        // (2) exercise (act, operate)
        actual = sut.getNilaiUAS();

        // (3) verify (assert, check)
        double expected = 90;
        assertEquals(expected, actual, 0.001);
    }
}
