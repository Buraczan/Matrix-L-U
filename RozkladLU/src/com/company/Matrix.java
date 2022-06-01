package com.company;

import java.util.Arrays;

public class Matrix {

    private int size;
    private double[][] mx;

    public Matrix(int n, double[][] matrixToSet) {
        size = n;
        mx = matrixToSet;
    }

    public void setMx(double[][] matrix) {
        mx = matrix;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                Arrays.deepToString(mx) +
                '}';
    }

    public double[][] doolittle() {
        double[][] result = mx;

        double pom;

        for(int j = 0; j < size; j++) {

            for(int i = 0; i <= j; i++) {
                pom = 0;
                for(int k = 0; k < i; k++) {
                    pom += result[i][k] * result[k][j];
                }
                result[i][j] -= pom;
            }

            for(int i = j + 1; i < size; i++) {
                pom = 0;
                for(int k = 0; k < j; k++) {
                    pom += result[i][k] * result[k][j];
                }
                result[i][j] = (result[i][j] - pom) / result[j][j];
            }
        }
        return result;
    }

    public double[][] doolittleV2() {
        double[][] result = mx;

        int i, j, k;

        for(k = 0; k < size - 1; k++) {

            for(i = k + 1; i < size; i++) {
                result[i][k] /= result[k][k];
            }

            for(i = k + 1; i < size; i++) {
                for(j = k + 1; j < size; j++) {
                    result[i][j] -= result[i][k] * result[k][j];
                }
            }
        }
        return result;
    }

    public double[] solveWithLU(double[] B) {
        int i, j;
        double[][] A = this.doolittleV2();
        double sum;
        double[] result = new double[size];

        result[0] = B[0];

        for(i = 1; i < size; i++) {
            sum = 0;
            for(j = 0; j < i; j++) {
                sum += A[i][j] * result[j];
            }
            result[i] = B[i] - sum;
        }

        result[size - 1] /= A[size - 1][size - 1];

        for(i = size - 2; i >= 0; i--) {
            sum = 0;
            for(j = i + 1; j < size; j++) {
                sum += A[i][j] * result[j];
            }
            result[i] = (result[i] - sum) / A[i][i];
        }

        return result;
    }
}
