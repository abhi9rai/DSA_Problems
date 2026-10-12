import java.util.PriorityQueue;
import java.util.Collections;
class Solution {
    PriorityQueue <Integer> pq=new PriorityQueue<>();
    public int findKthLargest(int[] nums, int k) {
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        for(int i=k; i<nums.length;i++){
            if(nums[i]<=pq.peek())
                continue;
            pq.remove();
            pq.add(nums[i]);
        }
        return pq.peek();
    }
}