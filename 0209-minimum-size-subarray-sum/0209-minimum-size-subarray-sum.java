class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int ans=Integer.MAX_VALUE;;
        int sum=0;
        int low=0;
        for(int high=0;high<n;high++){
            sum+=nums[high];
            while(sum>=target){
                int len=high-low+1;
                ans=Math.min(ans,len);
                sum-=nums[low];
                low++;
            } 
        }
        return ans== Integer.MAX_VALUE ? 0 : ans;
    }
}