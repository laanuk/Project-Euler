//use heron's formula to disculde all odd perims eg. 4, 4, 5 triangle is never valid
public class projecteuler94 {
    public static void main(String[] args) {
        long perimtotal = 0L;
        for (long i = 5L; i < 333333333L; i+=2) {

            long num = i * i - ((i-1)/2) * ((i-1)/2);
            long num2 = i * i - ((i+1)/2) * ((i+1)/2);

            long b = (long)(Math.sqrt(num));
            long b2 = (long)(Math.sqrt(num2));

            if (b * b == num) { //is a perfect square
                perimtotal += 3 * i - 1;
            }
            if (b2 * b2 == num2) {
                perimtotal += 3 * i + 1;
            }
        }
        System.out.println("perimtotal is " + perimtotal);
    }
}
