class timepass{
    public static void main(String args[]){
        int n = 4;
        towerOfHanoi(n,"A","B","C");
    }
    public static void towerOfHanoi(int n, String src, String help, String dest){
        if(n==1){
          System.out.println("transfer disc "+ n +" from "+src+" to "+dest);  
          return;
            }
    //transper n-1 fron src discs to helper by using dest as help
    towerOfHanoi(n-1,src,dest,help);
    
    //transfer n dic to dest by using helper 
   System.out.println("transfer disc "+ n +" from "+src +" to "+ dest );
    //transfering n-1 to dest from helper to dest by using src
    towerOfHanoi(n-1,help,src,dest);
    }
}
