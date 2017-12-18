package merge;
/*把重合的区间合并
 * 例如:输入[1,3],[2,6],[8,10],[15,18]
 * 输出:[1,6],[8,10],[15,18]
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Solution {
    private Map<Interval, List<Interval> > graph;
    private Map<Integer, List<Interval> > nodesInComp;
    private Set<Interval> visited;

    // return whether two intervals overlap (inclusive)
    private boolean overlap(Interval a, Interval b) {
        return a.start <= b.end && b.start <= a.end;
    }
    
    // build a graph where an undirected edge between intervals u and v exists
    // iff u and v overlap.
    private void buildGraph(List<Interval> intervals) {
        graph = new HashMap<Interval, List<Interval>>();
        for (Interval interval : intervals) {
            graph.put(interval, new LinkedList<Interval>());
        }

        for (Interval interval1 : intervals) {
            for (Interval interval2 : intervals) {
                if (overlap(interval1, interval2)) {
                    graph.get(interval1).add(interval2);
                    graph.get(interval2).add(interval1);
                }
            }
        }
    }

    // merges all of the nodes in this connected component into one interval.
    private Interval mergeNodes(List<Interval> nodes) {
        int minStart = nodes.get(0).start;
        for (Interval node : nodes) {
            minStart = Math.min(minStart, node.start);
        }

        int maxEnd = nodes.get(0).end;
        for (Interval node : nodes) {
            maxEnd= Math.max(maxEnd, node.end);
        }

        return new Interval(minStart, maxEnd);
    }

    // use depth-first search to mark all nodes in the same connected component
    // with the same integer.
    private void markComponentDFS(Interval start, int compNumber) {
        Stack<Interval> stack = new Stack<Interval>();
        stack.add(start);

        while (!stack.isEmpty()) {
            Interval node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);

                if (nodesInComp.get(compNumber) == null) {
                    nodesInComp.put(compNumber, new LinkedList<Interval>());
                }
                nodesInComp.get(compNumber).add(node);

                for (Interval child : graph.get(node)) {
                    stack.add(child);
                }
            }
        }
    }

    // gets the connected components of the interval overlap graph.
    private void buildComponents(List<Interval> intervals) {
        nodesInComp = new HashMap();
        visited = new HashSet();
        int compNumber = 0;

        for (Interval interval : intervals) {
            if (!visited.contains(interval)) {
                markComponentDFS(interval, compNumber);
                compNumber++;
            }
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        buildGraph(intervals);
        buildComponents(intervals);

        // for each component, merge all intervals into one interval.
        List<Interval> merged = new LinkedList<Interval>();
        for (int comp = 0; comp < nodesInComp.size(); comp++) {
            merged.add(mergeNodes(nodesInComp.get(comp)));
        }
        //for(int i=0;i<merged.size();i++){
        	//System.out.println((merged.get(i)));
        //}
        for(Iterator<Interval> it=merged.iterator();it.hasNext();){
        	Interval interval=(Interval)it.next();
        	System.out.println("["+interval.getStart()+","+interval.getEnd()+"]");
        }
        return merged;
    }
    
    public static void main(String[] args){
    	Solution s=new Solution();
    	Interval l1=new Interval(1,3);
    	Interval l2=new Interval(2,6);
    	Interval l3=new Interval(8,10);
    	Interval l4=new Interval(15,18);
    	List<Interval> intervalList=new ArrayList<Interval>();
    	intervalList.add(l1);
    	intervalList.add(l2);
    	intervalList.add(l3);
    	intervalList.add(l4);
    	s.merge(intervalList);
    }
}