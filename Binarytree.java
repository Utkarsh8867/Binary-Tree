import java.util.*;

class Binarytree{

 static class Node{
 int data;
 Node left;
 Node right;
 Node(int data){
 this.data = data;
 this.left = null;
 this.right = null;
}
}

static class Binarttree{
 static int idx =-1;
 public static Node buildTree(int nodes[]){
  idx++;
  if(nodes[idx] == -1){
    return null;
  }
  Node newNode = new Node(nodes[idx]);
  newNode.left = buildTree(nodes);
  newNode.right = buildTree(nodes);

  return newNode;

 } 

public static void preorder(Node root){
 if(root == null){
   return;
  }
 System.out.print(root.data+" ");
 preorder(root.left);
 preorder(root.right);
}

public static void Inorder(Node root){
 if(root == null){
  return;
 }
 Inorder(root.left);
 System.out.print(root.data+" ");
 Inorder(root.right);

}

public static void Postorder(Node root){
 if(root == null){
   return;
  }
  Postorder(root.left);
  Postorder(root.right);
  System.out.print(root.data+" ");
 }

public static void LevelOrderTraversal(Node root){
 if(root == null){
  return;
 }

 Queue<Node> q = new LinkedList<>();
 q.add(root);
 q.add(null);

 while(!q.isEmpty()){
  Node currNode = q.remove();
  if(currNode == null){
   System.out.println();
    if(q.isEmpty()){
     break;
   }else{
     q.add(null);
   }
  }else{
    System.out.print(currNode.data+" ");
    if(currNode.left != null){
      q.add(currNode.left);
    }
    if(currNode.right != null){
      q.add(currNode.right);
   }
  }
 }
}

public static int Height(Node root){
 if( root == null){
  return 0;
 }
 
 int lh = Height(root.left);
 int rh = Height(root.right);
 return Math.max(lh,rh) +1;

}

public static int count(Node root){
  if(root == null){
   return 0;
  }

  int leftcount = count(root.left);
  int rightcount = count(root.right);
return leftcount + rightcount+1;
 }

public static int Sum(Node root){
  if(root == null){
   return 0;
  }

  int leftsum = Sum(root.left);
  int rightsum =Sum(root.right);
  return leftsum + rightsum + root.data;
 }
}

public static void main(String args[]){
 int nodes[]= {100,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1,-1};
Binarttree bt = new Binarttree();
Node root = bt.buildTree(nodes);

System.out.println("Root Data");
System.out.println(root.data);

System.out.println("preorder");

bt.preorder(root);
System.out.println();
System.out.println("Inorder");

bt.Inorder(root);
System.out.println();
System.out.println("Post Order");

bt.Postorder(root);

System.out.println();
System.out.println("Level Order Traversal");
bt.LevelOrderTraversal(root);

System.out.println();
System.out.println("Height");
System.out.println(bt.Height(root));


System.out.println();
System.out.println("count");
System.out.println(bt.count(root));

System.out.println();
System.out.println("Sum");
System.out.println(bt.Sum(root));


}


}