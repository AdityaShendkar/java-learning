# Rotate an Array by `d` Positions - Left Rotation

## Problem Statement

Given an array of integers `arr[]` of size `n`, rotate the array elements to the **left by `d` positions**.

### Example 1

**Input:**

```text
arr[] = [1, 2, 3, 4, 5, 6]
d = 2
```

**Output:**

```text
[3, 4, 5, 6, 1, 2]
```

### Explanation

After the first left rotation:

```text
[2, 3, 4, 5, 6, 1]
```

After the second left rotation:

```text
[3, 4, 5, 6, 1, 2]
```

Therefore, the final array is:

```text
[3, 4, 5, 6, 1, 2]
```

---

## Example 2

**Input:**

```text
arr[] = [1, 2, 3]
d = 4
```

**Output:**

```text
[2, 3, 1]
```

### Explanation

The array is rotated one position at a time:

```text
1st rotation → [2, 3, 1]
2nd rotation → [3, 1, 2]
3rd rotation → [1, 2, 3]
4th rotation → [2, 3, 1]
```

So the final result is:

```text
[2, 3, 1]
```

---

# Naive Approach: Rotate One by One

## Idea

We rotate the array **one position to the left** repeatedly.

For every rotation:

1. Store the first element in a temporary variable.
2. Shift every remaining element one position to the left.
3. Put the first element at the last position.
4. Repeat this process `d` times.

### Example

Consider:

```text
arr = [1, 2, 3, 4, 5, 6]
d = 2
```

### First Rotation

Store:

```text
first = 1
```

Shift elements left:

```text
[2, 3, 4, 5, 6, 1]
```

### Second Rotation

Store:

```text
first = 2
```

Shift elements left:

```text
[3, 4, 5, 6, 1, 2]
```

Final result:

```text
[3, 4, 5, 6, 1, 2]
```

---

# Java Code

```java
import java.util.Arrays;

class Code {

    // Function to left rotate array by d positions
    static void rotateArr(int[] arr, int d) {

        int n = arr.length;

        // Repeat the rotation d times
        for (int i = 0; i < d; i++) {

            // Store the first element
            int first = arr[0];

            // Shift elements one position to the left
            for (int j = 0; j < n - 1; j++) {
                arr[j] = arr[j + 1];
            }

            // Put the first element at the end
            arr[n - 1] = first;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};
        int d = 2;

        rotateArr(arr, d);

        System.out.println(Arrays.toString(arr));
    }
}
```

## Output

```text
[3, 4, 5, 6, 1, 2]
```

---

# Dry Run

Given:

```text
arr = [1, 2, 3, 4, 5, 6]
d = 2
```

### Iteration 1

```text
first = arr[0]
first = 1
```

Shift:

```text
arr[0] = arr[1] → 2
arr[1] = arr[2] → 3
arr[2] = arr[3] → 4
arr[3] = arr[4] → 5
arr[4] = arr[5] → 6
```

Put `first` at the end:

```text
arr[5] = 1
```

Array becomes:

```text
[2, 3, 4, 5, 6, 1]
```

### Iteration 2

```text
first = arr[0]
first = 2
```

Shift:

```text
[3, 4, 5, 6, 1, 1]
```

Put `first` at the end:

```text
[3, 4, 5, 6, 1, 2]
```

### Final Answer

```text
[3, 4, 5, 6, 1, 2]
```

---

# Complexity Analysis

Let:

* `n` = size of the array
* `d` = number of rotations

For each rotation, we shift `n - 1` elements.

Therefore:

### Time Complexity

```text
O(n × d)
```

### Space Complexity

```text
O(1)
```

Only one extra variable `first` is used.

---

# Rotate an Array by `d` Positions - Using Temporary Array

## Better Approach

### Time Complexity: `O(n)`

### Space Complexity: `O(n)`

---

## Idea

Instead of rotating the array one position at a time, we can use a **temporary array**.

When an array is rotated to the left by `d` positions:

```text
Original:
[1, 2, 3, 4, 5, 6]

d = 2

After left rotation:
[3, 4, 5, 6, 1, 2]
```

The array can be divided into two parts:

```text
[1, 2 | 3, 4, 5, 6]
  ↑          ↑
first d     remaining n-d elements
elements
```

After left rotation:

```text
[3, 4, 5, 6 | 1, 2]
```

So:

1. Copy the elements from index `d` to the end into the beginning of `temp`.
2. Copy the first `d` elements into the remaining positions of `temp`.
3. Copy `temp` back into the original array.

---

# Example

Given:

```text
arr = [1, 2, 3, 4, 5, 6]
d = 2
n = 6
```

### Step 1: Copy elements from index `d`

We copy:

```text
arr[d] → arr[2] → 3
arr[3] → 4
arr[4] → 5
arr[5] → 6
```

So:

```text
temp = [3, 4, 5, 6, _, _]
```

---

### Step 2: Copy the first `d` elements

The first `d = 2` elements are:

```text
[1, 2]
```

Put them at the end of `temp`:

```text
temp = [3, 4, 5, 6, 1, 2]
```

---

### Step 3: Copy `temp` back to `arr`

```text
arr = [3, 4, 5, 6, 1, 2]
```

Therefore, the final rotated array is:

```text
[3, 4, 5, 6, 1, 2]
```

---

# Java Implementation

```java
import java.util.Arrays;

class Code {

    // Function to left rotate the array by d positions
    static void rotateArr(int[] arr, int d) {

        int n = arr.length;

        // Handle case when d > n
        d = d % n;

        // Temporary array
        int[] temp = new int[n];

        // Copy elements from index d to the beginning of temp
        for (int i = 0; i < n - d; i++) {
            temp[i] = arr[d + i];
        }

        // Copy first d elements to the end of temp
        for (int i = 0; i < d; i++) {
            temp[n - d + i] = arr[i];
        }

        // Copy temp back to original array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};
        int d = 2;

        rotateArr(arr, d);

        // Print the rotated array
        System.out.println(Arrays.toString(arr));
    }
}
```

## Output

```text
[3, 4, 5, 6, 1, 2]
```

---

# Dry Run

### Input

```text
arr = [1, 2, 3, 4, 5, 6]
d = 2
```

Here:

```text
n = 6
d = 2
```

First calculate:

```java
d = d % n;
```

Therefore:

```text
d = 2 % 6
d = 2
```

---

### First Loop

```java
for (int i = 0; i < n - d; i++) {
    temp[i] = arr[d + i];
}
```

Since:

```text
n - d = 6 - 2 = 4
```

The loop executes 4 times.

| `i` | `arr[d + i]` | Value | `temp`               |
| --: | ------------ | ----: | -------------------- |
|   0 | `arr[2]`     |     3 | `[3, _, _, _, _, _]` |
|   1 | `arr[3]`     |     4 | `[3, 4, _, _, _, _]` |
|   2 | `arr[4]`     |     5 | `[3, 4, 5, _, _, _]` |
|   3 | `arr[5]`     |     6 | `[3, 4, 5, 6, _, _]` |

After the first loop:

```text
temp = [3, 4, 5, 6, _, _]
```

---

### Second Loop

```java
for (int i = 0; i < d; i++) {
    temp[n - d + i] = arr[i];
}
```

Here:

```text
n - d = 4
```

| `i` | `arr[i]` | Position in `temp` | Value |
| --: | -------: | -----------------: | ----: |
|   0 | `arr[0]` |          `temp[4]` |     1 |
|   1 | `arr[1]` |          `temp[5]` |     2 |

Now:

```text
temp = [3, 4, 5, 6, 1, 2]
```

---

### Third Loop

```java
for (int i = 0; i < n; i++) {
    arr[i] = temp[i];
}
```

The temporary array is copied back:

```text
arr = [3, 4, 5, 6, 1, 2]
```

---

# Why Do We Use `d % n`?

Consider:

```text
arr = [1, 2, 3]
d = 4
```

Array size:

```text
n = 3
```

Instead of rotating 4 times:

```java
d = d % n;
```

becomes:

```text
d = 4 % 3
d = 1
```

So rotating left by `4` positions is equivalent to rotating left by `1` position.

```text
[1, 2, 3]
     ↓ d = 4
[2, 3, 1]
```

---

# Complexity Analysis

Let `n` be the size of the array.

### Time Complexity

There are three loops:

```text
First loop  → O(n - d)
Second loop → O(d)
Third loop  → O(n)
```

Therefore:

```text
O(n - d) + O(d) + O(n)
= O(n)
```

### Final Time Complexity

```text
O(n)
```

### Space Complexity

We create a temporary array of size `n`:

```java
int[] temp = new int[n];
```

Therefore:

```text
O(n)
```

---

# Comparison with Naive Approach

| Approach           |       Time |  Space |
| ------------------ | ---------: | -----: |
| Rotate One by One  | `O(n × d)` | `O(1)` |
| Temporary Array    |     `O(n)` | `O(n)` |
| Juggling Algorithm |     `O(n)` | `O(1)` |
| Reversal Algorithm |     `O(n)` | `O(1)` |

---