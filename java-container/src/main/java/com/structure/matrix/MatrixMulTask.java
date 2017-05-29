package com.structure.matrix;




import no.uib.cipr.matrix.Matrix;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Administrator on 2017/5/29 0029.
 */
public class MatrixMulTask extends RecursiveTask<Matrix> {
    private Matrix m1;
    private Matrix m2;
    private String pos;

    public MatrixMulTask(Matrix m1, Matrix m2, String pos) {
        this.m1 = m1;
        this.m2 = m2;
        this.pos = pos;
    }

    @Override
    protected Matrix compute() {
        System.out.println(Thread.currentThread().getId() + ":" + Thread.currentThread().getName() + "is start");
        return null;

    }
}
