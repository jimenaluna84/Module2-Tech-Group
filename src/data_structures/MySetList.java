package data_structures;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;

public class MySetList<T> {
    private DoublyCircularLinkedList<T>[] indexList ;
    private ArrayList<T> list [];
    private int size;

    public MySetList(int size){
        this.size = size;
        indexList = new DoublyCircularLinkedList[this.size];
        fillVoidList(size);
    }

    private void fillVoidList ( int size){
        for (int i=0;i<size;i++ ){
            this.indexList[i] = new DoublyCircularLinkedList<>();
        }
    }

    public int getIndexSize(){
        return this.size;
    }

    public DoublyCircularLinkedList<T> get(int index){
        if (size < index){
            throw new ArrayIndexOutOfBoundsException("Error.... index out the range");
        }else{
            return indexList[index];
        }
    }

    public void addSuccess( Integer data){
        if (null != indexList){
            int i= 0;
            while (i< size){
                if(indexList[i].size() == 0){
                    indexList[i].add((T) data);
                    i= size;
                }
                i++;
            }
        }
    }


    public boolean contains(T data) {
        boolean hasData = false;
        if (null != indexList){
            int i= 0 ;
            while (i < size){
                if(indexList[i].contains(data) ){
                    hasData = true;
                    i= size;
                }
                i++;
            }
        }
        return hasData;
    }
}
