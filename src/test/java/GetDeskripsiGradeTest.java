import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * GetDeskripsiGradeTest.java
 * Unit test untuk method Mahasiswa.getDeskripsiGrade().
 *
 * Setiap @Test menguji tepat 1 skenario.
 */
@DisplayName("Mahasiswa.getDeskripsiGrade() Tests")
public class GetDeskripsiGradeTest {

    private Mahasiswa sut;

    @BeforeEach
    void setUp() {
        sut = new Mahasiswa();
    }

    @Test
    @DisplayName("Grade A → Sangat Memuaskan")
    void returnSangatMemuaskan_whenGradeA() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 90, 90, 90);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.getDeskripsiGrade();

        // (3) verify (assert, check)
        String expected = "Sangat Memuaskan";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Grade B → Memuaskan")
    void returnMemuaskan_whenGradeB() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 75, 75, 75);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.getDeskripsiGrade();

        // (3) verify (assert, check)
        String expected = "Memuaskan";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Grade C → Cukup")
    void returnCukup_whenGradeC() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 65, 65, 65);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.getDeskripsiGrade();

        // (3) verify (assert, check)
        String expected = "Cukup";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Grade D → Kurang")
    void returnKurang_whenGradeD() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 55, 55, 55);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.getDeskripsiGrade();

        // (3) verify (assert, check)
        String expected = "Kurang";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Grade E → Sangat Kurang")
    void returnSangatKurang_whenGradeE() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 30, 30, 30);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.getDeskripsiGrade();

        // (3) verify (assert, check)
        String expected = "Sangat Kurang";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Grade INVALID → Grade tidak diketahui (nilai negatif)")
    void returnTidakDiketahui_whenNegatif() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", -1, 75, 80);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.getDeskripsiGrade();

        // (3) verify (assert, check)
        String expected = "Grade tidak diketahui";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Grade INVALID → Grade tidak diketahui (semua 0)")
    void returnTidakDiketahui_whenSemuaNol() {
        // (1) setup (arrange, build)
        sut = new Mahasiswa("Test", 0, 0, 0);
        String actual;

        // (2) exercise (act, operate)
        actual = sut.getDeskripsiGrade();

        // (3) verify (assert, check)
        String expected = "Grade tidak diketahui";
        assertEquals(expected, actual);
    }
}
