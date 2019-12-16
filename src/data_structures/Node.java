package data_structures;

public class Node<E> {


    private Node previus;
    private Node next;
    private E value;

    public Node(E value) {
        this.value = value;
        this.next = null;
        this.previus = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }


    public Node getPrevius() {
        return previus;
    }

    public void setPrevius(Node previus) {
        this.previus = previus;
    }
}
