class Memoization 
{
    public static int KnapSack(int W, int wt[], int val[], int n, int dp[][])
    {   
        //Base Case
        if (n == 0 || W == 0)  
        return 0;
        
        //To check whether DP matrix already has this value.
        if (dp[n][W] != -1)
            return dp[n][W];  
        
        //To check whether knapsack will be able to contain the entity.
        //If not possible.
        if (wt[n - 1] > W)  
            return dp[n][W] = KnapSack(W, wt, val, n - 1, dp);
        
        //If possible
        //Here occurs two conditions will it be included into the optimal solution or not.
        else 
            return dp[n][W] = Math.max((val[n - 1] + KnapSack(W - wt[n - 1], wt, val, n - 1, dp)), KnapSack(W, wt, val, n - 1, dp));       
    }

    //Function to create DP Matrix and initialize it with all -1
    static int DP_Matrix(int W, int wt[], int val[], int N)
    { 
        int dp[][] = new int[N + 1][W + 1];
        
        for(int i = 0; i < N + 1; i++)  
            for(int j = 0; j < W + 1; j++)  
                dp[i][j] = -1;   
        
        return KnapSack(W, wt, val, N, dp);    
    }
    
    //Driver Code
    public static void main(String args[])
    {
        int val[] = new int[] {15, 14, 10, 45, 30};
        int wt[] = new int[] {2, 5, 1, 3, 4};
        int n=val.length;
        int W=7;
        System.out.println(DP_Matrix(W, wt, val, n));
    }
}
