public class ReverseString {
    public static void main(String[] args) {
        String s = "hello";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.reverse().toString());
    }
}