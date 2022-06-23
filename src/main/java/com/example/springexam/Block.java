package com.example.springexam;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Block {
    private int no;
    private String color;
    private int[][] shape;

    public List<int[][]> variation() {
        List<int[][]> variation = new ArrayList<>();

        int[][] matrix = shape;

        addMatrix(variation, matrix);
        addMatrix(variation, reverse(matrix));
        matrix = rotate(matrix);

        addMatrix(variation, matrix);
        addMatrix(variation, reverse(matrix));
        matrix = rotate(matrix);

        addMatrix(variation, matrix);
        addMatrix(variation, reverse(matrix));
        matrix = rotate(matrix);

        addMatrix(variation, matrix);
        addMatrix(variation, reverse(matrix));

        return variation;
    }
    private void addMatrix(List<int[][]> variation, int[][] mb) {
        for (int[][] ma : variation) {
            if (isSameMatrix(ma, mb)) {
                // if the variation has a same matrix as mb, don't add mb.
                return;
            }
        }
        // add mb to the variation, because mb is new matrix for the variation.
        variation.add(mb);
    }

    private boolean isSameMatrix(int[][] ma, int[][] mb) {
        if (ma.length != mb.length) {
            return false;
        }
        for (int row = 0; row < ma.length; row++) {
            int rowLen = ma[row].length;
            for (int col = 0; col < rowLen; col++) {
                if (ma[row][col] != mb[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] rotate(int[][] org) {
        int[][] symmetry = new int[org[0].length][org.length];

        for (int row = 0; row < org.length; row++) {
            int rowLen = org[row].length;
            for (int col = 0; col < rowLen; col++) {
                symmetry[col][row] = org[row][col];
            }
        }
        // the rotation process is mixture of symmetry and reverse.
        return reverse(symmetry);
    }

    private int[][] reverse(int[][] org) {
        int[][] reversed = new int[org.length][org[0].length];

        for (int row = 0; row < org.length; row++) {
            int rowLen = org[row].length;
            for (int col = 0; col < rowLen; col++) {
                reversed[row][col] = org[row][rowLen - col -1];
            }
        }
        return reversed;
    }
}
