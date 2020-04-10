public class MatrixMultiplication {

    public static void main(String[] args) {

        double[][] array1 = {{1,2,3},{4,5,6},{7,8,9}};
        double [][] identity = {{1,0,0},{0,1,0},{0,0,1}};

        double [][] array2 = {{1,2},{3,4}};
        double [][] array3 = {{1,3,5},{2,4,6}};

        printAray(array2);
        System.out.println("");
        printAray(array3);
        System.out.println("");
        printAray(matrixMult(array2, array3));


    }

    public static double[][] matrixMult(double [][] x, double [][] y){

        if (x[0].length != y.length){
            return null;
        }

        double [][] result = new double[x.length][y[0].length];

        for (int row = 0; row < result.length; row++){
            for (int col = 0; col < result[0].length; col++){
                double z = multRows(x[row], transpose(y)[col]);
                result[row][col] = z;
            }
        }

        return result;
    }

    public static double[][] transpose(double [][] x){
        double [][]result = new double[x[0].length][x.length];

        for (int row = 0; row < result.length; row++){
            for (int col = 0; col < result[0].length; col++){
                result[row][col] = x[col][row];
            }
        }

        return result;
    }

    public static void printAray(double [][] x){
        for (int i = 0; i < x.length; i++){
            for (int j = 0; j < x[0].length; j++){
                System.out.print(x[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static double multRows(double[] x, double[] y){
        double sum = 0;
        for (int i = 0; i < x.length; i++){
            sum += x[i] * y[i];
        }
        return sum;
    }

    public static double[][] cocycleMult(double [][] x, double [][] y, double [][][] cocycle){
        double [][] result = new double[x.length][y[0].length];

        for (int i = 0; i < x.length; i++){
            for (int j = 0; j < y[0].length; j++){
                double val = 0;
                for (int k = 0; k < y.length; k++){
                    val += x[i][k] * y[k][j] * cocycle[i][j][k];
                }
                result[i][j] = val;
            }
        }

        return result;
    }
}
