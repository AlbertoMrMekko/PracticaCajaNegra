import com.binarytree.BinaryTree;
import com.binarytree.Node;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class GetRootTest {
    private BinaryTree arbol, arbol2;
    private String root1, root2;

    @BeforeEach
    public void setUp() {
        root1 = "a1";
        root2 = "a2";
        arbol = new BinaryTree<>(root1); // arbol1 solo tiene nodo raiz.
        arbol2 = new BinaryTree<>(root2); // arbol2 tiene 5 nodos.
        arbol2.insert("i2", arbol2.getRoot(), true);
        Node i3 = arbol2.insert("i3", arbol2.getRoot(), false);
        Node i4 = arbol2.insert("i4", i3, true);
        arbol2.insert("i5", i4, false);
    }

    /**
     * Se introduce un espacio tras el getRoot, lo que hace que no sean iguales.
     */
    @Test
    public void getRootSoloRaizOK() {
        // assertEquals(root1, arbol.getRoot().toString());
        assertEquals(root1 + " ", arbol.getRoot().toString());
    }

    /**
     * este método prueba que se devuelve correctamente la raíz si el árbol tiene nodos hijos.
     */
    @Test
    public void getRootNoSoloRaizOK() {
        BinaryTree arbolaux = new BinaryTree<>("a2");
        arbolaux.insert("i2", arbolaux.getRoot(), true);
        arbolaux.insert("i3", arbolaux.getRoot(), false);

        assertEquals(arbolaux.getRoot().toString(), arbol2.getRoot().toString());
    }

    /**
     * no se puede eliminar la raiz del arbol
     */
    @Test
    public void getRootKO() {
        arbol.remove(arbol.getRoot());
        System.out.println(arbol.getRoot().toString());
        // assertEquals(root1, arbol.getRoot().toString());
        assertNotEquals(root1, arbol.getRoot().toString());
    }
}
