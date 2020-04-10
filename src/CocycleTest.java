public class CocycleTest {

    private static int[] samples;

    public static void main(String[] args) {

        samples = new int[] {0,0,0,0,-14};

        trim();

        for (int i : samples){
            System.out.println(i);
        }

        //Define Cocycle Outline
        int[][][] cocycle = new int[3][3][3];
        for (int i = 0; i < cocycle.length; i++){
            for (int j = 0; j < cocycle.length; j++){
                for (int k = 0; k < cocycle.length; k++){
                    cocycle[i][j][k] = 1;
                }
            }
        }

        //Cocycles that work:
        //cocycle[0][1][0] = cocycle[0][2][0] = cocycle[2][0][2] = cocycle[2][1][2] = cocycle[1][0][1] = cocycle[1][2][1] = cocycle[0][1][2] = cocycle[1][2][0] = cocycle[2][0][1] = -1;

        //Define what entries are -1
        cocycle[0][2][1] = cocycle[1][0][2] = cocycle[2][1][0] = cocycle[0][2][0] = cocycle[2][0][2] = cocycle[0][1][0] = cocycle[1][0][1] = cocycle[1][2][1] = cocycle[2][1][2] = -1;

        //Test if iij = 1
        test1(cocycle);

        //Test if jii = 1
        test2(cocycle);

        //Test if ijk*ikl = ijl*jkl
        test3(cocycle);
    }

    //Test if iij = 1
    public static void test1(int [][][] cocycle){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (cocycle[i][i][j] != 1){
                    System.out.println(Integer.toString(i) + Integer.toString(j) + Integer.toString(j) + " is not 1");
                    return;
                }
            }
        }
        System.out.println("Test 1 Passed");
    }

    //Test if jii = 1
    public static void test2(int [][][] cocycle){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (cocycle[j][i][i] != 1){
                    System.out.println(Integer.toString(j) + Integer.toString(i) + Integer.toString(i) + " is not 1");
                    return;
                }
            }
        }
        System.out.println("Test 2 Passed");
    }

    public static void test3(int [][][] cocycle){
        for (int i = 0; i < cocycle.length; i++){
            for (int j = 0; j < cocycle.length; j++){
                for (int k = 0; k < cocycle.length; k++){
                    for (int l = 0; l < cocycle.length; l++){
                        if (cocycle[i][j][k] * cocycle[i][k][l] != cocycle[i][j][l] * cocycle[j][k][l]){
                            System.out.println(Integer.toString(i) + Integer.toString(j) + Integer.toString(k) + " * " + Integer.toString(i) + Integer.toString(k) + Integer.toString(l) +
                                                " != " + Integer.toString(i) + Integer.toString(j) + Integer.toString(l) + " * " + Integer.toString(j) + Integer.toString(k) + Integer.toString(l));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Test 3 Passed");
    }

    public static void trim(){
        int index = 0;

        while(samples[index] == 0){
            index++;
        }

        int [] array2 = new int[samples.length-index];
        int index2 = 0;
        for (int i = index; i < samples.length; i++){
            array2[index2] = samples[i];
        }

        samples = array2;
    }
}
