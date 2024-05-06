class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder("");
        while(n!=0) {
            if(n%3==0) {
                sb.insert(0,"4");
                n=n/3;
                n--;
            }
            else if(n%3==1) {
                sb.insert(0,"1");
                n=n/3;
            }
            else if(n%3==2) {
                sb.insert(0,"2");
                n=n/3;
            }
        }
        String answer = sb.toString();
        return answer;
    }
}