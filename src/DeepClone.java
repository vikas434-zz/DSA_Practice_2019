import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class DeepClone {

    public Node cloneGraph(Node node) {

        final Node cloneNode = new Node();

        if (Objects.isNull(node)) {
            return cloneNode;
        }

        // DO BFS of node and create a CloneNode from this.
        LinkedList<Integer> queue = new LinkedList<>();

        // Node value will start from 1 not from 0 so keeping the size +1.
        final boolean[] isVisitedArray = new boolean[node.neighbors.size() + 1];

        queue.add(node.val);
        cloneNode.val = node.val;
        cloneNode.neighbors = new ArrayList<>();

        List<Node> neighbourList = node.neighbors;
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println();
        while (!queue.isEmpty()) {
            int pollValue = queue.poll();

        }


        return cloneNode;
    }

}
