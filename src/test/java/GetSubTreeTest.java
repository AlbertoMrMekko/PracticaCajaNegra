import com.binarytree.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetSubTreeTest {

    private BinaryTree arbol;
    String root = "a1";

    @BeforeEach
    public void setUp() {
        arbol = new BinaryTree<>(root);
        arbol.insert("i2", arbol.getRoot(), true);
        Node i3 = arbol.insert("i3", arbol.getRoot(), false);
        Node i4 = arbol.insert("i4", i3, true);
        Node i5 = arbol.insert("i5", i4, false);
    }

    @Test
    public void getSubTreeRaizOK() {
        BinaryTree arbol2 = new BinaryTree<>(root);
        arbol2.insert("i2", arbol2.getRoot(), true);
        Node i3 = arbol2.insert("i3", arbol2.getRoot(), false);
        Node i4 = arbol2.insert("i4", i3, true);
        arbol2.insert("i5", i4, false);

        assertEquals(arbol2.toList(), arbol.getSubTree(arbol2.getRoot()).toList());
    }

    @Test
    public void getSubTreeIntermedioOK() {
        BinaryTree arbol2 = new BinaryTree<>("i3");
        Node i4 = arbol2.insert("i4", arbol2.getRoot(),true);
        arbol2.insert("i5", i4,false);

        assertEquals(arbol2.toList(), arbol.getSubTree(arbol.getRoot().getRightChild()).toList());
    }

    @Test
    public void getSubTreeHojaOK() {
        BinaryTree arbol2 = new BinaryTree("i5");

        assertEquals(arbol2.toList(), arbol.getSubTree(arbol.getRoot().getRightChild().getLeftChild().getRightChild()).toList());
    }

    @Test
    public void getSubTreeNullKO(){
        assertThrows(IllegalArgumentException.class, () -> arbol.getSubTree(null), "Node cannot be null");
    }

    @Test
    public void getSubTreeNodeNoEstaKO(){
        Node node1 = new Node("node1");
        assertThrows(IllegalArgumentException.class, () -> arbol.getSubTree(node1), "No existe el nodo");
    }

}
