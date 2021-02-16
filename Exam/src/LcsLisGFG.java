
public class LcsLisGFG {
    // A Java Program to find length of the Longest
// Common Increasing Subsequence (LCIS)


    // Returns the length and the LCIS of two
    // arrays arr1[0..n-1] and arr2[0..m-1]
    static int LCIS(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        // table[j] is going to store length of
        // LCIS ending with arr2[j]. We initialize
        // it as 0,
        int table[] = new int[m];
        for (int j = 0; j < m; j++)
            table[j] = 0;

        // Traverse all elements of arr1[]
        for (int i = 0; i < n; i++) {
            // Initialize current length of LCIS
            int current = 0;

            // For each element of arr1[], trvarse
            // all elements of arr2[].
            for (int j = 0; j < m; j++) {
                // If both the array have same
                // elements. Note that we don't
                // break the loop here.
                if (arr1[i] == arr2[j])
                    if (current + 1 > table[j])
                        table[j] = current + 1;

				/* Now seek for previous smaller
				common element for current
				element of arr1 */
                if (arr1[i] > arr2[j])
                    if (table[j] > current)
                        current = table[j];
            }
        }

        // The maximum value in table[] is out
        // result
        int result = 0;
        for (int i = 0; i < m; i++)
            if (table[i] > result)
                result = table[i];

        return result;
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        int arr1[] = {3, 4, 9, 1};
        int arr2[] = {5, 3, 8, 9, 10, 2, 1};

        int n = arr1.length;
        int m = arr2.length;

        System.out.println("Length of LCIS is " +
                LCIS(arr1, arr2));
    }
}

