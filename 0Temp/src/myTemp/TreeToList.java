package myTemp;

public class TreeToList {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
	public TreeNode Convert(TreeNode root) {
		if(root==null)return null;
		TreeNode left=Convert(root.left);
		TreeNode head=left;
		if(left==null)head=root;
		else {			
			while(left.right!=null) {
				left=left.right;
			}
			left.right=root;
			root.left=left;
		}
		TreeNode right=Convert(root.right);
		if(right!=null) {
			root.right=right;
			right.left=root;
		}	
		return head;
	}

}
 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}