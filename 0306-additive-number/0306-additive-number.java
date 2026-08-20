import java.math.BigInteger;
class Solution {
    public boolean isAdditiveNumber(String num) {
        int n=num.length();
        for(int i=1; i<=n-2; i++){
            if(num.charAt(0)=='0' && i>1){
                break;
            }
            BigInteger first=new BigInteger(num.substring(0,i));
            for(int j=i+1;j<=n-1;j++){
                if(num.charAt(i)=='0' && j-i>1){
                    break;
                }
                BigInteger second=new BigInteger(num.substring(i,j));
                if(check(num, first,second, j)){
                    return true;
                }

            }

        }
        return false;
    }
    private boolean check(String num, BigInteger f, BigInteger s, int j){
        int count=2;
        while (j < num.length()) {

            BigInteger sum = f.add(s);

            String numString = sum.toString();

            if (!num.startsWith(numString, j)) {
                return false;
            }
            j+=numString.length();
            f=s;
            s=sum;

            count++;
        }
        return count>=3;
    }
}