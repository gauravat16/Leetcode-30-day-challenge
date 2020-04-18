package gaurav.leetcode.week2;

import java.util.Iterator;
import java.util.LinkedList;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        LinkedList<Character> sList = buildList(S);
        LinkedList<Character> tList = buildList(T);

        Iterator<Character> i1 = sList.iterator();
        Iterator<Character> i2 = tList.iterator();

        if (sList.size() != tList.size()) {
            return false;
        }

        while (i1.hasNext() && i2.hasNext()) {
            if (i1.next() != i2.next()) {
                return false;
            }
        }

        return true;

    }

    private LinkedList<Character> buildList(String s) {
        LinkedList<Character> list = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (list.size() > 0)
                    list.removeLast();
            } else {
                list.add(c);
            }
        }

        return list;
    }
}
