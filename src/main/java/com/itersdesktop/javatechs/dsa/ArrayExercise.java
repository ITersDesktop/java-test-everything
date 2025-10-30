package com.itersdesktop.javatechs.dsa;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayExercise {
    public static void main(String[] args) {
        int[] array = {0,1,2,2,1,2,1,1,1,0,0,0,1,1};
        printArray(array);
        System.out.println("\n");
        sortColors(array);
        System.out.println(isPalindrome(1221));
    }

    public static void printArray(int[] nums) {
        int num0 = 0, num1 = 0, num2 = 0;
        for (int i : nums) {
            switch (i) {
                case 0:
                    num0++;
                    break;
                case 1:
                    num1++;
                    break;
                case 2:
                    num2++;
                    break;
            }
        }
        nums = new int[nums.length];
        int idx = 0;
        for (int i = 0; i < num0; i++) {
            nums[idx++] = 0;
        }
        for (int i = 0; i < num1; i++) {
            nums[idx++] = 1;
        }
        for (int i = 0; i < num2; i++) {
            nums[idx++] = 2;
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    // https://leetcode.com/problems/sort-colors/
    // Fastest
    public static void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        for (int i = 0; i <= r;)
            if (nums[i] == 0)
                swap(nums, i++, l++);
            else if (nums[i] == 1)
                ++i;
            else
                swap(nums, i, r--);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void swap(int[] nums, int i, int j) {
        final int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColorsFaster1(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(0, 0);
        count.put(1, 0);
        count.put(2, 0);

        for (int num : nums) {
            count.put(num, count.get(num) + 1);
        }

        int idx = 0;
        for (int color = 0; color < 3; color++) {
            int freq = count.get(color);
            for (int j = 0; j < freq; j++) {
                nums[idx] = color;
                idx++;
            }
        }
    }

    public void sortColorsFaster2(int[] nums) {
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i; j < nums.length; j++)
            {
                if(nums[i]>nums[j])
                {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public void sortColorsFaster3(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i =0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public boolean isPalindromeFastest(int x) {

        if(x<0|| (x%10==0 && x!=0)){
            return false;
        }

        int rev= 0;

        while(x>rev){

            rev = rev*10 + x % 10;
            x=x/10;
        }
        return (x==rev)|| (x==rev/10);

    }
//    https://leetcode.com/problems/palindrome-number/
    public boolean isPalindromeFaster(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x /= 10;
        }
        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static boolean isPalindrome(int x) {
        String strX = String.valueOf(x);
        int mid = strX.length()/2;
        int l = 0, r = strX.length()-1;
        if (-9 < x && x < 9) {
            return true;
        }
        while (l <= mid) {
            if (strX.charAt(l++) != strX.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    // https://leetcode.com/problems/plus-one/ - my solution is fastest
    public int[] plusOne(int[] digits) {
        if (digits.length == 1) {
            if (digits[0] == 9) {
                return new int[]{1,0};
            } else {
                digits[0] += 1;
                return digits;
            }
        } else {
            boolean cont = true;
            int i = digits.length - 1;
            while (cont) {
                int col = digits[i] + 1;
                if (col == 10) {
                    digits[i] = 0;
                    i = i - 1;
                    cont = true;
                } else {
                    cont = false;
                    digits[i] = col;
                }
                if (i == -1) {
                    int[] newNum = new int[digits.length+1];
                    newNum[0] = 1;
                    for (int j = 0; j < digits.length; j++) {
                        newNum[j+1] = digits[j];
                    }
                    digits = newNum;
                    break;
                }
            }
            return digits;
        }
    }


}
