public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println("Prime numbers up to " + n + ":");
        boolean [] prime = new boolean [n+1];
        prime[0] = false;
        prime[1] = false;
        int index = 2;
        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        } 
        while (index * index <= n) {
            if (prime[index] == true) {
                for (int i = index + 1; i <= n; i++) {
                    if (i % index == 0) {
                        prime[i] = false;
                    }
                }
            }
            index++;
        }
        int counter = 0;
        for (int j = 0; j <= n; j++) {
           if (prime[j] == true) {
            System.out.println(j);
            counter++;
           }
        } 
        int precent = (100 * counter) / n;
        System.out.println("There are " + counter + " primes between 2 and " + n +
                           " (" + precent +"% are primes)");
    }
}