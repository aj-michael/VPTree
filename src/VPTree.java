import java.util.List;

/**
 * Created by michaea1 on 7/1/14.
 */
public class VPTree<T> {
    VPNode<T> root;
    double cutoff;

    public VPTree(Class<? extends VPNode> Node, double cutoff, T[][] in) {
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

    // existingNode must be in the tree
    public VPNode insertUnder(VPNode existingNode, VPNode newNode) {
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

    // otherNode need not be in the tree (typically won't be)
    public VPNode closestNodeTo(VPNode targetNode) {
       return closestNodeTo(this.root, targetNode, this.cutoff);
    }

    public VPNode closestNodeTo(VPNode startingNode, VPNode targetNode, double tau) {
        double distFromStart = startingNode.distanceTo(targetNode);
        if (distFromStart < tau) {   // Don't need to search outer subtree
            VPNode innerNode = closestNodeTo(startingNode.close, targetNode, Math.min(cutoff - distFromStart, tau));
            return innerNode == null ? startingNode : innerNode;
        } else {
            
        }
        return null;
    }

    public List<VPNode> closestNNodesTo(VPNode otherNode, int n) {
        return null;
    }

    public boolean contains(VPNode otherNode) {
        return this.subtreeContains(this.root, otherNode);
    }

    public boolean subtreeContains(VPNode subroot, VPNode otherNode) {
        Comparable distance = this.root.distanceTo(otherNode);
        if (distance.compareTo((double) 0) == 0) {
            return true;
        } else if (distance.compareTo(this.cutoff) < 0) {
            return subroot.close == null ? false : this.subtreeContains(subroot.close, otherNode);
        } else {
            return subroot.far == null? false : this.subtreeContains(subroot.far, otherNode);
        }
    }

    public void printTree() {
        this.root.printSubTree(0);
    }
}
