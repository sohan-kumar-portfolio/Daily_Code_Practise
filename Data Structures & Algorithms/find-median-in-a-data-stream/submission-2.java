//import java.util.*;

class MedianFinder 
{
    java.util.PriorityQueue<Integer> shortTeam;
    java.util.PriorityQueue<Integer> tallTeam;
    public MedianFinder() 
    {
        shortTeam = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
        tallTeam = new java.util.PriorityQueue<>();
    }

    public void addNum(int num) 
    {
        shortTeam.add(num);
        tallTeam.add(shortTeam.poll());
        if (tallTeam.size() > shortTeam.size())
        {
            shortTeam.add(tallTeam.poll());
        }
        
    }

    public double findMedian() 
    {
        if (shortTeam.size() > tallTeam.size())
        {
            return shortTeam.peek();
        }
        return (shortTeam.peek() + tallTeam.peek()) / 2.0;
    }
}
