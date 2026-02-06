import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String s = "programming";
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for(char c : s.toCharArray()) {
            if(!set.contains(c)) {
                sb.append(c);
                set.add(c);
            }
        }
        System.out.println(sb.toString());
    }
}