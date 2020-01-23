package data_structures;

import java.util.ArrayList;

public class MySetList<T> {
    private DoublyCircularLinkedList<T>[] indexList;
    private ArrayList<T> list[];
    static final int INIT_ARRAY_SIZE = 10;
    private int INDEX_SIZE = INIT_ARRAY_SIZE;
    private int indexSize;
    private int LIST_SIZE_LIMIT = 10;


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
        if (null == currentList && currentList.size() < LIST_SIZE_LIMIT ){
            currentList.add(newValue);
        }
        else{
                DoublyCircularLinkedList<T>[] newList = this.rearrangeSet();
                int positionInsert = searchPositionInsert(newList,hashKey);
                newList[positionInsert].add(newValue);
        }
        return true;
    }

    private DoublyCircularLinkedList<T>[] rearrangeSet() {
        this.indexSize = indexList.length*2;
        DoublyCircularLinkedList<T>[] newList= new DoublyCircularLinkedList[this.indexSize];
        initArrayLists(newList);


        for (int i = 0; i < indexList.length; i++) {
            newList[i] = indexList[i];
        }
        return newList;

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
        if (INIT_ARRAY_SIZE < index) {
            throw new ArrayIndexOutOfBoundsException("Error.... index out the range");
        } else {
            return indexList[index];
        }
    }

    public int searchPositionInsert( DoublyCircularLinkedList<T> list[], int position){
        int newPosition = position;
        if (null != list){
            int i =position;
            while (i<list.length){
                if(list[i].size() < LIST_SIZE_LIMIT){
                    newPosition = i;
                    i=list.length;
                }
                i+=10;
            }
        }
        return newPosition;
    }


}
