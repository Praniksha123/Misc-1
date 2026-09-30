//problem1
class Solution {
    public int brokenCalc(int startValue, int target) {
        int cnt=0;
        while(target>startValue){
            if(target%2==0){
                target=target/2;
            }else{
                target=target+1;
            }
            cnt++;
        }
        return cnt+startValue-target;
    }
}
//problem2
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int extra=dfs(root.left)+root.val-1+dfs(root.right);
        moves+=Math.abs(extra);
        return extra;
    }
}
//problem3
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        
        int result = 0;
        Queue<NestedInteger> q = new LinkedList<>();

        int level = 1;

        q.addAll(nestedList);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                NestedInteger curr = q.poll();
                if(curr.isInteger()){
                    result += curr.getInteger() * level;
                }else{
                    q.addAll(curr.getList());
                }
            }

            level++;
        }

        return result;
    }
}
