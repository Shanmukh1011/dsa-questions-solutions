public class Main {
    public static void main(String args[]){
        int n = 5;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                if(i == 1||j ==1||i==n||j==n){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n-i+1;j++){
                System.out.print(j);

            }
            System.out.println();
        }
        int val = 1;
        for(int i = 1;i<=n;i++){

            for(int j = 1;j<=i;j++){
                System.out.print(val+" ");
                val++;
            }
            System.out.println();
        }
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=i;j++){
                if((i+j)%2 == 0){
                    System.out.print("1 ");
                }else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        for(int i =  1;i<=4;i++){
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }
            for(int j = 1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i =  4;i>=1;i--){
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }
            for(int j = 1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j = 1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j = 1;j<=n;j++){
                if(i ==1 || i == n||j ==1||j==n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for(int i = 0;i<=n;i++){
            for(int j = 1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j = 1;j<=2*i-1;j++){
                System.out.print("*");
            }
//            for(int j = 1;j<=n-i;j++){
//                System.out.print("*");
//            }
            System.out.println();
        }
        for(int i = n;i>=1;i--){
            for(int j = 1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j = 1;j<=2*i-1;j++){
                System.out.print("*");
            }
//            for(int j = 1;j<=n-i;j++){
//                System.out.print("*");
//            }
            System.out.println();
        }
    }
}
