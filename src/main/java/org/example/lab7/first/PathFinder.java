package org.example.lab7.first;
public class PathFinder {
    public static int[][] findMaxCoins(int[][] map) {
        int rows = map.length;
        int columns = map[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = map[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + map[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + map[i][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    ) + map[i][j];
                }
            }
        }
        return dp;
    }
    public static String restorePath(int[][] dp) {
        int i = dp.length - 1;
        int j = dp[0].length - 1;
        StringBuilder path = new StringBuilder();
        while (i > 0 || j > 0) {
            if (i == 0) {
                path.append("R");
                j--;
            } else if (j == 0) {
                path.append("D");
                i--;
            } else if (dp[i][j - 1] >= dp[i - 1][j]) {
                path.append("R");
                j--;
            } else {
                path.append("D");
                i--;
            }
        }
        return path.reverse().toString();
    }
}

