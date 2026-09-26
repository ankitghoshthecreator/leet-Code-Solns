class Solution {
    public int calculate(String s) {
        int res=0;
        int currN=0;
        int lastN=0;

        char op='+';

        for(int i=0; i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                currN=currN*10+(c-'0');
            }
            if((!Character.isDigit(c) && c!=' ')|| i==s.length()-1){
                switch(op){
                    case '+' :
                       res+=lastN;
                       lastN=currN;
                       break;
                    case '-':
                        res+=lastN;
                        lastN=-currN;
                        break;
                    case '/':
                        lastN=lastN/currN;
                        break;
                    case '*':
                        lastN=lastN*currN;
                        break;
                }
                op=c;
                currN=0;
            }
        }return res+lastN;
    }
}