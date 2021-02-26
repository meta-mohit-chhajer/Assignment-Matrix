import java.util.*;
class Matrix
{
  private final int row;
  private final int col;
  private final int[][]mat;

 


  public Matrix(int row,int col)
  {
    this.row=row;
    this.col=col;
    mat=new int[row][col];
  }

  public Matrix(int[][] mat)
  {
    row=mat.length;
    col=mat[0].length;
    this.mat=new int[row][col];
    for(int i=0;i<row;i++)
    	for(int j=0;j<col;j++)
        	this.mat[i][j]=mat[i][j];
  }

  public Matrix transpose()
  {
    Matrix trans=new Matrix(col,row);
    for(int i=0;i<row;i++)
    	for(int j=0;j<col;j++)
        	trans.mat[j][i]=this.mat[i][j];
    return trans;
  }

  public Matrix Add(Matrix B)
  {
    Matrix A=this;
    if(B.row!=A.row || B.col!=A.col) throw new RuntimeException("Illegal matrix Dimension");
    Matrix Sum=new Matrix(row,col);
    for(int i=0;i<row;i++)
    	for(int j=0;j<col;j++)
        	Sum.mat[i][j]=A.mat[i][j]+B.mat[i][j];
    return Sum;
  }

  
   public Matrix Mul(Matrix B)
   {
     Matrix A=this;
     if(A.col!=B.row) throw new RuntimeException("Illegal Matrix Dimension");
     Matrix mul=new Matrix(A.row,B.col);
     for(int i=0;i<mul.row;i++)
     	for(int j=0;j<mul.col;j++)
        	for(int k=0;k<A.col;k++)
                	mul.mat[i][j]+=(A.mat[i][k]*B.mat[k][j]);
     return mul;
   }
 
   public boolean Symm(Matrix B)
   {
     if (row!=col) throw new RuntimeException("Not Square Matrix.....Can't be Symmetric ");
     for(int i=0;i<row;i++)
     {
       for(int j=0;j<col;j++)
       {
         if(B.mat[i][j]!=B.mat[j][i])
         	return false;
       }
     }
     return true;
  }	
    
   public void show()
   {
    for(int i=0;i<row;i++)
    {
      for(int j=0;j<col;j++)
      {
        System.out.printf("%5d",mat[i][j]);
      }
      System.out.println();
    }
  } 

   public static void main(String...arg)
   {
     int [][]d={
        {0 , 3 , 0 , 4 },
        {0 , 5 , 7 , 0 },
        {0 , 0 , 0 , 0 },
        {2 , 6 , 0 , 0 }
    };

    int [][]b={
       {0 , 1 , 1 , 0},
       {0 , 0 , 0 , 0},
       {0 , 0 , 4 , 4},
       {1 , 8 , 0 , 0}
    };
       

    Matrix Data=new Matrix(d);
    Data.show();

    System.out.println("\n\n");

    Matrix B=Data.transpose();
    B.show();
 
    System.out.println("\n\n");

    Matrix A=new Matrix(b);
    A.show();
    System.out.println("\n Is this Matrix is Symmetric : "+A.Symm(A)); 
        
    System.out.println("\n\n");

    Data.Add(A).show();
    System.out.println("\n\n");

    A.Mul(Data).show();
  }
}
       