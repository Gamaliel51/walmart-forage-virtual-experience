package datastructure;

import java.util.Arrays;

public class PowerOfTwoMaxHeap {
    public Node max;
    public int power;

    public int getLength(Node[] array){
        int len = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] != null){
                len += 1;
            }
        }
        return len;
    }

    public Node getMaxNode(Node[] array){
        Node max = new Node(0, 5, this.max);
        int length = getLength(array);

        for(int i = 0; i < length; i++){
            if(max.property < array[i].property){
                max = array[i];
            }
        }

        return max;
    }

    public PowerOfTwoMaxHeap(int max_value, int power){
        double temp = Math.pow(2, power);
        this.power = (int)temp;
        this.max = new Node(max_value, this.power, null);
    }

    public Node traverse(Node[] node_array){
        int length = getLength(node_array);
        Node current = new Node(0, power,  max);

        for(int i = 0; i < length; i++){
            int next_len = getLength(node_array[i].children);
            if(next_len < power){
                current = node_array[i];
                break;
            }
            else{
                return traverse(node_array[i].children);
            }
        }

        return current;
    }

    public void insert(int value){
        Node[] top = new Node[1];
        top[0] = this.max;

        Node current_node = traverse(top);
        int length = getLength(current_node.children);
        current_node.children[length] = new Node(value, power, current_node);

        heap_up(current_node.children[length]);
    }

    public void pop_max(){
            Node[] top = new Node[1];
            top[0] = this.max;


            Node current_node = traverse(top);
            int length = getLength(current_node.children);

            if(length != 0){
                this.max.property = current_node.children[length - 1].property;
                current_node.children[length - 1] = null;
            }
            else{
                if(current_node.parent.children[0].equals(current_node)){
                    this.max.property = current_node.property;
                    current_node = null;
                }
                else{
                    int sibling_len = getLength(current_node.parent.children);
                    this.max.property = current_node.parent.children[sibling_len - 2].property;
                    current_node.parent.children[sibling_len - 2] = null;
                }
            }

            heap_down(this.max);

    }

    public void heap_up(Node new_node){

        if(new_node.parent == null){
            return;
        }

        if(new_node.property > new_node.parent.property){
            int temp_new_node = new_node.property;
            new_node.property = new_node.parent.property;
            new_node.parent.property = temp_new_node;

            heap_up(new_node.parent);
        }
    }

    public void heap_down(Node current_node){
        int length = getLength(current_node.children);

        if(length == 0){
            return;
        }

        Node max = getMaxNode(current_node.children);

        if(max.property > current_node.property){
            int temp = current_node.property;
            current_node.property = max.property;
            max.property = temp;
            heap_down(max);
        }

        return;
    }

    public void display(Node current_node, int level){
        if(current_node == null){
            return;
        }
        System.out.println((level+1) + " value: " + current_node.property);
        int len = 0;

        for(int i = 0; i < this.power; i++){
            if(current_node.children[i] != null){
                len += 1;
            }
        }

        if(len == 0){
            return;
        }

        for(int i = 0; i < len; i++){
            System.out.print(current_node.children[i].property + " my parent is " + current_node.children[i].parent.property);
            System.out.println();
        }

        for(int i = 0; i < this.power; i++){
            display(current_node.children[i], level+1);
        }
    }

}
