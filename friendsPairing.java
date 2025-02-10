class timepass{
    public static void main(String args[]){
        int  n = 3;
        int sol = friendsPairing( n);
        System.out.println(sol);
    }
    static int friendsPairing(int n){
        if(n == 1||n== 2){
            return n;
        }
        return friendsPairing(n-1)*1+(n-1)*(friendsPairing(n-2));
    }
}
