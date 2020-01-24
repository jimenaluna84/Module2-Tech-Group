package data_structures;

import java.util.ArrayList;

public class MySetList<T> {
    private DoublyCircularLinkedList<T>[] indexList;
    private ArrayList<T> list[];
    static final int INIT_ARRAY_SIZE = 10;
    private int INDEX_SIZE = INIT_ARRAY_SIZE;
    private int indexSize;
    private int LIST_SIZE_LIMIT = 3;


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
        for (int i=0;i<indexList.length;i++) {
            indexList[i] = new DoublyCircularLinkedList<>();
        }
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
        if (null == currentList || currentList.size() < LIST_SIZE_LIMIT) {
            currentList.add(newValue);
        } else {
            DoublyCircularLinkedList<T>[] newArray = this.rearrangeSet();
            int positionInsert = searchPositionInsert(newArray, hashKey);
            newArray[positionInsert].add(newValue);
            this.indexList = newArray;
        }
        return true;
    }

    private DoublyCircularLinkedList<T>[] rearrangeSet() {
        this.indexSize = indexList.length * 2;
        DoublyCircularLinkedList<T>[] newArrayList = new DoublyCircularLinkedList[this.indexSize];
        initArrayLists(newArrayList);


        for (int i = 0; i < indexList.length; i++) {
            newArrayList[i] = indexList[i];
        }
        return newArrayList;

    }

    private int getHashCode(T value) {
        if (value instanceof String) {
            return value.toString().length();
        }
        return value.hashCode();
    }


    public boolean contains(DoublyCircularLinkedList<T> list, T newValue) {
        int hashKey = this.getHashCode(newValue) % this.getIndexSize();
        return contains(newValue, hashKey);
    }

    private boolean contains(T newValue, int hashKey) {
        DoublyCircularLinkedList<T> currentList = indexList[hashKey];
        boolean containsValue = false;
        if (null != currentList) {
//            return false;
//        } else {

            if (currentList.contains(newValue)) {
                containsValue =  true;
            }

        }
        return containsValue;

    }

    public void print(Object o) {
        System.out.print(o + " ");
    }


    public int getIndexSize() {
        return this.INIT_ARRAY_SIZE;
    }


    public DoublyCircularLinkedList<T> get(int index) {
        if (indexList.length < index) {
            throw new ArrayIndexOutOfBoundsException("Error.... index out the range");
        } else {
            return this.indexList[index];
        }
    }

    public int searchPositionInsert(DoublyCircularLinkedList<T> newArrayList[], int position) {
        int newPosition = position;
        if (null != newArrayList) {
            int i = position;
            while (i < newArrayList.length) {
                if (newArrayList[i].size() < LIST_SIZE_LIMIT) {
                    newPosition = i;
                    i = newArrayList.length;
                }
                i += 10;
            }
        }
        return newPosition;
    }


}
