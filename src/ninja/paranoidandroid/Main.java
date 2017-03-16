package ninja.paranoidandroid;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here


        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(5);
        GraphNode n6 = new GraphNode(6);
        GraphNode n7 = new GraphNode(7);

        n1.neighbors = new GraphNode[] {n2, n4, n5};
        n2.neighbors = new GraphNode[] {n1, n3, n4};
        n3.neighbors = new GraphNode[] {n2, n4, n7};
        n4.neighbors = new GraphNode[] {n1, n2, n3, n5, n6, n7};
        n5.neighbors = new GraphNode[] {n1, n4, n6};
        n6.neighbors = new GraphNode[] {n4, n5, n7};
        n7.neighbors = new GraphNode[] {n3, n4, n6};

        //bfs(n1);
        //dfs(n1);

    }

//    The logic behind creating this search is as follows:
//
//    Create a new Java Queue of type GraphNode
//    Mark our root GraphNode as discovered and print it out
//    Add the root GraphNode into the Queue
//    Loop through the Queue infinitely until it is empty
//    Poll the head of the Queue for the GraphNode
//    Loop through all GraphNode neighbors of the polled head
//    If the neighbor has not been discovered, mark it as discovered and add it into the Queue

    public static void bfs(GraphNode node) {

        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        node.visited = true;
        queue.add(node);

        System.out.println(node.value);

        while(!queue.isEmpty()) {
            GraphNode v = queue.poll();
            for(GraphNode w : v.neighbors) {
                if(!w.visited) {
                    System.out.println(w.value);
                    w.visited = true;
                    queue.add(w);
                }
            }
        }
    }

//    The logic behind the Depth-First Search algorithm is similar to the BFS algorithm and is as follows:
//
//    Create a Java Stack and push the root node to it
//    Loop until the GraphNode stack is empty
//    Pop the top GraphNode off the stack
//    If the node has not been visited, mark it so and loop through all GraphNode neighbors in reverse
//    Push each neighbor into the stack

    public static void dfs(GraphNode node) {

        Stack<GraphNode> stack = new Stack<GraphNode>();
        stack.push(node);

        while(!stack.isEmpty()) {
            GraphNode v = stack.pop();
            if(!v.visited) {
                System.out.println(v.value);
                v.visited = true;
                for(int i = v.neighbors.length - 1; i >= 0; i--) {
                    stack.push(v.neighbors[i]);
                }
            }
        }

    }


}
