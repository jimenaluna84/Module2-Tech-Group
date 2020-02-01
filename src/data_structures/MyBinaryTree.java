package data_structures;


public class MyBinaryTree {
    private NodeBT root;
    private int level;
    private int size;


    public MyBinaryTree() {

    }

    public boolean add(int value) {
        NodeBT newNode = new NodeBT(value);
        boolean result;
        if (root == null) {
            root = newNode;
            this.size++;
            result = true;
        } else {
            result = add(root, newNode);
            if (result) {
                this.size++;
            }
        }
        return result;
    }

    private boolean add(NodeBT cursor, NodeBT newNode) {
        boolean result = false;
        if (newNode.getValue() > cursor.getValue()) {
            if (cursor.getRight() == null) {
                cursor.setRight(newNode);
                result = true;
            } else {
                return add(cursor.getRight(), newNode);
            }
        } else if (newNode.getValue() < cursor.getValue()) {
            if (cursor.getLeft() == null) {
                cursor.setLeft(newNode);
                result = true;
            } else {
                return add(cursor.getLeft(), newNode);
            }
        }
        return result;
    }

    public int getLevel() {
        return level;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        visit(root, builder);

        builder.append("]");
        return builder.toString();
    }

    private void visit(NodeBT cursor, StringBuilder builder) {
        if (cursor == null) return;

        visit(cursor.getLeft(), builder);
        builder.append(cursor.getValue());
        visit(cursor.getRight(), builder);
    }

    public boolean contains(int value) {
        if (this.root == null) {
            return false;
        }
        return contains(this.root, value);
    }

    private boolean contains(NodeBT current, int value) {

        if (current == null) {
            return false;
        }
        if (value == current.getValue()) {
            return true;
        }
        return value < current.getValue()
                ? contains(current.getLeft(), value)
                : contains(current.getRight(), value);

    }

    private String toStringTest(NodeBT root) {
        String result = "";
        if (root == null)
            return "";



        result += toStringTest(root.getLeft());

        result += root.getValue()+",";

        result += toStringTest(root.getRight());



        return result;
    }

    public String printString() {
        String data = toStringTest(root);
        data = data.substring(0, data.length() - 1);
        return "[" + data + "]";
    }

}

