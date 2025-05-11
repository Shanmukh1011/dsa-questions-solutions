import java.util.*;
public class Main{
public static boolean targetSum(int arr[],int target){
int n = arr.length;
boolean dp[][] = new boolean[n+1][target+1];
for(int i = 0;i<=n;i++){
	dp[i][0]=true;
}

for(int i = 1;i<=n;i++){
	for(int j = 1;j<=target;j++){
	int w = arr[i-1];
	if(w <= j && dp[i-1][j-w] == true){
	dp[i][j] = true;
}else if(dp[i-1][j] == true){
dp[i][j] = true;
}
}
}
return dp[n][target] ;
}
	public static void main(String args[]){
		int arr[] = {1,3,4,2,5,6,8};
		int target = 15;
		System.out.println(targetSum(arr,target));
}
}


