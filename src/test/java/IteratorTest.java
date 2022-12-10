import com.binarytree.BinaryTree;
import com.binarytree.Node;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class IteratorTest {

    private BinaryTree arbol;

    @BeforeEach
    public void setUp() {
        arbol = new BinaryTree<>("a1");
        Node i2 = arbol.insert("i2", arbol.getRoot(), true);
        Node i3 = arbol.insert("i3", arbol.getRoot(), false);
        Node i4 = arbol.insert("i4", i3, true);
        arbol.insert("i5", i4, false);
        arbol.insert("i6", i2, true);
    }

    /**
     * iterator() itera en profundidad en vez de en anchura como se especifica.
     */

    @Test
    public void IteratorTest() {
        Iterator<String> iterador = arbol.iterator();

        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }
    }
}
