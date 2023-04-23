package datastructure;

public class Node {
    public int property;
    public Node[] children;
    public Node parent;

    public Node(int value, int children, Node parent){
        this.property = value;
        this.children = new Node[children];
        this.parent = parent;
    }



}




//
//    int max = 0;
//    int index = -1;
//
//    int len = 0;
//
//        if(current_node.parent != null){
//                for(int i = 0; i < this.power; i++){
//        if(current_node.parent.children[i] != null){
//        len += 1;
//        }
//        }
//        }
//
//        if(current_node.children[0] == null){
//        if(current_node.parent.children[this.power - 1].equals(current_node) || current_node.parent.children[len + 1] == null){
//        return;
//        }
//        }
//
//        for(int i = 0; i < current_node.children.length; i++){
//        index +=1 ;
//        if(max < current_node.children[i].property){
//        max = current_node.children[i].property;
//        }
//        }
//
//        if(current_node.property < max){
//        int temp = current_node.property;
//        current_node.property = current_node.children[index].property;
//        current_node.children[index].property = temp;
//        heap_down(current_node.children[index]);
//        }
