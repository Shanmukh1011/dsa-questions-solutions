class Code{
    public static void subStr(String str,String ans,int i){
        //base case
        if(i == str.length()){
            if(ans.length()==0){
                System.out.println("null");

            }else{
                System.out.println(ans);
            }
            return;
        }
        // operation need to perform
        //choise
        //including i th element
        subStr(str,ans+str.charAt(i),i+1);
        //excluding i th element
        subStr(str,ans,i+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        subStr(str,"",0);
    }
}
