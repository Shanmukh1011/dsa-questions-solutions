public class timepass{
    public static void main(String [] args){
        StringBuilder str = new StringBuilder("hello");
        System.out.println("rever String = "+revStr(str,0,str.length()-1));
    }
    public static StringBuilder revStr(StringBuilder str,int left,int right){
        if(left > right){
            return str;
        }
        //swoping left and right charecters;
        char temp = str.charAt(left);
        str.setCharAt(left,str.charAt(right));
        str.setCharAt(right,temp);

        return revStr(str,left+1,right-1);
    }
}
