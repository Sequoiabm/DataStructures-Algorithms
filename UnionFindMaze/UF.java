public class UF {
    private int[] id;     // access to component id (site indexed)
    private int[] sz;     // size of each component for rank optimization
    private int count;    // number of components

    public UF(int N) {  // Initialize component id array.
        count = N;
        id = new int[N];
        sz = new int[N];   // initialize size array for rank optimization
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;     // initialize size to 1 for each component
        }
    }

    public int count() { 
        return count;  
    }

    public boolean connected(int p, int q) { 
        return find(p) == find(q);  
    }

    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];  // Path compression
            p = id[p];
        }
        return p;
    }
     
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        
        // Union by rank: Attach smaller tree to root of larger tree
        if (sz[rootP] < sz[rootQ]) {
            id[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
        } else {
            id[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
        }
        
        count--; // Reduce component count
    }
}
