package data_structures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyLinkedListTest {
    @Test
    public void checkSize() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("Maria");
        myLinkedList.add("Carlos");
        myLinkedList.add("Mario");
        myLinkedList.add("    ");
        myLinkedList.add(null);

        assertEquals(5, myLinkedList.size());
    }

    @Test
    public void checkGetValueIndex() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("Maria");
        myLinkedList.add("Carlos");
        myLinkedList.add("Mario");
        myLinkedList.add("    ");
        myLinkedList.add(null);

        assertEquals("Maria", myLinkedList.get(0));
        assertEquals("Carlos", myLinkedList.get(1));
        assertEquals("Mario", myLinkedList.get(2));
    }

    @Test
    public void checkClearNodes() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("Maria");
        myLinkedList.add("Carlos");
        myLinkedList.add("Mario");
        myLinkedList.add("Mario");
        myLinkedList.add("Mario");
        myLinkedList.clear();
    }

}
