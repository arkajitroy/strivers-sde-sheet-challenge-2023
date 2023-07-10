import java.util.* ;

class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

class Solution {
	public static int KthLargestNumber(TreeNode<Integer> root, int k) {
		// Write your code here.
		Stack<TreeNode<Integer>> stack = new Stack<>();
		int count = 0;
		int result = -1;

		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.right;
			}

			TreeNode<Integer> node = stack.pop();
			count++;

			if (count == k) {
				result = node.data;
				break;
			}

			root = node.left;
		}

		return result;
	}
}