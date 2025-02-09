# dsa-questions-solutions
//code for solving tile type problem...

class timepass{
    public static void main(String[] args){
        int n = 5;
        int sol = tilingProblem(n);
        System.out.println(sol);
    }
    public static int tilingProblem(int n){
        if(n ==  0||n == 1){
            return 1;
        }
        int fnm1 = tilingProblem(n-1);
        int fnm2 = tilingProblem(n-2);
        int totalWays = fnm1+fnm2;
        return totalWays;
    }
}