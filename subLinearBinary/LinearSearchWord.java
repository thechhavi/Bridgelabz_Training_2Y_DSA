public class LinearSearchWord {
    public static void main(String[] args) {
        String[] sentences = {"I love Java", "Python is great"};
        String word = "Java";

        for(String s : sentences) {
            if(s.contains(word)) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Not Found");
    }
}