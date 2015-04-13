package algo.fb.ancestor;

public class Main {
    
    public static void main(String[] args) {
        fillTree();
    }

    /**
     * 
     * @return root
     */
    static Node fillTree() {
        Node d = new Node('d');
        Node e = new Node('e');

        Node b = new Node('b');
        b.setLeft(d);
        b.setRight(e);

        Node f = new Node('f');
        Node m = new Node('m');
        f.setRight(m);

        Node g = new Node('g');
        Node n = new Node('n');
        g.setLeft(n);

        Node c = new Node('c');
        c.setLeft(f);
        c.setRight(g);

        Node a = new Node('a');
        a.setLeft(b);
        a.setRight(c);

        Node k = new Node('k');
        d.setLeft(k);

        Node l = new Node('l');
        e.setRight(l);

        // Another tree
        Node h = new Node('h');
        Node j = new Node('j');
        h.setLeft(j);
        return a;
    }

    static Node closestCommonAncestor(Node n1, Node n2) {
        int n1Level = getLevel(n1);
        int n2Level = getLevel(n2);
        int diff = Math.abs(n2Level - n1Level);
        if (n1Level > n2Level) {
            n2 = moveUp(n2, diff);
        } else if (n1Level < n2Level) {
            n1 = moveUp(n1, diff);
        } else {
            while (n1 != null || n2 != null) {
                n1 = n1.parent;
                n2 = n2.parent;
                if (n1.equals(n2)) {
                    return n1;
                }
            }
        }
        return null;
    }

    static Node moveUp(Node src, int levels) {
        Node ancestor = src;
        while (levels != 0) {
            ancestor = src.parent;
            levels--;
        }
        return ancestor;
    }

    static int getLevel(Node node) {
        Node x = node.parent;
        int level = 0;
        while (x != null) {
            x = x.parent;
            level++;
        }
        return level;
    }

}
