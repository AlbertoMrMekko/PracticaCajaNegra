import com.binarytree.BinaryTree;
import com.binarytree.Node;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ToStringTest {
    private BinaryTree arbol;

    @BeforeEach
    public void setUp(){
        arbol = new BinaryTree<>("a1");
        arbol.insert("i2", arbol.getRoot(), true);
        Node i3 = arbol.insert("i3", arbol.getRoot(), false);
        Node i4 = arbol.insert("i4", i3, true);
        arbol.insert("i5", i4, false);
    }

    @Test
    void toStringOK() {
        assertEquals("a1 Left: i2 Right: i3 \ni2 \ni3 Left: i4 \ni4 Right: i5 \ni5 \n", arbol.toString());
    }
}
