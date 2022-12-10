import com.binarytree.BinaryTree;
import com.binarytree.Node;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DepthTest {
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
    public void depthSoloRaizOK() {
        assertEquals(0, arbol.depth());
    }

    @Test
    public void depthConHijosOK() {
        assertEquals(3, arbol2.depth());
    }

    /**
     * No es posible eliminar el nodo raiz del arbol.
     */
    @Test
    public void depthSinRaizOK() {
        arbol.remove(arbol.getRoot());
        System.out.println(arbol.getRoot().getContent());
        arbol.insert("i2", arbol.getRoot(), true);
        assertEquals(1, arbol.depth());
    }
}
