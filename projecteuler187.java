import java.util.*;

public class projecteuler187 {
    public static void main(String[] args) {
        long limit = 100000000L;
        int[] primes = sieveOfEratosthenes(50000001);
        ArrayList<Integer> rawp = new ArrayList<Integer>();
        int count = 0;
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < 50000001; i++) {
            if (primes[i] > 0) {
                rawp.add(primes[i]);
            }
        }

        for (int i = 0; i < 10000; i++) {
            if (primes[i] > 0) {
                al.add(primes[i]);
            }
        }

        for (int i = 0; i < al.size(); i++) {
            for (int j = i; j < rawp.size(); j++) {
                if (((long)al.get(i) * (long)rawp.get(j)) < limit) {
                    count++;
                } else {
                    break;
                }
            }
        }
        System.out.println(count);


    }

    public static int[] sieveOfEratosthenes(int max){
        int[] primeCandidates = new int[max]; //defaults to false
        for(int i=2; i<max; i++ ){primeCandidates[i]=i;}

        for(int i=2; i<Math.sqrt(max);i++){
            if(primeCandidates[i] != 0){
                //all multiples of i*i, except i, are not primeCandidates
                for(int j = i + i; j<max; j=j+i){
                    primeCandidates[j] = 0;
                }
            }
        }
        return primeCandidates;
    }
}
