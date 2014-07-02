/**
 * Created by michaea1 on 7/1/14.
 */
public class VPTree<T> {
    VPNode<T> root;
    Comparable cutoff;

    public VPTree(Class<? extends VPNode> Node, Comparable cutoff, T[][] in) {
        this.root = null;
        this.cutoff = cutoff;
        for (T[] val : in) {
            try {
                VPNode vpn = Node.newInstance();
                vpn.value = val;
                this.root = this.insertUnder(this.root, vpn);
            } catch (InstantiationException e) {
                throw new Error("Failed to instantiate a node");
            } catch (IllegalAccessException e) {
                throw new Error("Permission denied");
            }
        }
    }

    private VPNode insertUnder(VPNode existingNode, VPNode newNode) {
        if (existingNode == null) {
            return newNode;
        } else if (existingNode.distanceTo(newNode).compareTo(cutoff) < 0) {
            existingNode.close = insertUnder(existingNode.close, newNode);
            return existingNode;
        } else {
            existingNode.far = insertUnder(existingNode.far, newNode);
            return existingNode;
        }
    }

    public void printTree() {
        this.root.printSubTree(0);
    }
}
