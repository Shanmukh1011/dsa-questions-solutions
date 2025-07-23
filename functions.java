import java.util.*;
public class Main {
    static void helloWorld(){
        System.out.println("Hello dear Nisha");
    }
    public static int mul(int a,int b){
        return a*b;
    }
    public static int fact(int n){
        int val = 1;
        for(int i = 1;i<=n;i++){
            val *= i;

        }
        return val;
    }
    public static int binCof(int n,int r){
        int nFac = fact(n);
        int rFac = fact(r);
        int nmrFac = fact(n-r);
        return  (nFac/(rFac*nmrFac));
    }
    public static int binToDec(int bin){
        int dec = 0;
        int pow = 0;

        while(bin >0){
            int ld = bin%10;
            dec = dec+(ld*(int)Math.pow(2,pow));
            pow++;
            bin/=10;
        }
        return dec;
    }
    public static int decToBin(int dec){
        int pow = 0;
        int bin = 0;
        while(dec >0){
            int rem = dec%2;
            bin = bin+(rem*(int)Math.pow(10,pow));
            pow++;
            dec/=2;
        }
        return bin;
    }
    public static int sumOfDig(int num){
        int sum = 0;
        while(num >0){
            int ld = num%10;
            sum = sum+ld;
            num/=10;
        }
        return sum;

    }
    public static boolean isPelendrom(int num){
        int rev = 1;
        int act = num;
        while(num >0){
            int ld = num%10;
            rev= rev*10+ld;
            num/=10;

        }
        if(act == rev) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      System.out.println()


    }

}
