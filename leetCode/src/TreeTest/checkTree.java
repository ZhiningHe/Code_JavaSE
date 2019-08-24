package TreeTest;


/**
 * 检查两棵树是否相同
 * 结构和值都相同
 *
 * 通过
 */
public class checkTree {

    public boolean isSameTree(TreeNode p,TreeNode q){
        //两颗空树
        if(p == null && q==null)
            return true;

        //一颗为空树，另一颗不为空
        if(p == null||q == null)
            return false;

        //p和q都不为空,但值不相等
        if(q.val != p.val)
            return false;

        //判断左树和右树是否相同
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}


