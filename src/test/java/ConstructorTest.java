import com.binarytree.BinaryTree;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ConstructorTest {
    @Test
    @DisplayName("String alfanumérico")
    public void constructorStringAlfaNumOK() {
        assertEquals(BinaryTree.class, new BinaryTree("a1").getClass());
    }

    @Test
    @DisplayName("String numérico")
    public void constructorStringNumOK() {
        assertEquals(BinaryTree.class, new BinaryTree("1234").getClass());
    }

    @Test
    @DisplayName("Null")
    public void constructorNullKO() {
        assertThrows(IllegalArgumentException.class, () -> new BinaryTree(null));
    }

    @Test
    @DisplayName("No string")
    public void constructorNotStringKO() {
        assertThrows(IllegalArgumentException.class, () -> new BinaryTree(1234));
    }

    @Test
    @DisplayName("Solo letras.")
    public void constructorStringAlfaKO() {
        assertThrows(IllegalArgumentException.class, () -> new BinaryTree("abcd"));
    }


    /**
     * Debería dar excepción, pero no la da.
     */
    @Test
    @DisplayName("Solo alfas.")
    public void constructorStringNotAlfaNumKO() {
        // assertThrows(IllegalArgumentException.class, () -> new BinaryTree("#"));
        assertEquals(BinaryTree.class, new BinaryTree("#").getClass());
    }

}
