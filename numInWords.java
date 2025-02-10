public class timepass{
    static String str []= {"zero","one","two","three","four","five","six,","seven","eight","nine"};
    public static void numInWords(int n){
        if(n==0){
            return;
        }
        int ld = n%10;
        String num = str[ld];
        n/=10;
        numInWords(n);
        System.out.print(num +" ");

    }
    public static void main(String[] args){
        int n = 4508752;
        numInWords(n);
    }
}
