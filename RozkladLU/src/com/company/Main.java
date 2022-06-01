package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int size = 3;

        double[][] matrixA = { {60, 30, 20}, {30, 20, 15}, {20, 15, 12} };
        double[][] matrixB = { {3, 0, 1}, {0, -1, 3}, {1, 3, 0} };
        double[][] matrixC = { {2, 1, -2}, {4, 2, -1}, {6, 3, 11} };

        //          MATRIX A        //
        Matrix myMatrix = new Matrix(size, matrixA);

        System.out.println(myMatrix.toString());

        //          DOOLITTLE       //
        System.out.println(Arrays.deepToString(myMatrix.doolittle()));


        //          MATRIX B        //
        myMatrix.setMx(matrixB);

        System.out.println(myMatrix.toString());

        //          DOOLITTLE       //
        System.out.println(Arrays.deepToString(myMatrix.doolittle()));



        //          MATRIX C        //
        myMatrix.setMx(matrixC);

        System.out.println(myMatrix.toString());

        //          DOOLITTLE       //
        System.out.println(Arrays.deepToString(myMatrix.doolittle()));


        //          SOLVING LINEAR EQUATIONS        //
//        double[][] matrixS = { {2, 4, 1}, {2, -2, 5}, {4, 2, 4} };
//        double[] B = {2, 4, 2};

        double[][] matrixS = { {4, -2, 4, -2}, {3, 1, 4, 2}, {2, 4, 2, 1}, {2, -2, 4, 2} };
        double[] B = {8, 7, 10, 2};
        size = 4;

        Matrix mySolveMatrix = new Matrix(size, matrixS);

        System.out.println(mySolveMatrix.toString());
        System.out.println("Matrix B = " + Arrays.toString(B));

        //System.out.println(Arrays.deepToString(mySolveMatrix.doolittleV2()));

        //System.out.println(Arrays.deepToString(mySolveMatrix.doolittle()));

        System.out.println("Solved result = " + Arrays.toString(mySolveMatrix.solveWithLU(B)));
    }
}
