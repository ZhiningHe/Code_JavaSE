package TreeTest;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    StringBuilder str = new StringBuilder();
    public String tree2str(TreeNode t) {

        if(t ==null){
            return str.toString();
        }
        str.append(t.val);
        if(t.left!=null) {
            str.append("(");
            tree2str(t.left);
            str.append(")");
        }else{
            if(t.right ==null)
                str.append("()");
        }
        if(t.right != null){
            str.append("(");
            tree2str(t.right);
            str.append(")");
        }
        return str.toString();
    }
}