public class StringBufferConcat {
    public static void main(String[] args) {
        String[] arr = {"Hello", " ", "World"};
        StringBuffer sb = new StringBuffer();

        for(String s : arr) {
            sb.append(s);
        }
        System.out.println(sb.toString());
    }
}