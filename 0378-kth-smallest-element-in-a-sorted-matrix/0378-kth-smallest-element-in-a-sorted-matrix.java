class Solution {
    int fun(int[][] a,int n, int m, int guess){
        int count=0;
        int row=n-1;
        int col=0;
        while(row>=0 && col<m){
            if(a[row][col]<=guess){
                count=count+row+1;
                col++;
            }
            else{
                row--;
            }
        }
        return count;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;
        int low=matrix[0][0];
        int high=matrix[n-1][m-1];
        int res=-1;
        while(low<=high){
            int guess=(low+high)/2;
            int ans=fun(matrix, n,m,guess);
            if(ans<k)
                low=guess+1;
            else{
                res=guess;
                high=guess-1;
            }
        }
        return res;
    }
}