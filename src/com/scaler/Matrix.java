package com.scaler;

import java.util.Scanner;

class Matrix {
    // Define properties here
	int row;
    int column;
    int[][] arr;
	// Define constructor here
	Matrix(int row, int column){
        this.row=row;
        this.column=column;
        this.arr = new int[row][column];
    }
	
	void input(Scanner sc){
	    // Use the Scanner object passed as argument for taking input and not a new Scanner object
		// Complete the function
		for(int i=0; i<this.row; i++){
            for(int j=0; j<this.column; j++){
                this.arr[i][j] = sc.nextInt();
            }
        }
	}
	
	Matrix add(Matrix x){
		// Complete the function
        Matrix result = new Matrix(x.row, x.column);
		for(int i=0; i<this.row; i++){
            for(int j=0; j<this.column; j++){
                result.arr[i][j] = this.arr[i][j] + x.arr[i][j];
            }
        }
        return result;
	}
	
	Matrix subtract(Matrix x){
		// Complete the function
		Matrix result = new Matrix(x.row, x.column);
		for(int i=0; i<this.row; i++){
            for(int j=0; j<this.column; j++){
                result.arr[i][j] = this.arr[i][j] - x.arr[i][j];
            }
        }
        return result;
	}
		
	Matrix transpose(){
		// Complete the function
		Matrix result = new Matrix(this.column, this.row);
		for(int i=0; i<this.row; i++){
            for(int j=0; j<this.column; j++){
                result.arr[j][i] = this.arr[i][j];
            }
        }
        return result;
	}
	
	void print(){
		// Complete the function
		for(int i=0; i<this.row; i++){
            for(int j=0; j<this.column; j++){
                System.out.print(this.arr[i][j]+" ");
            }
            System.out.println();
        }
        
	}
}

/*
    Matrix a = new Matrix(10, 5)  // 10 rows, 5 columns
	a.input() 
	Matrix b = new Matrix(10, 5)  // 10 rows, 5 columns
	b.input()
    Matrix c1 = a.add(b)
    Matrix c2 = a.subtract(b)
    Matrix c3 = a.transpose()
    a.print()
*/