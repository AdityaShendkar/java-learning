
# Third Largest Element in an Array (Optimal Approach)

## 🧠 Steps

1. **Initialize three variables:**
  
   int first = Integer.MIN_VALUE;
   int second = Integer.MIN_VALUE;
   int third = Integer.MIN_VALUE;


2. **Traverse the array:**

   * If `num > first`
     → Shift values:
     `third = second`, `second = first`, `first = num`

   * Else if `num > second`
     → Update:
     `third = second`, `second = num`

   * Else if `num > third`
     → Update:
     `third = num`




## 💻 Java Implementation

```java
public class ThirdLargest {
    public static int findThirdLargest(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num > third) {
                third = num;
            }
        }

        return third;
    }

    public static void main(String[] args) {
        int[] arr = {19, -10, 20, 14, 2, 16, 10};
        System.out.println(findThirdLargest(arr));
    }
}
```

---

## ⏱️ Time Complexity

* **O(n)** → Only one loop through the array

---

## 💾 Space Complexity

* **O(1)** → No extra space used

---
