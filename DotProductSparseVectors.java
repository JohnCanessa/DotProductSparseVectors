import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;


/**
 * 
 */
class SparseVector {
    
    // **** class members ****
    HashMap<Integer, Integer> hm;
    

    /**
     * constructor
     */
    public SparseVector(int[] nums) {

        // **** ****
        this.hm = new HashMap<>();

        // **** populate hash map ****
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                this.hm.put(i, nums[i]);
            }
        }
    }
    

	/**
     * return the dotProduct of two sparse vectors
     */
    public int dotProduct(SparseVector vec) {
        
        // **** initialization ****
        int dp = 0;

        // **** ****
        for (int key : this.hm.keySet()) {
            if (vec.hm.containsKey(key) == true) {
                dp += this.hm.get(key) * vec.hm.get(key);
            }
        }

        // **** return dot product ****
        return dp;
    }
}


/**
 * 
 */
public class DotProductSparseVectors {


    /**
     * Test scaffolding
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read and populate nums1[] ****
        int[] nums1 = Arrays.stream(br.readLine().trim().split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();

        // **** read and populate nums2[] ****
        int[] nums2 = Arrays.stream(br.readLine().trim().split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< nums1: " + Arrays.toString(nums1));
        System.out.println("main <<< nums2: " + Arrays.toString(nums2));

        // **** instantiate two vectors ****
        SparseVector v1 = new SparseVector(nums1);
        SparseVector v2 = new SparseVector(nums2);

        // ???? ????
        System.out.println("main <<< v1: " + v1.hm.toString());
        System.out.println("main <<< v2: " + v2.hm.toString());

        // **** dot product of th etwo vectors ****
        System.out.println("main <<< ans: " + v1.dotProduct(v2));
    }
}