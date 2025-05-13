import java.util.*;
public class Main{
	public static int catalanMemo(int n,int dp[]){
	// base case;
	if(n == 0|| n == 1) return 1;
	int ans = 0;
	
	if(dp[n] != -1){
return dp[n];
}

for(int i = 0;i<n;i++){
ans+=catalanMemo(i,dp)*catalanMemo(n-i-1,dp);
}
dp[n] = ans;
return dp[n];
}
	public static void main(String args[]){
int n = 5;
int dp[] = new int [n+1];
Arrays.fill(dp,-1);
System.out.println(catalanMemo(n,dp));}
}
