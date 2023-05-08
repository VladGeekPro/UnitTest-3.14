package tests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CurrencyBinaryTreeTest {

    private CurrencyBinaryTree tree;
    private Currency currency1;
    private Currency currency2;
    private Currency currency3;
    private Currency currency4;

    @Before
    public void setUp() {
        tree = new CurrencyBinaryTree();
        currency1 = new Currency("USD", "EUR", "2023-05-08", 0.82, 1);
        currency2 = new Currency("USD", "JPY", "2023-05-08", 109.12, 2);
        currency3 = new Currency("USD", "GBP", "2023-05-08", 0.72, 3);
        currency4 = new Currency("USD", "AUD", "2023-05-08", 1.31, 4);
        tree.insert(currency1);
        tree.insert(currency2);
        tree.insert(currency3);
        tree.insert(currency4);
    }

    @Test
    public void testInsert() {
        Currency currency5 = new Currency("USD", "CAD", "2023-05-08", 1.21, 5);
        tree.insert(currency5);
        assertEquals(currency5, tree.find(5));
    }

    @Test
    public void testFind() {
        assertEquals(currency2, tree.find(2));
    }

    @Test
    public void testDelete() {
        assertTrue(tree.delete(4));
        assertNull(tree.find(4));
    }

    @Test
    public void testDeleteNotFound() {
        assertFalse(tree.delete(5));
    }
}
