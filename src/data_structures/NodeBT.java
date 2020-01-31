package data_structures;

public class NodeBT {

    private NodeBT right;
    private NodeBT left;
    private int dato;

    public NodeBT(int value) {
        this.dato = value;
    }

    public NodeBT getLeft() {
        return left;
    }

    public void setLeft(NodeBT left) {
        this.left = left;
    }

    public NodeBT getRight() {
        return right;
    }

    public void setRight(NodeBT right) {
        this.right = right;
    }

    public int getValue() {
        return dato;
    }

    public void setValue(int value) {
        this.dato = value;
    }
}
