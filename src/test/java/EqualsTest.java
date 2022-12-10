import com.binarytree.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class EqualsTest {

    private BinaryTree arbol;
    String root = "i1";
    String root2 = "a1";

    @BeforeEach
    public void setUp() {
        arbol = new BinaryTree<>(root);
        arbol.insert("i2", arbol.getRoot(), true);
        Node i3 = arbol.insert("i3", arbol.getRoot(), false);
        Node i4 = arbol.insert("i4", i3, true);
        Node i5 = arbol.insert("i5", i4, false);
    }

    @Test
    public void equalsArbolIgualTreeOK(){
        BinaryTree arbol2 = new BinaryTree<>(root);
        arbol2.insert("i2", arbol2.getRoot(), true);
        Node i3 = arbol2.insert("i3", arbol2.getRoot(), false);
        Node i4 = arbol2.insert("i4", i3, true);
        Node i5 = arbol2.insert("i5", i4, false);

        assertTrue(arbol.equals(arbol2));
    }

    @Test
    public void equalsArbolIgualSubtreeOK(){
        BinaryTree arbol2 = new BinaryTree<>(root);
        arbol2.insert("i2", arbol2.getRoot(), true);
        Node i3 = arbol2.insert("i3", arbol2.getRoot(), false);
        //Node i4 = binaryTree2.insert("i4", i3, true);
        //Node i5 = binaryTree2.insert("i5", i4, false);

        assertTrue(arbol.equals(arbol2));
    }

    /**
     * Solo compara los nodos raiz de los árboles, si son iguales da true, si no da false.
     */
    @Test
    public void equalsArbolNoIgualTreeOK(){
        BinaryTree arbol2 = new BinaryTree<>(root);
        arbol2.insert("i2", arbol2.getRoot(), true);

        BinaryTree arbol3 = new BinaryTree<>(root);
        arbol3.insert("i3", arbol3.getRoot(), true);

        assertFalse(arbol2.equals(arbol3));

        /*
        // Esto sale False porque solo compara las raíces. Si las raíces son iguales y el resto no, da true.

        BinaryTree arbol2 = new BinaryTree<>(root);
        BinaryTree arbol3 = new BinaryTree<>(root2);
        assertFalse(arbol2.equals(arbol3));
         */
    }

    @Test
    public void equalsArbolIgualNullKO(){
        assertThrows(NullPointerException.class, () -> arbol.equals(null));
    }


}
