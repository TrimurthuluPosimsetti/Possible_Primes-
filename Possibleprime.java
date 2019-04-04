/*474759843857 i need to print total posssible primes from that number*/
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//size of the input integer 
        int v = sc.nextInt();//reading the Integer value
        String s = Integer.toString(v);//coverting into string
        int temp = v, l = 0;
        while (temp > 0) {//finding length of the number
            l = l + 1;
            temp = temp / 10;
        }
        int b[] = new int[l];//creating array to store input value v
        for (int i = 0; i < l; i++) {
            b[i] = Character.getNumericValue(s.charAt(i));//getNumericValue converts character to int 
        }
        int a[] = new int[n];//for storing prime numbers
        int c[] = new int[l];//for storing the output creating c array
        for (int i = 0; i < n; i++) {
            a[i] = 1;
        }
        for (int i = 0; i < l; i++) {//assigning zeros to whole array
            c[i] = 0;
        }
        a[0] = 0;//zero is not prime so assigning zero
        a[1] = 0;//one is not prime or composite so assigning zero
        //sieve of eratosthenes
        for (int i = 2; i < n; i++) {
            if (a[i] == 1) {
                //System.out.println(i);
                for (int j = 2;(i * j) < n; j++) {
                    a[i * j] = 0;//the index value represents the number if number is not prime assign zero
                                  //(Ex:index 6 is equal to number 6 so 6 is not prime assign zero in place of index 6)
                }
            }
        }
        int in = 0;
        for (int i = 0; i < c.length; i++) {
            c[ in ] = b[i];//put b[i] to c array check for all possible primes starts with b[i] value
            if (a[c[0]] == 1) {
                System.out.println(c[0]);
            }
            possiblePrimes(a, c, 1, b);//calling possiblePrimes function with (primes array,output c array,index,original inputvalue)
        }
    }
    public static void possiblePrimes(int a[], int c[], int in , int b[]) {
        for (int i = 0; i < c.length; i++) {
            if (place(c, b[i])) {//checks wheather b[i] should be placed in c array or not
                c[ in ] = b[i];
                String s = "";//declaring an empty string
                for (int j = 0; j < c.length; j++) {
                    if (c[j] != 0) {
                        s = s + String.valueOf(c[j]);//converting integer array to string
                    }
                }
                //System.out.println(s);
                //System.out.println(s+" "+c.length);
                if (s != "") {//base case
                    if (a[Integer.parseInt(s)] == 1) {//checks wheather it is prime or not 
                        System.out.println(s);//if prime prints output
                    }
                } else {
                    possiblePrimes(a, c, in +1, b);//calling function recursively
                    c[ in +1] = 0;//after backtrack the modified value replaced with 0 
                }
            }
        }
    }
  
    /*returns true if v is not in c array else return false*/
    public static boolean place(int c[], int v) {
        for (int i = 0; i < c.length; i++) {
            if (c[i] == v) {
                return false;
            }
        }
        return true;
    }
}
