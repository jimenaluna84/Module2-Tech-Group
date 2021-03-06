package data_structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<T> implements List<T> {

    private Node first;
    private Node last;
    private Integer size;

    public MyLinkedList() {
        this.size = 0;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }


    public MyLinkedList<String> insert(MyLinkedList list, String data) {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.setNext(null);

        // If the Linked List is empty,
        // then make the new node as head
        if (list.first == null) {
            list.first = new_node;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.first;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            // Insert the new_node at last node
            last.setNext(new_node);
        }

        // Return the list by head
        return list;
    }


    // Method to print the LinkedList.
    public static void printList(MyLinkedList list) {
        Node currNode = list.first;

        System.out.print("MyLinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.getValue() + " ");

            // Go to next node
            currNode = currNode.getNext();
        }

        System.out.println();
    }


    public static MyLinkedList deleteByKey(MyLinkedList list, String key) {
        // Store head node
        Node currNode = list.first, prev = null;

        //
        // CASE 1:
        // If head node itself holds the key to be deleted

        if (currNode != null && currNode.getValue() == key) {
            list.first = currNode.getNext(); // Changed head

            // Display the message
            System.out.println(key + " found and deleted");

            // Return the updated List
            return list;
        }

        //
        // CASE 2:
        // If the key is somewhere other than at head
        //

        // Search for the key to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null && currNode.getValue() != key) {
            // If currNode does not hold key
            // continue to next node
            prev = currNode;
            currNode = currNode.getNext();
        }

        // If the key was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.setNext(currNode.getNext());

            // Display the message
            System.out.println(key + " found and deleted");
        }

        //
        // CASE 3: The key is not present
        //

        // If key was not present in linked list
        // currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(key + " not found");
        }

        // return the List
        return list;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(T valueNode) {

        Node node = new Node(valueNode);
        if (first == null) {
            first = node;
            last = node;
            size++;
            return true;
        } else {
            this.last.setNext(node);
            last = node;
            size++;
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
//        ExtendedLinkedList<Integer> list = new ExtendedLinkedList();
//        int index = 0;
//        while (index < list.size()) {
//            Integer eLL = list.get(index);
//            if (eLL.equals(x)) {
//                list.removeAll((Integer) x);
//            } else {
//                index++;
//            }
//
//
//        }

        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

//    @Override
//    public void clearML() {
//
//        Node previus = first;
//        Node store;
//
//        while (previus != null) {
//            store = previus.getNext();
//            previus = null;
//            previus = store;
//        }
//
//
//    }

    @Override
    public void clear() {

        // Clearing all of the links between nodes is "unnecessary", but:
        // - helps a generational GC if the discarded nodes inhabit
        //   more than one generation
        // - is sure to free memory even if there is a reachable Iterator

        for (Node x = first; x != null; ) {
            Node next = x.getNext();
            x.setValue(null);
            x.setNext(null);
            x.setPrevius(null);
            x = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public T get(int index) {

        Node<T> current = first;

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();

    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }


}
