import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    @Test
    void everyBranchTest() {
        // Exception case
        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.function(null, new ArrayList<>()));
        assertEquals("Mandatory information missing!", exception.getMessage());

        // Short password
        assertFalse(SILab2.function(new User(null, "", "test"), new ArrayList<>()));

        // allUsers generation (with 2 elements)
        ArrayList<User> arr = new ArrayList<>();
        arr.add(new User("Nikola", "zdravoKakoSi", "test@test.com"));
        arr.add(new User("", "", ""));

        // Special character & No Space
        assertFalse(SILab2.function(new User("Nikola", "zdravoStefan>", "test@test.com"), arr));

        // No special character & No Space
        assertFalse(SILab2.function(new User("Nikola", "zdravoStefan", "test@test.com"), arr));

        // No special character & Space
        assertFalse(SILab2.function(new User("Nikola", "zdravo Stefan", "test@test.com"), arr));
    }

    @Test
    void multipleConditionTest() {
        // True X X <=> True
        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.function(null, new ArrayList<>()));
        assertEquals("Mandatory information missing!", exception.getMessage());

        // False True X <=> True
        exception = assertThrows(RuntimeException.class, () -> SILab2.function(new User(null, null, null), new ArrayList<>()));
        assertEquals("Mandatory information missing!", exception.getMessage());

        // False False True <=> True
        exception = assertThrows(RuntimeException.class, () -> SILab2.function(new User(null, "lele", null), new ArrayList<>()));
        assertEquals("Mandatory information missing!", exception.getMessage());

        // False False False <=> False
        assertDoesNotThrow(() -> SILab2.function(new User(null, "LELE", "Hello"), new ArrayList<>()));
        assertFalse(SILab2.function(new User(null, "LELE", "Hello"), new ArrayList<>()));
    }
}
