class Solution {
    public int[] dailyTemperatures(int[] temperatures) 
    {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) 
        {
            while (!stack.isEmpty() && 
                   temperatures[i] > temperatures[stack.peek()]) 
            {
                int index = stack.pop();
                ans[index] = i - index;
            }

            stack.push(i);
        }

        return ans;
    }
}
// With Hashmap(Not effective)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) 
    {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < temperatures.length; i++) 
        {
            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) 
            {
                int index = stack.pop();

                map.put(index, i - index);
            }

            stack.push(i);
        }

        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) 
        {
            if (map.containsKey(i))
                ans[i] = map.get(i);
            else
                ans[i] = 0;
        }

        return ans;
    }
}
