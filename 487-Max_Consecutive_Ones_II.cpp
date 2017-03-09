public class Solution
{
    public int FindMaxConsecutiveOnes(int[] nums)
    {
        int theAnswer = 0;
        int [,]dp;
        dp = new int[2,2];
        dp[0, 0] = 0;
        dp[0, 1] = -1;

        for (int i = 0; i < nums.Length; ++i)
        {
            dp[1, 0] = 0;
            dp[1, 1] = -1;

            if (0 != nums[i])
            {
                dp[1, 0] = dp[0, 0] + 1;

                if (-1 != dp[0,1])
                    dp[1, 1] = dp[0, 1] + 1;
            }
            else
            {
                //become 1 or not
                dp[1, 0] = 0;
                dp[1, 1] = dp[0, 0] + 1;
            }

            dp[0, 0] = dp[1, 0];
            dp[0, 1] = dp[1, 1];
            theAnswer = Math.Max(dp[0, 0], theAnswer);
            theAnswer = Math.Max(dp[0, 1], theAnswer);
        }


        return theAnswer;
    }
}