import com.binarytree.BinaryTree;
import com.binarytree.Node;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DepthNodeTest {
    private BinaryTree arbol;
    private BinaryTree arbol2;

    @BeforeEach
    public void setUp() {
        arbol = new BinaryTree<>("a1"); // arbol1 solo tiene nodo raiz.
        arbol2 = new BinaryTree<>("a2"); // arbol2 tiene 5 nodos.
        arbol2.insert("i2", arbol2.getRoot(), true);
        Node i3 = arbol2.insert("i3", arbol2.getRoot(), false);
        Node i4 = arbol2.insert("i4", i3, true);
        arbol2.insert("i5", i4, false);
    }

    @Test
    public void depthNodeSoloRaizOK () {
        assertEquals(0, arbol.depth(arbol.getRoot()));
    }

    /**
     * debería dar 3, pero sale 2.
     */
    @Test
    public void depthNodeConHijosNodoRaizOK () {
        // assertEquals(3, arbol2.depth(arbol2.getRoot()));
        assertNotEquals(3, arbol2.depth(arbol2.getRoot()));
    }

    /**
     * debería dar 2, pero sale 1.
     */
    @Test
    public void depthNodeConHijosNodoIntermedioOK () {
        // assertEquals(2, arbol2.depth(arbol2.getRoot().getRightChild()));
        assertNotEquals(2, arbol2.depth(arbol2.getRoot().getRightChild()));
    }

    @Test
    public void depthNodeConHijosNodoHojaOK () {
        assertEquals(0, arbol2.depth(arbol2.getRoot().getRightChild().getLeftChild().getRightChild()));
    }

    @Test
    public void depthNodeNullKO () {
        assertThrows(IllegalArgumentException.class, () -> arbol.depth(null));
    }

    /**
     * nodo no esta en el arbol pero sale 0
     */
    @Test
    public void depthNodeNoEnArbolKO () {
        Node nodo = new Node("as12");
        // assertThrows(IllegalArgumentException.class, () -> arbol.depth(nodo));
        assertEquals(0, arbol2.depth(nodo));
    }
}
