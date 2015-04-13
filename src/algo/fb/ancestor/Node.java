package algo.fb.ancestor;

public class Node {

    char data;
    Node left;
    Node right;
    Node parent;

    public Node(char data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
        left.parent = this;
    }

    public void setRight(Node right) {
        this.right = right;
        right.parent = this;
    }

    static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    static Node search(Node root, Node sought) {
        // TODO: 
        return null;
    }

    static void dfs(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        dfs(root.left);
        dfs(root.right);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Node)) {
            return false;
        }
        Node another = (Node) obj;
        return Character.compare(data, another.data) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        int c = (char) data;
        result = 31 * result + c;
        return result;
    }

}
