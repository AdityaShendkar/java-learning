

* Use two variables:

  * `largest`
  * `secondLargest`
* Traverse the array only once
* Update values based on conditions

---

## 💻 Java Code

```java
public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8, 15};

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } 
            else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
    }
}
```

---

## ⚠️ Edge Cases

* Array has only one element → No second largest
* All elements are same → No second largest
* Negative numbers are handled correctly

---
