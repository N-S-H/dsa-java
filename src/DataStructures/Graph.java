package DataStructures;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {

    private class Pair {
        int u;
        int v;
        Pair(int first,int second) {
            this.u=first;
            this.v=second;
        }
    }

    private class GraphContainer {
        List<Integer> adj[];
        int totalEdges;
        int totalNodes;
        GraphContainer(int n,int e) {
            this.totalEdges=n;
            this.totalNodes=e;
            adj = new ArrayList[n];
            for(int i=0;i<n;i++) {
                adj[i] = new ArrayList<>();
            }
        }

        public void addEdge(int u,int v) {
            adj[u].add(v);
            adj[v].add(u);
        }
    }

    public void testGraph() {
        System.out.println("============Graph==========");
        int[] arr={10,4,6,12,7,9,13,16,26,52};
        System.out.println("About to construct the graph on the following values: "+ Arrays.stream(arr).mapToObj(val->String.valueOf(val)).collect(Collectors.joining(", ")));
        List<Pair> list = new ArrayList<>();
        int totalEdges = 12;
        System.out.println("There are "+totalEdges+" in total. They are of the following array indices: ");
        list.add(new Pair(0,1));
        list.add(new Pair(0,2));
        list.add(new Pair(1,2));
        list.add(new Pair(1,3));
        list.add(new Pair(1,4));
        list.add(new Pair(1,5));
        list.add(new Pair(2,5));
        list.add(new Pair(3,6));
        list.add(new Pair(4,7));
        list.add(new Pair(5,8));
        list.add(new Pair(7,9));
        list.add(new Pair(8,9));
        for(int i=0;i<totalEdges;i++) {
            System.out.println("Edge #"+i+": ("+list.get(i).u+","+list.get(i).v+")");
        }
        GraphContainer gc = constructGraph(arr.length,totalEdges,list);
        performBreadthFirstTraversal(arr,gc);
        performDepthFirstTraversal(arr,gc);
    }

    private GraphContainer constructGraph(int totalNodes,int totalEdges,List<Pair> edgeList) {
        GraphContainer gc = new GraphContainer(totalNodes,totalEdges);
        edgeList.stream().forEach(pair-> {
            gc.addEdge(pair.u, pair.v);
        });
        return gc;
    }

    private void  performBreadthFirstTraversal(int[] arr,GraphContainer gc) {
        System.out.println("Breadth first traversal");
        if(gc.totalNodes==0) return;
        Deque<Integer> dq=new ArrayDeque<>();
        boolean[] visited = new boolean[gc.totalNodes];
        dq.add(0);
        visited[0]=true;
        while(!dq.isEmpty()) {
            int currentNodeIdx=dq.pollFirst();
            System.out.print(arr[currentNodeIdx]+" ");
            for(int i=0;i<gc.adj[currentNodeIdx].size();i++) {
                if(!visited[gc.adj[currentNodeIdx].get(i)]) {
                    dq.addLast(gc.adj[currentNodeIdx].get(i));
                    visited[gc.adj[currentNodeIdx].get(i)]=true;
                }
            }
        }
        System.out.println();
    }

    private void  performDepthFirstTraversal(int[] arr,GraphContainer gc) {
        System.out.println("Depth first traversal");
        Stack<Integer> stack=new Stack<>();
        boolean[] visited = new boolean[gc.totalNodes];
        stack.push(0);
        visited[0]=true;
        while(!stack.isEmpty()) {
            int currentNodeIdx=stack.pop();
            System.out.print(arr[currentNodeIdx]+" ");
            for(int i=0;i<gc.adj[currentNodeIdx].size();i++) {
                if(!visited[gc.adj[currentNodeIdx].get(i)]) {
                    stack.push(gc.adj[currentNodeIdx].get(i));
                    visited[gc.adj[currentNodeIdx].get(i)]=true;
                }
            }
        }
        System.out.println();
    }
}
