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

    @Test (expected = java.lang.AssertionError.class)
    public void testAddHashAddSuccess() {
        MySetList<Integer> mySetList = new MySetList<Integer>(5);
        mySetList.addSuccess(5);
        mySetList.addSuccess(4);
        mySetList.addSuccess(8);
        mySetList.addSuccess(6);
        mySetList.addSuccess(7);

        assertEquals(5, mySetList.getIndexSize());
        assertTrue("No contains the element", mySetList.contains(5));
        assertTrue("No contains the element", mySetList.contains(4));
        assertTrue("No contains the element", mySetList.contains(8));
        assertTrue("No contains the element", mySetList.contains(6));
        assertTrue("No contains the element", mySetList.contains(7));
        assertTrue("No contains the element", mySetList.contains(11));

    }


}
