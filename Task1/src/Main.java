import datastructure.Node;
import datastructure.PowerOfTwoMaxHeap;

public class Main {
    public static void main(String[] args) {
        PowerOfTwoMaxHeap a = new PowerOfTwoMaxHeap(10, 2);

        a.insert(20);
        a.insert(13);
        a.insert(14);
        a.insert(15);
        a.insert(30);
        a.display(a.max, 0);
        a.insert(40);
        a.pop_max();
        a.display(a.max, 0);
    }
}