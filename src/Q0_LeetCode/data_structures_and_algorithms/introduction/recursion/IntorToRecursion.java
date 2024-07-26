package org.data_structures_and_algorithms.introduction.recursion;

public class IntorToRecursion {

    static long[] fibCache;

    public static void main(String[] args) {

        int n = 10;
        fibCache = new long[n+1];

        // System.out.println( fibFast(n) );

        for ( int i=0; i<=n; i++ ){
            System.out.print( fibFast(i) + "   " );
        }

    }

    public static void recursionMethod(int i){

        if ( i != 4 ) {
            System.out.println("Start of method: " + i);
            recursionMethod(i+1);
            System.out.println("End of method: " + i);
        }
    }

    public static long recursionFib(int n){
        // 0, 1, 1, 2, 3, 5, 8
        // F(n) = F(n-1) + F(n-2)

        // Usually recursive method will blow up entering into an infinity loop causing stack overflow error
        // For every recursive method in java, there should be a base case.
        // inside your method once the condition is met, it will stop calling itself.
        // The base case in this case is, the first fib number is ZERO and the second fib number is ONE.

        // return N if N is less than or equal to ONE, this if check will be used to terminate the recursion loop.
        if ( n <= 1 ) {
            return n;
        }
        return ( recursionFib(n-1) + recursionFib(n-2) );
    }

    public static long fibFast(int n){

        if ( n <= 1 ) {
            return n;
        }

        if ( fibCache[n] != 0 ) {
            return fibCache[n];
        }

        long result = ( recursionFib(n-1) + recursionFib(n-2) );
        fibCache[n] = result;
        return ( result );
    }
}
