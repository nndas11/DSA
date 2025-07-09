package Graphs.DisjoinSetVERYIMPORTANT;

import java.util.ArrayList;
import java.util.List;

//  Using 1-based indexing as it will work for both 0-based and 1-based indexing.
//  Using arrays instead of List makes it easier to write the code.

public class DisjoinSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    List<Integer> size = new ArrayList<>();

    public DisjoinSet(int n) {
        for(int i=0;i<=n;i++){
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

//    Finds the Ultimate Parent of a node.
//    Path compression also happens here.
    int findUParent(int node){
        if(node == parent.get(node))
            return node;

        int ulp = findUParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    void unionByRank(int u, int v){
//        find ulp parent of both
        int ulpU = findUParent(u);
        int ulpV = findUParent(v);

//        if belonging to same component do nothing.
        if (ulpU == ulpV)   return;

//        Comparing the rank of ultimate parents -> smaller gets connected to bigger -> so smaller parent is big.
        if(rank.get(ulpU) < rank.get(ulpV)){
            parent.set(ulpU, ulpV);
        } else if (rank.get(ulpV) < rank.get(ulpU)){
            parent.set(ulpV, ulpU);
        }else {
//            if same we can attach any way, to whichever we attaching -> its rank will increase.
            parent.set(ulpV, ulpU);
            rank.set(ulpU, rank.get(ulpU) + 1);
        }
    }

    public void unionBySize(int u, int v){
        int ulpU = findUParent(u);
        int ulpV = findUParent(v);

//        if belonging to same component do nothing.
        if (ulpU == ulpV)   return;

        if(size.get(ulpU) < size.get(ulpV)){
            parent.set(ulpU, ulpV);
            size.set(ulpV, size.get(ulpV) + size.get(ulpU));
        }else {
//            if same we can attach any way, to whichever we attaching -> its rank will increase.
            parent.set(ulpV, ulpU);
            size.set(ulpU, size.get(ulpU) + size.get(ulpV));
        }
    }
}
