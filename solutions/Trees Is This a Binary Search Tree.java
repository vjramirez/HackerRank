/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/

    boolean checkBST(Node root) {
        return revisarBST(root,true);
    }

    boolean revisarBST(Node root,boolean flag){
        if(!flag){ return false; }
        if(root.left != null){
            if(root.data <= valor(root.left)){
                flag = false;
            }
            if(!flag){ return false; }
            flag = genealogia("left", root.left, root.data, flag );
            flag = revisarBST(root.left, flag);

        }
        if(root.right != null){
            if (root.data >= valor(root.right)){
                flag = false;
            }
            if(!flag){ return false; }
            flag = genealogia("right", root.right, root.data, flag );
            flag = revisarBST(root.right, flag);
        }
        if(root.right != null && root.left != null){
            if (valor(root.right) == valor(root.left)){
                flag = false;
            }
        }

        return flag;
    }

    boolean genealogia(String direction, Node nodo, int value, boolean flag){
        if(direction.equals("right")){
            if(value >= nodo.data){
                flag = false;
            }
        }
        else{
            if(value <= nodo.data){
                flag = false;
            }
        }
        if(nodo.right != null){
            flag = genealogia(direction, nodo.right, value, flag);
        }
        if(nodo.left != null){
            flag = genealogia(direction, nodo.left, value, flag);
        }

        return flag;
    }


    int valor(Node nodo){
        return nodo.data;
    }
