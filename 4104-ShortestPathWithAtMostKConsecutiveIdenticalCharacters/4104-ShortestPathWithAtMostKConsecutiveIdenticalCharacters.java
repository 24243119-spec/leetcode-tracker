// Last updated: 7/9/2026, 10:07:28 AM
import java.util.*;

class Solution {
    static class State {
        int node, cnt;
        long dist;

        State(int node, int cnt, long dist) {
            this.node = node;
            this.cnt = cnt;
            this.dist = dist;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {
        int[][] mavorqeli = edges;

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : mavorqeli) {
            graph[e[0]].add(new int[]{e[1], e[2]});
        }

        long INF = Long.MAX_VALUE / 4;
        long[][] dist = new long[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }

        PriorityQueue<State> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        dist[0][1] = 0;
        pq.offer(new State(0, 1, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (cur.dist != dist[cur.node][cur.cnt]) continue;

            if (cur.node == n - 1) return (int) cur.dist;

            char curLabel = labels.charAt(cur.node);

            for (int[] edge : graph[cur.node]) {
                int nxt = edge[0];
                int w = edge[1];

                int nxtCnt;
                if (labels.charAt(nxt) == curLabel) {
                    nxtCnt = cur.cnt + 1;
                } else {
                    nxtCnt = 1;
                }

                if (nxtCnt > k) continue;

                long nd = cur.dist + w;

                if (nd < dist[nxt][nxtCnt]) {
                    dist[nxt][nxtCnt] = nd;
                    pq.offer(new State(nxt, nxtCnt, nd));
                }
            }
        }

        return -1;
    }
}