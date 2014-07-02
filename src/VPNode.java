/**
 * Created by michaea1 on 7/1/14.
 */
abstract class VPNode<T> {
    T value;
    VPNode<T> close;
    VPNode<T> far;

    // must obey triangle inequality
    abstract Comparable distanceTo(VPNode<T> other);

    void printSubTree(int indent) {
        while (true) {
            for (int i = 0; i < indent; i++) System.out.print("\t");
            System.out.println("Node: " + value.toString());
            for (int i = 0; i < indent; i++) System.out.print("\t");
            System.out.println("Close: ");
            if (this.close != null) {
                this.close.printSubTree(indent + 5);
            }
            for (int i = 0; i < indent; i++) System.out.print("\t");
            System.out.println("Far: ");
            if (this.far != null) {
                this.far.printSubTree(indent + 5);
            }
        }
    }
}
