package com.wheat.algorithm.base;

import cn.hutool.core.bean.BeanUtil;

import java.util.*;

/**
 * @author maij
 * @description:
 * @date 2024-04-22 17:27
 **/
public class Test {

    public static void main(String[] args) {

//        int[] nums = {2, 1};
//        String s = "a";
//        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
//        rotate(matrix);
//        System.out.println(Arrays.deepToString(matrix));
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(matrix, 20));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public static boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, line = matrix[0].length - 1;
        int c = 0, column = matrix.length - 1;
        while (l <= line && c <= column) {
            line = findLastLE(target, matrix, l, line, false, l);
            if (line == -1) {
                return false;
            }
            if (matrix[l][line] == target) {
                return true;
            }
            column = findLastLE(target, matrix, c, column, true, c);
            if (column == -1) {
                return false;
            }
            if (matrix[column][c] == target) {
                return true;
            }
            l++; c++;
        }
        return false;
    }

    private static int findLastLE(int target, int[][] matrix, int left, int right, boolean column, int index) {
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = column ? matrix[mid][index] : matrix[index][mid];
            if (value <= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    public static void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int n = matrix.length;
        int f = (matrix.length + 1)/ 2;
        for (int i = 0; i < f; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int t1 = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = matrix[i][j];

                int t2 = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = t1;

                int t3 = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = t2;

                matrix[i][j] = t3;
            }
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        int f = Math.min((matrix.length + 1)/ 2, (matrix[0].length + 1) / 2);
        for (int i = 0; i < f; i++) {
            int j = i;
            for (; j < m - i; j++) {
                res.add(matrix[i][j]);
            }
            j--;
            int k = i + 1;
            if (k >= n - i) {
                break;
            }
            for (; k < n - i; k++) {
                res.add(matrix[k][j]);
            }
            k--;
            if (j <= i) {
                break;
            }
            for (; j > i; j--) {
                res.add(matrix[k][j - 1]);
            }
            k--;
            for (; k > i; k--) {
                res.add(matrix[k][j]);
            }
        }
        return res;
    }

    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1) {
                nums[i] = nums.length + 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static int[] productExceptSelf1(int[] nums) {
        int[] answer = new int[nums.length];
        answer[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[nums.length - i - 1] = answer[nums.length - i] * nums[nums.length - i];
        }
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            answer[i] = prefix * answer[i];
            prefix = prefix * nums[i];
        }
        return answer;
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
            suffix[nums.length - i - 1] = suffix[nums.length - i] * nums[nums.length - i];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }

    public static void rotate1(int[] nums, int k) {
//        int length = nums.length;
//        if (k > length) {
//            k = k % length;
//        }
//        int i = 1;
//        int j = k + k - i;
//        int l = nums[k - i];
//        int r = nums[length - i];
//        nums[length - i] = nums[j];
//        nums[k - i] = r;
//        nums[j] = l;
//        for(i = 2; i < k; i++) {
//            l = nums[k - i];
//            j = k + k - i;
//            if (j >= length) {
//
//            }
//            r = nums[j > length - i ? length - i : ];
//        }
    }

    public static void rotate(int[] nums, int k) {
        int[] arr = new int[k];
        if (k > nums.length) {
            k = k % nums.length;
        }
        System.arraycopy(nums, nums.length - k, arr, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(arr, 0, nums, 0, arr.length);
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Deque<Integer> deque = new LinkedList<>();
        deque.add(intervals[0][0]);
        deque.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            Integer last = deque.getLast();
            if (intervals[i][0] <= last) {
                deque.pollLast();
                deque.add(Math.max(last, intervals[i][1]));
            } else {
                deque.add(intervals[i][0]);
                deque.add(intervals[i][1]);
            }
        }
        int[][] result = new int[deque.size() / 2][2];
        int i = 0;
        while (!deque.isEmpty()) {
            result[i++] = new int[]{deque.pop(), deque.pop()};
        }
        return result;
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int prevSum = 0;
        for (int num : nums) {
            if (prevSum < 0) {
                prevSum = 0;
            }
            prevSum += num;
            max = Math.max(max, prevSum);
        }
        return max;
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] arr = new int[128];
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i)]++;
        }
        int resultIndex = -1;
        int min = Integer.MAX_VALUE;
        int total = t.length();
        CharLinkedMap linkedMap = new CharLinkedMap();
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (arr[c] == 0) {
                continue;
            }
            linkedMap.put(c, j);
            int n = arr[c];
            if (n > 0) {
                if (n == 1) {
                    arr[c] = -1;
                } else {
                    arr[c]--;
                }
                total--;
            } else {
                linkedMap.removeFirst(c);
            }
            if (total == 0) {
                int i = linkedMap.pollFirst();
                arr[s.charAt(i)] = 1;
                total++;
                int l = j - i + 1;
                if (l < min) {
                    min = l;
                    resultIndex = i;
                }
            }
        }
        return resultIndex == -1 ? "" : s.substring(resultIndex, resultIndex + min);
    }

    public static Node reversal1(Node root) {
        Stack<Integer> stack = new Stack<>();
        Node node = root;
        while (node != null) {
            stack.push(node.value);
            node = node.next;
        }
        Node newRoot = new Node();
        Node current = newRoot;
        while (!stack.isEmpty() && stack.peek() != null) {
            Integer pop = stack.pop();
            current.next = new Node(pop, null);
            current = current.next;
        }
        return newRoot.next;
    }

    public static Node reversal(Node root) {
        if (root == null || root.next == null) {
            return root;
        }
        Node node = reversal(root.next);
        root.next.next = root;
        root.next = null;
        return node;
    }

    static class Node {

        int value;

        Node next;

        public Node() {
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    // 待优化
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k) {
            return new int[]{};
        }
        int length = nums.length - k + 1;
        int[] result = new int[length];
        int[] sortNum = new int[k];
        System.arraycopy(nums, 0, sortNum, 0, k);
        Arrays.sort(sortNum);
        result[0] = sortNum[k - 1];
        for (int i = 1; i < length; i++) {
            int curr = nums[i - 1 + k];
            if (curr > sortNum[k - 1]) {
                result[i] = sortNum[k - 1];

                continue;
            }
            int currentMax = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                currentMax = Math.max(currentMax, nums[i + j]);
            }
        }
        return result;
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    // 未完成
    public static List<Integer> findAnagrams(String s, String p) {
        char[] pCharArray = p.toCharArray();
        int[] arr = new int[128];
        for (char c : pCharArray) {
            arr[c]++;
        }
        char[] sCharArray = s.toCharArray();
        for (int i = 0; i < pCharArray.length; i++) {
            int[] newArr = new int[128];
            System.arraycopy(arr, 0, newArr, 1, arr.length - 1);
            for (int j = i; j < sCharArray.length; j++) {
                int n = newArr[sCharArray[j]];
                if (n == 1) {
                    newArr[sCharArray[j]] = -1;
                } else if (n > 1) {
                    newArr[sCharArray[j]]--;
                }
                if (n == 0) {
                    i = j + 1;
                }

                if (j == sCharArray.length - 1) {
                    return new ArrayList<>();
                }
            }
        }
        return new ArrayList<>();
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length == 0 || charArray.length == 1) {
            return charArray.length;
        }
        int max = 0;
        int[] arr = new int[128];
        int i = 0;
        for (int j = 0; j < charArray.length; j++) {
            int index = arr[charArray[j]];
            if (index - 1 < i) {
                arr[charArray[j]] = j + 1;
                if (j == charArray.length - 1) {
                    return Math.max(max, j - i + 1);
                }
                continue;
            }
            arr[charArray[j]] = j + 1;
            max = Math.max(max, j - i);
            i = index;
        }
        return max;
    }
    public static int trap1(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        int lastMax = 0, currentMax = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                if (height[left] == 0 || height[left] <= leftMax) {
                    left++;
                    continue;
                }
            } else {
                if (height[right] == 0 || height[right] <= rightMax) {
                    right--;
                    continue;
                }
            }
            if (left + 1 > right - 1) {
                return result;
            }
            lastMax = currentMax;
            leftMax = height[left];
            rightMax = height[right];
            currentMax = Math.min(leftMax, rightMax);
            for (int i = left + 1; i < right; i++) {
                result += Math.max(currentMax - Math.max(height[i], lastMax), 0);
            }
        }
        return result;
    }
    public static int trap(int[] height) {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        int left = 0, right = height.length - 1;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        while (left < right) {
            if (leftMax < rightMax) {
                if (height[left] == 0 || height[left] <= leftMax) {
                    left++;
                    continue;
                }
            } else {
                if (height[right] == 0 || height[right] <= rightMax) {
                    right--;
                    continue;
                }
            }
            if (left + 1 > right - 1) {
                break;
            }
            leftMax = height[left];
            rightMax = height[right];
            leftList.add(left);
            rightList.add(right);
        }
        if (leftList.isEmpty()) {
            return 0;
        }
        int i = 0;
        int result = 0;
        while (i < leftList.size() - 1) {
            result += sectionSum(leftList.get(i), leftList.get(i + 1), height);
            result += sectionSum(rightList.get(i + 1), rightList.get(i), height);
            i++;
        }
        result += sectionSum(leftList.get(i), rightList.get(i), height);
        return result;
    }

    private static int sectionSum(int l, int r, int[] height) {
        if (l + 1 > r - 1) {
            return 0;
        }
        int result = 0;
        for (int j = l + 1; j < r; j++) {
            int h = Math.min(height[l], height[r]);
            result += Math.max(h - height[j], 0);
        }
        return result;
    }
    public static int maxArea(int[] height) {
        if (height == null || height.length == 0 || height.length == 1) {
            return 0;
        }
        int start = 0, end = height.length - 1;
        for (int i = 0, j = height.length - 1; i < j; i++, j--) {
            if (height[i + 1] - height[start] > i + 1 - start) {
                start = i + 1;
            }
            if (height[j - 1] - height[end] > end - j + 1) {
                end = j - 1;
            }
        }
        return (end - start) * Math.min(height[start], height[end]);
    }

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }

            int current = 1;
            int next = num + 1;
            while (set.contains(next)) {
                current++;
                next++;
            }
            max = Math.max(max, current);
        }
        return max;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap =  new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newStr = String.valueOf(chars);

            List<String> list = hashMap.getOrDefault(newStr, new ArrayList<>());
            list.add(str);
            hashMap.put(newStr, list);
        }
        return new ArrayList<>(hashMap.values());
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer i2 = map.get(target - nums[i]);
            if (i2 != null) {
                return new int[]{i, i2};
            }
            map.put(nums[i], i);
         }
        return new int[0];
    }
}
