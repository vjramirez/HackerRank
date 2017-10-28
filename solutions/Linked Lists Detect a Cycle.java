/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }
*/


boolean hasCycle(Node head) {

    if (head == null){return false;}
    boolean flag = false;
    ArrayList<Node> array = new ArrayList<Node>();
    flag = hasCycle1(array,head,flag);
    return flag;
}

boolean hasCycle1(ArrayList<Node> array, Node head1, boolean flag) {
    if (head1.next == null){return false;}
    if(array.contains(head1)){
        flag = true;
        return flag;
    }
    else{
        array.add(head1);
        if (head1.next == null){return flag;}
        else{
            flag = hasCycle1(array, head1.next, flag);
            return flag;
        }
    }
}
