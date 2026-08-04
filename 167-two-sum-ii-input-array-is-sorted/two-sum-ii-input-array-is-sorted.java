class Solution {
    public int[] twoSum(int[] numbers, int target) 
    {
        int right=numbers.length-1;
        int left=0;
        int sum =0;
        int[] output;
        while(left<right)
        {
            
            sum=numbers[left]+numbers[right];
            if(sum==target)
            {
                return new int[]{left+1,right+1};
            }
            if(sum<target)
            {
               left++;
            }
            else
            {
                right--;
            }
        }
    return new int[]{};
    }
}