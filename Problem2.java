class Problem2 {
    int dp [][];
    public int minimumTotal(List<List<Integer>> triangle) {
        //return bruteForceDFS(triangle,0,0);

        int n = triangle.size();
        dp = new int[n][n];
       /*
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        return memoizationDFS(triangle,0,0);
        */


        return tabulation(triangle);


    }

    //TC:O(2^N)
    //SC:O(N)
    public int bruteForceDFS(List<List<Integer>> triangle,int r ,int c) {
        //base condition
        if(r==triangle.size()){
            return 0;
        }

        //logic
        int left = bruteForceDFS(triangle,r+1,c);
        int right = bruteForceDFS(triangle,r+1,c+1);

        return Math.min(left,right)+triangle.get(r).get(c);

    }

    //TC:O(N)
    //SC:O(N)
    public int memoizationDFS(List<List<Integer>> triangle,int r ,int c) {
        //base condition
        if(r==triangle.size()){
            return 0;
        }

        //logic
        if(dp[r][c] ==Integer.MAX_VALUE){
            int left = memoizationDFS(triangle,r+1,c);
            int right = memoizationDFS(triangle,r+1,c+1);

            int minsum = Math.min(left,right)+triangle.get(r).get(c);
            dp[r][c] = minsum;
        }

        return dp[r][c];

    }

    //TC:O(N)
    //SC:O(N)
    public int tabulation(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp[0][0]= triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    // this is leftmost leaf or  the rightmost leaf
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][0];
                }else if(j==i){
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j-1];
                }else{
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j-1],dp[i-1][j]);
                }


            }
        }
        int result = Integer.MAX_VALUE;
        for(int k=0;k<n;k++){
            result = Math.min(result,dp[n-1][k]);
        }

        return result;

    }


}