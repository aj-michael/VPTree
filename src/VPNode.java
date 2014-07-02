import java.util.Arrays;

/**
 * Created by michaea1 on 7/1/14.
 */
abstract class VPNode<T> {
    T[] value;
    VPNode<T> close;
    VPNode<T> far;

    // must obey triangle inequality
    abstract Comparable distanceTo(VPNode<T> other);

    boolean equals(VPNode other) {
        return Arrays.equals(this.value, other.value);
    }

    void printSubTree(int indent) {
        for (int i = 0; i < indent; i++) System.out.print("\t");
        System.out.println("Node: " + Arrays.toString(this.value));
        for (int i = 0; i < indent; i++) System.out.print("\t");
        System.out.println("Close: ");
        if (this.close != null) {
            this.close.printSubTree(indent + 1);
        }
        for (int i = 0; i < indent; i++) System.out.print("\t");
        System.out.println("Far: ");
        if (this.far != null) {
            this.far.printSubTree(indent + 1);
        }
    }
}
