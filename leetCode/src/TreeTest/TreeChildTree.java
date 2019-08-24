package TreeTest;


/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 1.遍历s树查找t
 * 2.找到t的根节点在s中的位置，然后开始判断两颗二叉树是否相同
 */
public class TreeChildTree {
    public boolean isSubTree(TreeNode s,TreeNode t){
        boolean flag = false;
        if(s != null){
            //根节点相同
            if(s.val ==t.val){
                //判断两棵树是否相同
                flag = isSameTree(s,t);
            }
            //不相等，继续找
            if(!flag){
                flag = isSubTree(s.left,t) || isSubTree(s.right,t);
            }
        }
        return flag;
    }


    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p == null && q==null){
            return true;
        }
        if(p == null||q == null){
            return false;
        }
        if(q.val != p.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
