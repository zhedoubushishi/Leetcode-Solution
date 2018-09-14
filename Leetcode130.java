class UnionFind {
    int[] father;
    UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    int find(int a) {
        if (father[a] == a) {
            return a;
        }
        return father[a] = find(father[a]);
    }

    void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            father[Math.min(fa, fb)] = Math.max(fa, fb);
        }
    }
}


public class Leetcode130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int n = board.length;
        int m = board[0].length;

        UnionFind uf = new UnionFind(m * n + 1);
        int dummy = m * n;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') {
                    continue;
                }
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    uf.union(m * i + j, dummy);
                } else {
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (board[ni][nj] == 'O') {
                            uf.union(m * ni + nj, m * i + j);
                        }
                    }
                }
            }
        }

        int dummyFather = uf.find(dummy);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && uf.find(m * i + j) != dummyFather) {
                    board[i][j] = 'X';
                }
            }
        }

    }
}