package data_structures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertEquals;


public class MyLinkedListTest {
    @Test
    public void verifySize() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("Rojo");
        myLinkedList.add("Amarillo");
        myLinkedList.add("Azul");
        myLinkedList.add("Verde");
        myLinkedList.add("Blanco");
        assertEquals(5, myLinkedList.size());

    }

    @Test
    public void verifyAddNode() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("Rojo");
        myLinkedList.add("Amarillo");
        myLinkedList.add("Azul");
        myLinkedList.add("Verde");
        myLinkedList.add("Blanco");
        assertEquals("Rojo", myLinkedList.get(0));
        assertEquals("Amarillo", myLinkedList.get(1));
        assertEquals("Azul", myLinkedList.get(2));
        assertEquals("Verde", myLinkedList.get(3));
        assertEquals("Blanco", myLinkedList.get(4));

    }
    @Test
    public void verifyDeleteNode() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add("Rojo");
        myLinkedList.add("Amarillo");
        myLinkedList.add("Azul");
        myLinkedList.add("Verde");
        myLinkedList.add("Blanco");
        assertEquals("Rojo", myLinkedList.remove(0));
        assertEquals("Amarillo", myLinkedList.get(1));
        assertEquals("Azul", myLinkedList.get(2));
        assertEquals("Verde", myLinkedList.get(3));
        assertEquals("Blanco", myLinkedList.get(4));

    }

}
