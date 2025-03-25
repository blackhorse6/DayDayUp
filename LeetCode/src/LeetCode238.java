public class LeetCode238 {

    /**
     * https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-100-liked
     * 思路：前缀积 和 后缀积
     */
    public static void main(String[] args) {
        LeetCode238 leetCode238 = new LeetCode238();
        int[] ans = new int[]{1, 2, 3, 4};
        leetCode238.productExceptSelf(ans);
        System.out.println(ans);

    }

    /**
     * 输入: nums = [1,2,3,4]
     * 输出: [24,12,8,6]
     */
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
//        Arrays.fill(prefix,1);
        prefix[0] = 1;
        // 1 1 2 6
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        // 1 2 3 4
        // 24 12 4 1
        int[] postfix = new int[nums.length];
        postfix[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefix[i] * postfix[i];
        }

        return nums;
    }
}
