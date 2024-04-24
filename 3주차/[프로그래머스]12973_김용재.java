class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        int num =0;
        for(int i=0; i<s.length();i++)
        {
            if(i==s.length()-1)
            {
                return 0;
            }
            else
            {
                if(s.charAt(i)==s.charAt(i+1))
                {
                    for(int t=num;t<=i;t++)
                    {
                        if(s.charAt(t)!=s.charAt(2*i-t+1))
                        {
                            return 0;
                        }
                    }
                    num=2*i-num+2;
                    i=num-1;
                    System.out.println(num);
                }
            }
        }
        return 1;
    }
}