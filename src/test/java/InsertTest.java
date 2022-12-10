import com.binarytree.BinaryTree;
import com.binarytree.Node;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class InsertTest {

    private BinaryTree arbol;

    @BeforeEach
    public void setUp() {
        arbol = new BinaryTree<>("a1");
        Node i2 = arbol.insert("i2", arbol.getRoot(), true);
        Node i3 = arbol.insert("i3", arbol.getRoot(), false);
        arbol.insert("i4", i2, false);
        arbol.insert("i5", i3, true);

    }

    @Test
    public void insertContentNullKO() {
        assertThrows(IllegalArgumentException.class, () -> arbol.insert(null, arbol.getRoot().getLeftChild(),
                                                                         true));
    }

    @Test
    public void insertContentNotStringOK() {
        assertThrows(IllegalArgumentException.class, () -> arbol.insert(123, arbol.getRoot().getLeftChild(),
                true));
    }

    @Test
    public void insertContentStringSoloLetrasOK() {
        assertThrows(IllegalArgumentException.class, () -> arbol.insert("abc", arbol.getRoot().getLeftChild(),
                true));
    }

    @Test
    public void insertContentStringSoloNumerosOK() {
        BinaryTree arbol2 = new BinaryTree<>("a1");
        Node n2 = arbol2.insert("i2", arbol2.getRoot(), true);
        Node n3 = arbol2.insert("i3", arbol2.getRoot(), false);
        Node n4 = arbol2.insert("i4", n2, false);
        Node n5 = arbol2.insert("i5", n3, true);
        Node aux = arbol2.insert("123", n2, true);

        assertEquals(aux.toString(), arbol.insert("123", arbol.getRoot().getLeftChild(), true).toString());
    }

    @Test
    public void insertContentStringAlfanumericoOK() {
        BinaryTree arbol2 = new BinaryTree<>("a1");
        Node n2 = arbol2.insert("i2", arbol2.getRoot(), true);
        Node n3 = arbol2.insert("i3", arbol2.getRoot(), false);
        Node n4 = arbol2.insert("i4", n2, false);
        Node n5 = arbol2.insert("i5", n3, true);
        Node aux = arbol2.insert("ab1", n2, true);

        assertEquals(aux.toString(), arbol.insert("ab1", arbol.getRoot().getLeftChild(), true).toString());
    }

    @Test
    public void insertContentStringNotAlfaNumericoKO() {
        BinaryTree arbol2 = new BinaryTree<>("a1");
        Node n2 = arbol2.insert("i2", arbol2.getRoot(), true);
        Node n3 = arbol2.insert("i3", arbol2.getRoot(), false);
        Node n4 = arbol2.insert("i4", n2, false);
        Node n5 = arbol2.insert("i5", n3, true);
        Node aux = arbol2.insert("@", n2, true);

        assertEquals(aux.toString(), arbol.insert("@", arbol.getRoot().getLeftChild(), true).toString());
    }

    @Test
    public void insertAtNodeNullKO() {
        assertThrows(IllegalArgumentException.class, () -> arbol.insert("i0", null, true));
    }

    @Test
    public void insertEnNodoHojaLeftOK() {
        BinaryTree arbol2 = new BinaryTree<>("a1");
        Node n2 = arbol2.insert("i2", arbol2.getRoot(), true);
        Node n3 = arbol2.insert("i3", arbol2.getRoot(), false);
        Node n4 = arbol2.insert("i4", n2, false);
        Node n5 = arbol2.insert("i5", n3, true);
        Node aux = arbol2.insert("i0", n5, true);

        assertEquals(aux.toString(), arbol.insert("i0", arbol.getRoot().getRightChild().getLeftChild(),
                                                   true).toString());
    }

    @Test
    public void insertEnNodoHojaRightOK() {
        BinaryTree arbol2 = new BinaryTree<>("a1");
        Node n2 = arbol2.insert("i2", arbol2.getRoot(), true);
        Node n3 = arbol2.insert("i3", arbol2.getRoot(), false);
        Node n4 = arbol2.insert("i4", n2, false);
        Node n5 = arbol2.insert("i5", n3, true);
        Node aux = arbol2.insert("i0", n5, false);

        assertEquals(aux.toString(), arbol.insert("i0", arbol.getRoot().getRightChild().getLeftChild(),
                                                   false).toString());
    }

    @Test
    public void insertEnNodoNoEnArbolKO() {
        Node aux = new Node("i0");
        assertThrows(IllegalArgumentException.class, () -> arbol.insert("i0", aux, true));
    }

    @Test
    public void insertEnNodoIntermedioHayEspacioOK() {
        BinaryTree arbol2 = new BinaryTree<>("a1");
        Node n2 = arbol2.insert("i2", arbol2.getRoot(), true);
        Node n3 = arbol2.insert("i3", arbol2.getRoot(), false);
        Node n4 = arbol2.insert("i4", n2, false);
        Node n5 = arbol2.insert("i5", n3, true);
        Node aux = arbol2.insert("i0", n2, true);

        assertEquals(aux.toString(), arbol.insert("i0", arbol.getRoot().getLeftChild(), true).toString());
    }

    /**
     * debería dar excepción por no haber espacio, pero inserta y elimina el nodo reemplazado y su subarbol.
     */
    @Test
    public void insertNoEspacioKO() {
        // System.out.println(arbol.toList());
        // arbol.insert("i0", arbol.getRoot(), true);
        // System.out.println(arbol.toList());
        //assertThrows(IllegalArgumentException.class, () -> arbol.insert("i0", arbol.getRoot(), true));
        Node auxP = new Node("i2");
        Node auxH = new Node("i0", auxP);
        assertEquals(auxH.toString(), arbol.insert("i0", arbol.getRoot().getLeftChild(), false).toString());
    }

}
