class Problem1 {
    public int numberOfArithmeticSlices(int[] nums) {
        //return bruteForce(nums);
        return dpSpaceOptimized(nums);
    }

    //TC:O(n^2)
    //SC:O(1)
    public int bruteForce(int[] nums) {
        int n = nums.length;
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=i+2;j<n;j++){
                if(nums[i+1]-nums[i] == nums[j]-nums[j-1]){
                    count++;
                }else{
                    break;
                }
            }
        }
        return count;
    }

    //TC:O(N)
    //SC:O(N)
    public int dp (int[] nums){
        int n = nums.length;
        int[] dp = new int[n];

        if(n<3){
            return 0;
        }
        int count =0;
        for(int i=2;i<n;i++){
            if(nums[i] - nums[i-1] == nums[i-1]-nums[i-2]){
                dp[i]=dp[i-1]+1;
                count+=dp[i];
            }else{
                dp[i]=0;
            }

        }
        return count;
    }

    //TC:O(N)
    //SC:O(1)
    public int dpSpaceOptimized (int[] nums){
        int n = nums.length;

        if(n<3){
            return 0;
        }
        int count =0;
        int prevCount =0;
        for(int i=2;i<n;i++){
            if(nums[i] - nums[i-1] == nums[i-1]-nums[i-2]){
                prevCount = prevCount +1;
                count+=prevCount;

            }else{
                prevCount = 0;
            }

        }
        return count;
    }


}