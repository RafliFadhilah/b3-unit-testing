import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * SetNamaMahasiswaTest.java
 * Unit test untuk method Mahasiswa.setNama().
 *
 * Setiap @Test menguji tepat 1 skenario.
 */
@DisplayName("Mahasiswa.setNama() Tests")
public class SetNamaMahasiswaTest {

    private Mahasiswa sut;

    @BeforeEach
    void setUp() {
        sut = new Mahasiswa();
    }

    @Test
    @DisplayName("Nama null → disimpan sebagai empty string")
    void setKosong_whenNamaNull() {
        // (1) setup (arrange, build)
        String nama = null;
        String actual;

        // (2) exercise (act, operate)
        sut.setNama(nama);
        actual = sut.getNama();

        // (3) verify (assert, check)
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Nama spasi → disimpan sebagai empty string")
    void setKosong_whenNamaSpasi() {
        // (1) setup (arrange, build)
        String nama = "   ";
        String actual;

        // (2) exercise (act, operate)
        sut.setNama(nama);
        actual = sut.getNama();

        // (3) verify (assert, check)
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Nama valid → tersimpan dengan trim")
    void setTrimmed_whenNamaValid() {
        // (1) setup (arrange, build)
        String nama = "  Budi Santoso  ";
        String actual;

        // (2) exercise (act, operate)
        sut.setNama(nama);
        actual = sut.getNama();

        // (3) verify (assert, check)
        String expected = "Budi Santoso";
        assertEquals(expected, actual);
    }
}
