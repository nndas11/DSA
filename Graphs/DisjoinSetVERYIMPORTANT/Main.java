package Graphs.DisjoinSetVERYIMPORTANT;

//  VERY IMPORTANT TOPIC -> ASKED LOT IN INTERVIEWS AND OAs.

//  Checking if two nodes belong to the same component or not.
//  Brute Force -> DFS -> takes O(v +e)

//  Disjoin Set does the same in Constant Time -> YES or NO.
//  Used in Dynamic graph, which keeps on changing.

//  At any stage, they will ask if they belong to same component -> need answer in constant time.
//  In union-find, we are not actually creating a graph but different data structure.

//  2 Methods:
//      findParent(); -> calls this method on both node checks whether belong to the same parent or not
//                       if same parent, then part of same component, otherwise not.
//      union() -> can be implemented in 2 ways -> by rank and size

//  Using Rank:
//  Required -> rank array and parent array.
//  Rank means the height.
//  Initially every node is a parent of itself and rank -> 0 for each.

//  Algorithm:
//  Union(u, v) -> connect edges
//      1.  Find the ultimate parent of u and v -> pu and pv.
//      2.  Find rank of pu and pv.
//      3.  Connect smaller rank to larger rank always -> we are connecting the pu and pv based on rank.

//  finParent() -> gives the parent of a node
//      Happens Path Compression -> attaching to direct ultimate parent -> so can do lookup in constant time.
//      But rank can't be reduced in path compression.
//      That is why it is called rank and not height array.

//  How do we do Path Compression?
//  findParen(u){
//      if(u == parent[u]
//          return u;
//      return parent[u] = findParent(u) ;


//  TC: O(4alpha) -> O(4) -> alpha is almost equal to one -> explanation not needed in interviews.

public class Main {
    public static void main(String[] args) {
        DisjoinSet disjoinSet = new DisjoinSet(7);
        disjoinSet.unionByRank(1, 2);
        disjoinSet.unionByRank(2, 3);
        disjoinSet.unionByRank(4, 5);
        disjoinSet.unionByRank(6, 7);
        disjoinSet.unionByRank(5, 6);

        if(disjoinSet.findUParent(3) == disjoinSet.findUParent(7))
            System.out.println("Same Component");
        else
            System.out.println("Different Component");

//        we can add dynamically

        disjoinSet.unionByRank(3, 7);
        if(disjoinSet.findUParent(3) == disjoinSet.findUParent(7))
            System.out.println("Same Component");
        else
            System.out.println("Different Component");
    }
}
