package com.dailycodingproblem;

public class Number_919 {

    static void solve(Integer[][] input) {
        for(int i = 0; i < input.length; i++) {
            int rowsum = 0;
            for(int  j = 0; j < input[i].length; j++) {
                rowsum += input[i][j];
                input[i][j] = rowsum;
            }
        }
        System.out.println("blah");
    }

    public static void main(String[] args) {
        solve(new Integer[][]{{3, 5, 1, 1},
                {2, 3, 3, 2},
                {5, 5},
                {4, 4, 2},
                {1, 3, 3, 3},
                {1, 1, 6, 1, 1}});
    }
}