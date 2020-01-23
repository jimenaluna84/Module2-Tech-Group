package data_structures;

import org.junit.Test;

import static org.junit.Assert.*;

public class MySetListTest {
    @Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
    public void testHashSetGetNonExistingIndex() {
        MySetList<Integer> mySetList = new MySetList<Integer>(5);
        assertEquals(5, mySetList.getIndexSize());
        DoublyCircularLinkedList data = mySetList.get(3);
        mySetList.get(5);
    }

    @Test
    public void testAddHashAddSuccess() {
        MySetList<Integer> mySetList = new MySetList();
        mySetList.add ("Maria");
        mySetList.add("Tesoro");

        assertTrue("No contains the element", mySetList.contains(5));
        assertTrue("No contains the element", mySetList.contains(6));
        assertTrue("No contains the element", mySetList.contains(16));

    }


}
