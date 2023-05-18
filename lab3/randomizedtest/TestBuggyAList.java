package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE

    @Test
    public void testTwo() {
        AList<Integer> lst1 = new AList<>();
        BuggyAList<Integer> lst2 = new BuggyAList<>();
        lst1.addLast(4);
        lst2.addLast(4);
        lst1.addLast(5);
        lst2.addLast(5);
        lst1.addLast(6);
        lst2.addLast(6);
        lst1.removeLast();
        lst2.removeLast();
        for (int i = 0; i < lst2.size(); i++) {
            assertEquals(lst1.get(i), lst2.get(i));
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                if (correct.size()==0||broken.size()==0)
                    continue;
                assertEquals(correct.removeLast(), broken.removeLast());
            } else if (operationNumber == 2) {
                if (correct.size()==0||broken.size()==0)
                    continue;
                assertEquals(correct.getLast(), broken.getLast());
            } else if (operationNumber == 3) {
                assertEquals(correct.size(), broken.size());
            }

        }
    }
}
