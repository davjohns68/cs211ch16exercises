package cs211ch16exercises;

/**
 * Exercises in back of Chapter 16
 * 
 * @Marty of UW
 * @Bill at BCC
 * @version 7
 */
public class Exercises
{
    public static void main(String[] a) {
        LinkedIntList A = new LinkedIntList();
        LinkedIntList B = new LinkedIntList();
        //LinkedList<Integer> B = new LinkedList();
        A.add(1);  A.add(8);   A.add(19);  A.add(4);   A.add(17); A.add(8);
        B.add(1); B.add(1); B.add(1); B.add(3); B.add(3); B.add(4); B.add(6); B.add(9); B.add(15); B.add(15); B.add(23); B.add(23); B.add(23);B.add(40); B.add(40);
        //ListNode A = new ListNode(5);
        //ListNode B = new ListNode(9,A);
        
//        for (ListNode temp = B; temp.next != null; temp=temp.next)
//            System.out.print(" " + temp.data);
        System.out.println(A.toString());
        System.out.println(A.lastIndexOf(8));   // 5
        System.out.println(A.lastIndexOf(47));  // -1
        System.out.println(A.lastIndexOf(17));  // 4
        System.out.println(B);
        System.out.println(B.countDuplicates());    // 7
        System.out.println(A.hasTwoConsecutive());  // false
        System.out.println(B.hasTwoConsecutive());  // true
        System.out.println(A.size());               // 6
        System.out.println(A.deleteBack());         // 8
        System.out.println(A);
        System.out.println(A.size());               // 5
        A.switchPairs();
        System.out.println(A);
        System.out.println(A.min());
        //for (Integer i: B) System.out.print(i.toString() + ", ");
        
        A.stutter();
        System.out.println(A.toString());
        A.stretch(0);
        System.out.println(A);
        A.add(1);  A.add(8);   A.add(19);  A.add(4);   A.add(17); A.add(8);
        A.stretch(6);
        System.out.println(A);
        A.removaAll(8);
        System.out.println(A);
    }
}
