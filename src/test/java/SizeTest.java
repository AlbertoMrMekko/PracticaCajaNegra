import com.binarytree.BinaryTree;
import com.binarytree.Node;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SizeTest {

    private BinaryTree arbol;
    private BinaryTree arbol2;
    String root = "i1";

    @BeforeEach
    public void setUp() {
        arbol = new BinaryTree<>(root);
        arbol.insert("i2", arbol.getRoot(), true);
        Node i3 = arbol.insert("i3", arbol.getRoot(), false);
        Node i4 = arbol.insert("i4", i3,true);
        arbol.insert("i5", i4,true);

        arbol2 = new BinaryTree<>(root);

    }

    @Test
    public void arbolSinHijosOK() {
        assertEquals(1,arbol2.size());
    }

    @Test
    public void arbolConHijosOK(){
        assertEquals(5, arbol.size());
    }

}