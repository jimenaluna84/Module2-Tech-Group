package data_structures;

import java.util.ArrayList;

public class MySetList<T> {
    private DoublyCircularLinkedList<T>[] indexList;
    private ArrayList<T> list[];
    static final int INIT_ARRAY_SIZE = 10;
    private int INDEX_SIZE = INIT_ARRAY_SIZE;
    private int indexSize;
    private int LIST_SIZE_LIMIT;


// Constructors

    public MySetList() {
        this.init(INIT_ARRAY_SIZE);
    }

    public MySetList(int initArrayList) {
        this.init(initArrayList);
    }

    // Created  Array of the DoubleCircular List  here initialize
    private void init(int indexSize) {
        this.indexSize = indexSize;
        this.indexList = new DoublyCircularLinkedList[this.INIT_ARRAY_SIZE];
        initArrayLists(indexList);
    }

    private void initArrayLists(DoublyCircularLinkedList<T>[] indexList) {


    }

    public boolean add(String newValue) {
        return add(indexList, (T) newValue);

    }

    private boolean add(DoublyCircularLinkedList<T>[] indexList, T newValue) {
        int hashKey = this.getHashCode(newValue) % this.indexList.length;   // indexSize
        if (this.contains(newValue, hashKey)) {
            return false;
        }

        DoublyCircularLinkedList<T> currentList = this.indexList[hashKey];
        currentList.add(newValue);
        if (currentList.size() > LIST_SIZE_LIMIT) {
            this.rearrangeSet();
        }
        return true;
    }

    private void rearrangeSet() {
        this.indexSize *= 2;
        DoublyCircularLinkedList<T>[] newIndex = new DoublyCircularLinkedList[this.indexSize];
        initArrayLists((newIndex));
        for (int i = 0; i < indexSize; i++) {


        }
    }

    private int getHashCode(T value) {
        if (value instanceof String) {
            return value.toString().length();
        }
        return value.hashCode();
    }


    public boolean contains(T newValue) {
        int hashKey = this.getHashCode(newValue) % this.getIndexSize();
        return contains(newValue, hashKey);
    }

    private boolean contains(T newValue, int hashKey) {
        DoublyCircularLinkedList<T> currentList = indexList[hashKey];

        if (currentList == null) {
            return false;

        } else {

            if (currentList.contains(newValue)) {
                return true;
            }

        }


    }

    public void print(Object o) {
        System.out.print(o + " ");
    }


    public int getIndexSize() {
        return this.INIT_ARRAY_SIZE;
    }


    public DoublyCircularLinkedList<T> get(int index) {
        if (INIT_ARRAY_SIZE < index) {
            throw new ArrayIndexOutOfBoundsException("Error.... index out the range");
        } else {
            return indexList[index];
        }
    }


}
