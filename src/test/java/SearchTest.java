import com.binarytree.BinaryTree;
import com.binarytree.Node;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {
    private BinaryTree arbol;
    private BinaryTree arbol2;

    @BeforeEach
    public void setUp() {
        arbol = new BinaryTree<>("a1");
        arbol.insert("i2", arbol.getRoot(), true);
        Node i3 = arbol.insert("i3", arbol.getRoot(), false);
        Node i4 = arbol.insert("i4", i3, true);
        arbol.insert("i5", i4, false);

        arbol2 = new BinaryTree<>("a2");
    }

    @Test
    void searchTrueRaizOK() {
        assertEquals(arbol.getRoot(), arbol.search("a1"));
    }

    @Test
    void searchTrueIntermedioOK() {
        assertEquals(arbol.getRoot().getRightChild().getLeftChild(), arbol.search("i4"));
    }

    @Test
    void searchTrueHojaOK() {
        assertEquals(arbol.getRoot().getRightChild().getLeftChild().getRightChild(), arbol.search("i5"));
    }

    @Test
    void searchFalseOK() {
        // vale cualquiera de estas 2.
        assertNotEquals(arbol2.getRoot(), arbol2.search("i0"));
        assertEquals(null, arbol2.search("i0"));
    }


    @Test
    void searchNullKO() {
        // vale cualquiera de estas 2.
        assertNotEquals(arbol2.getRoot(), arbol2.search(null));
        assertEquals(null, arbol2.search(null));
    }
}
