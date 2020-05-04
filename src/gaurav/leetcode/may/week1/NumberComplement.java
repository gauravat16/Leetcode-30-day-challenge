package gaurav.leetcode.may.week1;

public class NumberComplement {

    public int findComplement(int num) {
        int init = 1, prev = 1;

        while (num > init){
            init = init << 1;
            init = init | prev;
            prev = init;
        }

        return num ^ init;
    }

    public static void main(String[] args) {
        System.out.println(new NumberComplement().findComplement(5));
    }
}
