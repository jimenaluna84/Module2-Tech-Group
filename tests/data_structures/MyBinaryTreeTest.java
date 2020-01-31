package data_structures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyBinaryTreeTest {
    @Test
    public void testAdd() {
        MyBinaryTree myTree = new MyBinaryTree();

        myTree.add(8);
        myTree.add(10);
        myTree.add(6);
        myTree.add(2);
        myTree.add(5);
        myTree.add(7);
        myTree.add(9);
        myTree.add(3);

//        assertEquals(3, myTree.getLevel());
        assertEquals(8, myTree.size());
    }

    @Test
    public void testToString() {
        MyBinaryTree myTree = new MyBinaryTree();

        myTree.add(8);
        myTree.add(6);
        myTree.add(10);
        myTree.add(9);
        myTree.add(3);
        myTree.add(7);
        myTree.add(2);
        myTree.add(4);

        assertEquals("[234678910]", myTree.toString());
    }


    @Test
    public void Contains() {
        MyBinaryTree myTree = new MyBinaryTree();

        myTree.add(8);
        myTree.add(10);
        myTree.add(6);
        myTree.add(2);
        myTree.add(5);
        myTree.add(7);
        myTree.add(9);
        myTree.add(3);

        assertTrue(myTree.contains(8));
        assertTrue(myTree.contains(10));
        assertTrue(myTree.contains(6));
        assertTrue(myTree.contains(2));
        assertTrue(myTree.contains(5));
        assertTrue(myTree.contains(7));
        assertTrue(myTree.contains(9));
        assertTrue(myTree.contains(3));
    }

    @Test
    public void printNodes() {
        MyBinaryTree myTree = new MyBinaryTree();

        myTree.add(8);
        myTree.add(6);
        myTree.add(10);
        myTree.add(9);
        myTree.add(3);
        myTree.add(7);
        myTree.add(2);
        myTree.add(4);



        assertEquals("[2,3,4,6,7,8,9,10]", myTree.printString());

    }
}
