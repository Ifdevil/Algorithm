package algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private int v;
    private LinkedList<Integer> adj[];

    public Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0;i<v;i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    public void bfs(int s,int t){
        if(s == t) return;
        // 辅助变量
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList();
        int[] pre = new int[v];
        Arrays.fill(pre,-1);
        queue.add(s);
        // 遍历
        while (!queue.isEmpty()){
            int w = queue.poll();
            for (int i = 0;i<adj[w].size();i++){
                int q = adj[w].get(i);
                if(!visited[q]){
                    pre[q] = w;
                    if(q == t){
                        print(pre,s,q);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private boolean found;
    public void dfs(int s,int t){
        found = false;
        int[] pre = new int[v];
        Arrays.fill(pre,-1);
        boolean[] visited = new boolean[v];
        recurDfs(s,t,pre,visited);
        print(pre,s,t);
    }
    private void recurDfs(int w,int t,int[] pre,boolean[] visited){
        if(found) return;
        visited[t] = true;
        if(w == t){
            found = true;
            return;
        }
        for (int i = 0 ;i < adj[w].size();i++){
            int q = adj[w].get(i);
            if(!visited[q]){
                pre[q] = w;
                recurDfs(q,t,pre,visited);
            }
        }
    }


    public void print(int[] pre,int s,int t){
        if(pre[t] != -1 && s!=t){
            print(pre,s,pre[t]);
        }
        System.out.println(t+" ");
    }
}
