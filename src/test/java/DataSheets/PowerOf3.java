package DataSheets;

public class PowerOf3 {
    public static void main(String[] args) {
        System.out.println(checking(81));
    }

    public static boolean checking(int n){
        return n>0 && Math.pow(3,19)%n==0;
    }
}
