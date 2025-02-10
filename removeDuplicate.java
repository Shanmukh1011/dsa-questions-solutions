class timepass{
    public static void main(String[] args){
        String str = "shanmukh";
        StringBuilder newStr = new StringBuilder("");
        int i = 0;
        boolean map[] = new boolean [26];
        removeDuplicate(str,i,newStr,map);
    }
    static void removeDuplicate(String str,int i,StringBuilder newStr,boolean map[]){
        if(i == str.length()){
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(i);
        if(map[currChar-'a']==true){
            removeDuplicate(str,i+1,newStr,map);
        }else{
            map[currChar -'a'] = true;
            newStr.append(currChar);
            removeDuplicate(str,i+1,newStr,map);
        }
    }
}
