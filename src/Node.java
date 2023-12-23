public class Node {
    private UM_Alani data;
    private Node right;
    private Node left;
    public Node(UM_Alani data) {
        this.data = data;
        this.left = this.right = null;
    }
    public UM_Alani getData() {
        return data;
    }

    public void setData(UM_Alani data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    public void copyNode(Node newNode){
        setData(newNode.getData());
        setLeft(newNode.getLeft());
        setRight(newNode.getRight());
    }
}
