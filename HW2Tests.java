import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * This is a basic set of unit tests for CircularSinglyLinkedList.
 *
 * Passing these tests doesn't guarantee any grade on these assignments. These
 * student JUnits that we provide should be thought of as a sanity check to
 * help you get started on the homework and writing JUnits in general.
 *
 * We highly encourage you to write your own set of JUnits for each homework
 * to cover edge cases you can think of for each data structure. Your code must
 * work correctly and efficiently in all cases, which is why it's important
 * to write comprehensive tests to cover as many cases as possible.
 *
 * @author Aryan Shah
 * @version 1.0
 */
public class HW2Tests {

    private static final int TIMEOUT = 200;
    private CircularSinglyLinkedList<String> list;

    @Before
    public void setUp() {
        list = new CircularSinglyLinkedList<>();
    }

    @Test(timeout = TIMEOUT)
    public void testInitialization() {
        assertEquals(0, list.size());
        assertNull(list.getHead());
    }

    @Test(timeout = TIMEOUT)
    public void testAddAtIndex() {
        list.addAtIndex(0, "2a");   // 2a
        list.addAtIndex(0, "1a");   // 1a, 2a
        list.addAtIndex(2, "4a");   // 1a, 2a, 4a
        list.addAtIndex(2, "3a");   // 1a, 2a, 3a, 4a
        list.addAtIndex(0, "0a");   // 0a, 1a, 2a, 3a, 4a

        assertEquals(5, list.size());

        CircularSinglyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertEquals("0a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("1a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("2a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("3a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("4a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals(list.getHead(), cur);
    }

    @Test(timeout = TIMEOUT)
    public void testAddToFront() {
        list.addToFront("4a");  // 4a
        list.addToFront("3a");  // 3a, 4a
        list.addToFront("2a");  // 2a, 3a, 4a
        list.addToFront("1a");  // 1a, 2a, 3a, 4a
        list.addToFront("0a");  // 0a, 1a, 2a, 3a, 4a

        assertEquals(5, list.size());

        CircularSinglyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertEquals("0a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("1a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("2a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("3a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("4a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals(list.getHead(), cur);
    }

    @Test(timeout = TIMEOUT)
    public void testAddToBack() {
        list.addToBack("0a");   // 0a
        list.addToBack("1a");   // 0a, 1a
        list.addToBack("2a");   // 0a, 1a, 2a
        list.addToBack("3a");   // 0a, 1a, 2a, 3a
        list.addToBack("4a");   // 0a, 1a, 2a, 3a, 4a

        assertEquals(5, list.size());

        CircularSinglyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertEquals("0a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("1a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("2a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("3a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("4a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals(list.getHead(), cur);
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndex() {
        String temp = "2a";

        list.addAtIndex(0, "0a");   // 0a
        list.addAtIndex(1, "1a");   // 0a, 1a
        list.addAtIndex(2, temp);   // 0a, 1a, 2a
        list.addAtIndex(3, "3a");   // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a");   // 0a, 1a, 2a, 3a, 4a
        list.addAtIndex(5, "5a");   // 0a, 1a, 2a, 3a, 4a, 5a
        assertEquals(6, list.size());

        assertSame(temp, list.removeAtIndex(2));    // 0a, 1a, 3a, 4a, 5a

        assertEquals(5, list.size());

        CircularSinglyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertEquals("0a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("1a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("3a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("4a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("5a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals(list.getHead(), cur);
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromFront() {
        String temp = "0a";

        list.addAtIndex(0, temp);   // 0a
        list.addAtIndex(1, "1a");   // 0a, 1a
        list.addAtIndex(2, "2a");   // 0a, 1a, 2a
        list.addAtIndex(3, "3a");   // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a");   // 0a, 1a, 2a, 3a, 4a
        list.addAtIndex(5, "5a");   // 0a, 1a, 2a, 3a, 4a, 5a
        assertEquals(6, list.size());

        assertSame(temp, list.removeFromFront());   // 1a, 2a, 3a, 4a, 5a

        assertEquals(5, list.size());

        CircularSinglyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertEquals("1a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("2a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("3a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("4a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("5a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals(list.getHead(), cur);
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromBack() {
        String temp = "5a";

        list.addAtIndex(0, "0a");   // 0a
        list.addAtIndex(1, "1a");   // 0a, 1a
        list.addAtIndex(2, "2a");   // 0a, 1a, 2a
        list.addAtIndex(3, "3a");   // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a");   // 0a, 1a, 2a, 3a, 4a
        list.addAtIndex(5, temp);   // 0a, 1a, 2a, 3a, 4a, 5a
        assertEquals(6, list.size());

        assertSame(temp, list.removeFromBack());    // 0a, 1a, 2a, 3a, 4a

        assertEquals(5, list.size());

        CircularSinglyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertEquals("0a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("1a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("2a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("3a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("4a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals(list.getHead(), cur);
    }

    @Test(timeout = TIMEOUT)
    public void testGet() {
        list.addAtIndex(0, "0a");   // 0a
        list.addAtIndex(1, "1a");   // 0a, 1a
        list.addAtIndex(2, "2a");   // 0a, 1a, 2a
        list.addAtIndex(3, "3a");   // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a");   // 0a, 1a, 2a, 3a, 4a
        assertEquals(5, list.size());

        assertEquals("0a", list.get(0));
        assertEquals("1a", list.get(1));
        assertEquals("2a", list.get(2));
        assertEquals("3a", list.get(3));
        assertEquals("4a", list.get(4));
    }

    @Test(timeout = TIMEOUT)
    public void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.addAtIndex(0, "0a");   // 0a
        list.addAtIndex(1, "1a");   // 0a, 1a
        list.addAtIndex(2, "2a");   // 0a, 1a, 2a
        list.addAtIndex(3, "3a");   // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a");   // 0a, 1a, 2a, 3a, 4a
        assertEquals(5, list.size());

        assertFalse(list.isEmpty());
    }

    @Test(timeout = TIMEOUT)
    public void testClear() {
        list.addAtIndex(0, "0a");   // 0a
        list.addAtIndex(1, "1a");   // 0a, 1a
        list.addAtIndex(2, "2a");   // 0a, 1a, 2a
        list.addAtIndex(3, "3a");   // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a");   // 0a, 1a, 2a, 3a, 4a
        assertEquals(5, list.size());

        list.clear();

        assertEquals(0, list.size());
        assertNull(list.getHead());
    }

    @Test(timeout = TIMEOUT)
    public void testLastOccurrence() {
        String temp = "2a";

        list.addAtIndex(0, "0a");   // 0a
        list.addAtIndex(1, "1a");   // 0a, 1a
        list.addAtIndex(2, "2a");   // 0a, 1a, 2a
        list.addAtIndex(3, temp);   // 0a, 1a, 2a, 2a
        list.addAtIndex(4, "3a");   // 0a, 1a, 2a, 2a, 3a
        list.addAtIndex(5, "4a");   // 0a, 1a, 2a, 2a, 3a, 4a
        assertEquals(6, list.size());

        assertSame(temp, list.removeLastOccurrence("2a")); // 0a, 1a, 2a, 3a, 4a
        assertEquals(5, list.size());

        CircularSinglyLinkedListNode<String> cur = list.getHead();
        assertNotNull(cur);
        assertEquals("0a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("1a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("2a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("3a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals("4a", cur.getData());

        cur = cur.getNext();
        assertNotNull(cur);
        assertEquals(list.getHead(), cur);
    }

    @Test(timeout = TIMEOUT)
    public void testToArray() {
        list.addAtIndex(0, "0a");   // 0a
        list.addAtIndex(1, "1a");   // 0a, 1a
        list.addAtIndex(2, "2a");   // 0a, 1a, 2a
        list.addAtIndex(3, "3a");   // 0a, 1a, 2a, 3a
        list.addAtIndex(4, "4a");   // 0a, 1a, 2a, 3a, 4a
        assertEquals(5, list.size());

        String[] expected = new String[5];
        expected[0] = "0a";
        expected[1] = "1a";
        expected[2] = "2a";
        expected[3] = "3a";
        expected[4] = "4a";
        assertArrayEquals(expected, list.toArray());
    }

    @Test(timeout = TIMEOUT)
    public void testAddAtIndexExceptions() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.addAtIndex(-6, "0a");
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.addAtIndex(1000, "0a");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            list.addAtIndex(0, null);
        });
    }

    @Test(timeout = TIMEOUT)
    public void testAddAtIndexIfHeadNull() {
        list.addAtIndex(0, "0a");   // 0a
        assertEquals(1, list.size());
        CircularSinglyLinkedListNode<String> first = list.getHead();
        assertEquals(first.getData(), "0a"); //head is right
        assertEquals(first.getNext().getData(), "0a"); //that head points to itself
    }

    @Test(timeout = TIMEOUT)
    public void testAddAtIndex0() {
        list.addAtIndex(0, "0a");
        list.addAtIndex(1, "1a");
        list.addAtIndex(2, "2a");
        list.addAtIndex(3, "3a");
        list.addAtIndex(4, "4a");
        list.addAtIndex(5, "5a");
        list.addAtIndex(0, "new0a");

        assertEquals(7, list.size()); //right size
        CircularSinglyLinkedListNode<String> first = list.getHead();
        assertEquals(first.getData(), "new0a"); //that head is right
        assertEquals(first.getNext().getData(), "0a"); //that head next pointer is right
    }

    @Test(timeout = TIMEOUT)
    public void testAddAtIndexSize() {
        list.addAtIndex(0, "0a");
        list.addAtIndex(1, "1a");
        list.addAtIndex(2, "2a");
        list.addAtIndex(3, "3a");
        list.addAtIndex(4, "4a");
        list.addAtIndex(5, "5a");

        int listSize = list.size();
        list.addAtIndex(listSize, "6a");

        assertEquals(7, list.size()); //right size
        CircularSinglyLinkedListNode<String> head = list.getHead();
        CircularSinglyLinkedListNode<String> curr = list.getHead();
        while (curr.getNext() != list.getHead()) {
            curr = curr.getNext();
        }

        assertEquals(curr.getNext(), head); //that last one points to head
    }

    @Test(timeout = TIMEOUT)
    public void testAddToFrontException() {
        list.addAtIndex(0, "0a");
        list.addAtIndex(1, "1a");
        list.addAtIndex(2, "2a");
        list.addAtIndex(3, "3a");
        list.addAtIndex(4, "4a");
        list.addAtIndex(5, "5a");

        assertThrows(IllegalArgumentException.class, () -> {
            list.addToFront(null);
        });
    }

    @Test(timeout = TIMEOUT)
    public void testAddToFrontEmptyList() {
        list.addToFront("0a");

        assertEquals(list.size(), 1); //right size
        assertEquals(list.getHead().getData(), "0a"); //that head is right
        assertEquals(list.getHead().getNext().getData(), "0a"); //that head points to itself
    }

    @Test(timeout = TIMEOUT)
    public void testAddToFrontMultipleTimes() {
        list.addToFront("0a");
        list.addToFront("1a");
        list.addToFront("2a");
        list.addToFront("3a");
        list.addToFront("4a");
        list.addToFront("5a");

        //should be a reverse order list: where head is 5a

        assertEquals(list.size(), 6); //right size
        assertEquals(list.getHead().getData(), "5a"); //right head
        assertEquals(list.getHead().getNext().getData(), "4a"); //right pointer from head
    }

    @Test(timeout = TIMEOUT)
    public void testAddToBackException() {
        list.addAtIndex(0, "0a");
        list.addAtIndex(1, "1a");
        list.addAtIndex(2, "2a");
        list.addAtIndex(3, "3a");
        list.addAtIndex(4, "4a");
        list.addAtIndex(5, "5a");

        assertThrows(IllegalArgumentException.class, () -> {
            list.addToBack(null);
        });
    }

    @Test(timeout = TIMEOUT)
    public void testAddToBackEmptyList() {
        list.addToBack("0a");

        assertEquals(list.size(), 1); //right size
        assertEquals(list.getHead().getData(), "0a"); //that head is right
        assertEquals(list.getHead().getNext().getData(), "0a"); //that head points to itself
    }

    @Test(timeout = TIMEOUT)
    public void testAddToBackOneElement() {
        list.addAtIndex(0,"0a");
        list.addToBack("1a");

        assertEquals(list.size(), 2); //right size
        assertEquals(list.getHead().getData(), "0a"); //right head
        assertEquals(list.getHead().getNext().getData(), "1a"); //right data added
    }

    @Test(timeout = TIMEOUT)
    public void testAddToBackMultipleTimes() {
        list.addToBack("0a");
        list.addToBack("1a");
        list.addToBack("2a");
        list.addToBack("3a");
        list.addToBack("4a");
        list.addToBack("5a");

        //proper ordered list

        assertEquals(list.size(), 6); //right size
        assertEquals(list.getHead().getData(), "0a"); //right head

        CircularSinglyLinkedListNode<String> curr = list.getHead();

        while (curr.getNext() != list.getHead()) {
            curr = curr.getNext(); //gets last node
        }

        assertEquals(curr.getNext(), list.getHead()); //last one points to head
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndexException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.removeAtIndex(-5);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.removeAtIndex(0);
        });

        list.addAtIndex(0, "0a");
        list.addAtIndex(1, "1a");
        list.addAtIndex(2, "2a");
        list.addAtIndex(3, "3a");
        list.addAtIndex(4, "4a");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.removeAtIndex(5);
        });
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndexOneElement() {
        list.addAtIndex(0, "0a");

        list.removeAtIndex(0);

        assertEquals(list.size(), 0); //right size
        assertEquals(list.getHead(), null);
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndexZero() {

        list.addAtIndex(0, "0a");
        list.addAtIndex(1, "1a");
        list.addAtIndex(2, "2a");
        list.addAtIndex(3, "3a");
        list.addAtIndex(4, "4a");
        list.addAtIndex(5, "5a");

        list.removeAtIndex(0);

        assertEquals(list.size(), 5); //right size
        assertEquals(list.getHead().getData(), "1a"); //checks head
        assertEquals(list.getHead().getNext().getData(), "2a"); //checks head.next
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveAtIndexMultipleTimes() {

        list.addAtIndex(0, "0a");
        list.addAtIndex(1, "1a");
        list.addAtIndex(2, "2a");
        list.addAtIndex(3, "3a");
        list.addAtIndex(4, "4a");
        list.addAtIndex(5, "5a");

        list.removeAtIndex(0);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.removeAtIndex(5); //as size decreased so checks if exception is thrown now
        });

        list.removeAtIndex(0);
        list.removeAtIndex(2);
        list.removeAtIndex(1);

        assertEquals(list.size(), 2); //right size
        assertEquals(list.getHead().getData(), "2a"); //checks head
        assertEquals(list.getHead().getNext().getData(), "5a"); //checks head.next

        assertEquals(list.removeAtIndex(0), "2a"); //checks if right data is returned when removed
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromFrontAndBackException() {
        assertThrows(NoSuchElementException.class, () -> {
            list.removeFromFront(); //remove from empty list
        });

        assertThrows(NoSuchElementException.class, () -> {
            list.removeFromBack(); //remove from empty list
        });
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromBackOneElement() {

        list.addAtIndex(0, "0a");

        assertEquals(list.removeFromBack(), "0a");

        assertEquals(list.size(), 0); //right size
        assertEquals(list.getHead(), null);
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveFromBackMultipleTimes() {

        list.addAtIndex(0, "0a");
        list.addAtIndex(1, "1a");
        list.addAtIndex(2, "2a");
        list.addAtIndex(3, "3a");
        list.addAtIndex(4, "4a");
        list.addAtIndex(5, "5a");

        assertEquals(list.removeFromBack(), "5a");

        list.removeFromBack();
        list.removeFromBack();

        assertEquals(list.size(), 3); //right size
        assertEquals(list.getHead().getData(), "0a");
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveLastOccurrenceExceptions() {

        assertThrows(IllegalArgumentException.class, ()-> {
            list.removeLastOccurrence(null); //null data passed in
        });

        assertThrows(NoSuchElementException.class, ()-> {
            list.removeLastOccurrence("0a"); //if head is null
        });

        list.addAtIndex(0, "0a");

        assertThrows(NoSuchElementException.class, ()-> {
            list.removeLastOccurrence("1a"); //if 1 element list and head isn't it
        });

        list.addAtIndex(0, "0a");
        list.addAtIndex(1, "1a");
        list.addAtIndex(2, "2a");
        list.addAtIndex(3, "3a");
        list.addAtIndex(4, "4a");

        assertThrows(NoSuchElementException.class, ()-> {
            list.removeLastOccurrence("5a"); //if element not found
        });
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveLastOccurrenceBackFrontTheSame() {

        list.addAtIndex(0, "1a");
        list.addAtIndex(1, "2a");
        list.addAtIndex(2, "3a");
        list.addAtIndex(3, "4a");
        list.addAtIndex(4, "1a");

        list.removeLastOccurrence("1a"); //1 is at back and front both though

        assertEquals(list.getHead().getData(), "1a"); //1 at end should be removed, head stays intact
        assertEquals(list.size(), 4); //checks right size
    }

    @Test(timeout = TIMEOUT)
    public void testRemoveLastOccurrenceIsHead() {

        list.addAtIndex(0, "1a");
        list.addAtIndex(1, "2a");
        list.addAtIndex(2, "3a");
        list.addAtIndex(3, "4a");
        list.addAtIndex(4, "5a");

        list.removeLastOccurrence("1a"); //1 is the head

        assertEquals(list.getHead().getData(), "2a"); //head should be changed
        assertEquals(list.size(), 4); //checks right size
    }

}
