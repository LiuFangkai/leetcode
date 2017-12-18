package merge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Solution1{
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        for(Iterator<Interval> it=merged.iterator();it.hasNext();){
        	Interval interval=(Interval)it.next();
        	System.out.println("["+interval.getStart()+","+interval.getEnd()+"]");
        }
        return merged;
    }
    public static void main(String[] args){
    	Solution1 s=new Solution1();
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