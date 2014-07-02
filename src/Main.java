public class Main {
    public static void main(String[] args) {
        int NUM_POINTS = 50;
        int DIMENSIONS = 5;
        int MAX_COORDINATE = 100;
        double VP_CUTOFF = 75;
        Double[][] points = new Double[NUM_POINTS][DIMENSIONS];
        for (int point = 0; point < NUM_POINTS; point++) {
            for (int coord = 0; coord < DIMENSIONS; coord++) {
                points[point][coord] = new Double(2*MAX_COORDINATE*(.5-Math.random()));
            }
        }
        VPTree tree = new VPTree(EuclideanVPNode.class, VP_CUTOFF, points);
        tree.printTree();
    }
}
