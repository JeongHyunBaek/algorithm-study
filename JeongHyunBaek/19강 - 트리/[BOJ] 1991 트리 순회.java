import java.util.*;

class Node {
    private String root;
    private String left;
    private String right;

    Node(String root, String left, String right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }

    public String getRoot() {
        return root;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }
}

class Main {
    private static Map<String, Node> map;

    public static void preOrder(Node node) {
        System.out.print(node.getRoot());

        if (!".".equals(node.getLeft())) {
            preOrder(map.get(node.getLeft()));
        }

        if (!".".equals(node.getRight())) {
            preOrder(map.get(node.getRight()));
        }
    }

    public static void inOrder(Node node) {
        if (!".".equals(node.getLeft())) {
            inOrder(map.get(node.getLeft()));
        }

        System.out.print(node.getRoot());

        if (!".".equals(node.getRight())) {
            inOrder(map.get(node.getRight()));
        }
    }

    public static void postOrder(Node node) {
        if (!".".equals(node.getLeft())) {
            postOrder(map.get(node.getLeft()));
        }

        if (!".".equals(node.getRight())) {
            postOrder(map.get(node.getRight()));
        }

        System.out.print(node.getRoot());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String root = sc.next();
            String left = sc.next();
            String right = sc.next();

            map.put(root, new Node(root, left, right));
        }

        preOrder(map.get("A"));
        System.out.println();
        inOrder(map.get("A"));
        System.out.println();
        postOrder(map.get("A"));
        System.out.println();
    }
}
