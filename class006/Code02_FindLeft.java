package class006;

public class Code02_FindLeft {
    public int findLeft(int[] nums, int target) {
        if(target < nums[0]){
            return 0;
        }
        if(target>nums[nums.length-1]){
            return nums.length-1;
        }
        int l=0,r=nums.length-1;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(target<nums[mid]){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}