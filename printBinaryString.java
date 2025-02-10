public class timepass{
    public static void main(String[] args){
        int n = 3;
        printBinString(n,0,"");
    }
    public static void printBinString(int n,int lastPlace,String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        //lastPlace ==0
        //lastPlace ==1
        printBinString(n-1,0,str+"0");

        //lastPlace ==0;
        if(lastPlace==0){
            printBinString(n-1,1,str+"1");
        }
    }
}
