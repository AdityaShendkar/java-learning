

# 🔁 Reverse Every K Elements in an Array (In-Place)


## 🧠 Approach

1. Traverse the array in steps of `k`
2. For each group:

   * `start = i`
   * `end = min(i + k - 1, n - 1)`
3. Reverse elements between `start` and `end` using two pointers
4. Move to the next group

---

## 💻 Java Code

```java
public class ReverseSubarrayK {

    public static void reverseK(int[] arr, int k) {
        int n = arr.length;

        for (int i = 0; i < n; i += k) {
            int start = i;
            int end = Math.min(i + k - 1, n - 1);

            while (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;

        reverseK(arr, k);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

## ⏱️ Complexity

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(1)` (in-place)

