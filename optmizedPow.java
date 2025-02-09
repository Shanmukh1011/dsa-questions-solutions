class timepass{
    public static void main(String[]args){
        int x = 5,n =2;
        System.out.print(optPow(x,n));
    }
    static int optPow(int x,int n){
        if(n==0){
            return 1;
        }
        int halfPow = optPow(x,(n/2));
        if(n%2!=0){
            return x*halfPow*halfPow;
        }else{
            return halfPow*halfPow;
        }
    }
}
