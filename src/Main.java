public class Main {

    public static void main(String[] args) {
        int[][] points = {{1, 2, 3}, {-2, 11, 3}, {4, -1, 0}, {0, 0, 0},
                {1, 15, -20}, {-50, 43, 3}, {15, 8, 9}, {32, 60, -15},
                {5, 2, 9}, {3, -4, 9}, {-2, 0, 8}, {20, -15, 10}};
        VPTree tree = new VPTree(EuclideanVPNode.class, 10, points);
        tree.printTree();
    }
}
