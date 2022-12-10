import com.binarytree.BinaryTree;
import com.binarytree.Node;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RemoveTest {

    private BinaryTree arbol;
    String root = "i1";

    @BeforeEach
    public void setUp() {
        arbol = new BinaryTree<>(root);
        arbol.insert("i2", arbol.getRoot(), true);
        Node i3 = arbol.insert("i3", arbol.getRoot(), false);
        Node i4 = arbol.insert("i4", arbol.getRoot().getRightChild(), true);
    }

    @Test
    public void removeHojaOK() {
        BinaryTree arbol2 = new BinaryTree<>(root);
        arbol2.insert("i2", arbol2.getRoot(), true);
        Node n3 = arbol2.insert("i3", arbol2.getRoot(), false);
        Node n4 = arbol2.insert("i4", n3, true);
        Node n5 = arbol2.insert("i5", n4, false);

        arbol2.remove(n5);

        assertEquals(arbol2.toList(), arbol.toList());
    }

    /**
     * No deja eliminar nodos que no sean nodos hoja.
     * Si eliminase primero i4, luego si deja eliminar i3, solo en ese orden.
     */
    @Test
    public void removeIntermedioKO() {
        assertThrows(IllegalArgumentException.class, () -> arbol.remove(arbol.getRoot().getRightChild()));
    }

    @Test
    public void removeNodeNoEstaArbolKO(){
        Node aux = new Node<>("n0");
        assertThrows(IllegalArgumentException.class, () -> arbol.remove(aux));
    }

    @Test
    public void removeNodeNullKO(){
        assertThrows(IllegalArgumentException.class, () -> arbol.remove(null));
    }

}
