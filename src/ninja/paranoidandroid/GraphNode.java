package ninja.paranoidandroid;

/**
 * Created by anton on 16.03.17.
 */
public class GraphNode {

    public GraphNode[] neighbors;
    public int value;
    public boolean visited;

    public GraphNode(int v) {
        this.value = v;
        this.visited = false;
    }

}
