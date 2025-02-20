class Code{
    public static void permutation(String str,String ans){
        //basecase
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //recursion
        for(int i = 0;i<str.length();i++){
            char curr = str.charAt(i);
            String newStr = str.substring(0,i)+str.substring(i+1,str.length());
            permutation(newStr,ans+curr);
        }
    }
    public static void main(String args[]){
        String str = "abc";
        permutation(str,"");
    }
}
