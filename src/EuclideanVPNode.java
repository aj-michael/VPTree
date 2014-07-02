import java.util.Arrays;
import java.util.Iterator;

public class EuclideanVPNode extends VPNode<Double[]> {
    @Override
    public Double distanceTo(VPNode<Double[]> other) {
        Double total = Double.valueOf(0);
        System.out.println(Arrays.asList(this.value).iterator().getClass());
        Iterator<Double> p1 = Arrays.asList(this.value).iterator();
        Iterator<Double> p2 = Arrays.asList(other.value).iterator();
        while (p1.hasNext() && p2.hasNext()) {
            total += Math.pow(p1.next()-p2.next(),2);
        }
        return Math.sqrt(total);
    }
}
