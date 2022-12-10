import com.binarytree.BinaryTree;
import com.binarytree.Node;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ToListTest {

    private BinaryTree arbol;

    @BeforeEach
    public void setUp() {
        arbol = new BinaryTree<>("b1");
        Node b2 = arbol.insert("b2", arbol.getRoot(), true);
        arbol.insert("b3", b2, true);
        arbol.insert("b4", b2, false);
        arbol.insert("b5", arbol.getRoot(), false);
    }

    /**
     * toList() lista en profundidad en vez de en anchura como se especifica.
     */
    @Test
    public void toListOK() {
        ArrayList<String> array = new ArrayList<>();
        array.add("b1");
        array.add("b2");
        array.add("b3");
        array.add("b4");
        array.add("b5");

        assertEquals(array.toString(), arbol.toList().toString());
    }
}
