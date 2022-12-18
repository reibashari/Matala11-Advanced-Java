import java.security.SecureRandom;

//MatLogiv runs the logic of the game
public class MatLogic {

    private  int[][] mat;

    public MatLogic(int size) {
        mat=new int[size][size];
        fillRandMmatix();
    }

    //This function return the matrix as  two dimensional array.
    public int [] [] getMatrix () {
        return mat;
    }

    //This function fill giving matrix in random values of 0 and 1.
    public  void fillRandMmatix () {
        SecureRandom randomNumbers = new SecureRandom();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++) {
                int random = randomNumbers.nextInt(2);
                mat[i][j] = random;
            }
        }
    }

    //This function change the values of the giving matrix according to "Game of life".
    public  void changeMatrix() {
        int[][] newMatrix = new int[mat.length][mat.length];
        int aliveNeighbors = 0;
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat.length;j++) {
                if(i != 0 && i != mat.length-1 && j!=0 && j!=mat.length-1) { //in the middle
                    aliveNeighbors = mat[i-1][j-1] + mat[i][j-1] + mat[i+1][j-1] + mat[i-1][j] + mat[i+1][j] + mat[i-1][j+1] + mat[i][j+1] + mat[i+1][j+1];
                } else {  //edges
                    if(i == 0) { //left column
                        if(j == 0) { //top left corner
                            aliveNeighbors = mat[i][j+1] + mat[i+1][j+1] + mat[i+1][j];
                        } else if(j == mat.length-1) {  //bottom left corner
                            aliveNeighbors = mat[i][j-1] + mat[i+1][j-1] + mat[i+1][j];
                        } else { //middle of the left column
                            aliveNeighbors = mat[i][j-1] + mat[i][j+1] + mat[i+1][j-1]  + mat[i+1][j] + mat[i+1][j+1];
                        }
                    } else if(i == mat.length-1) {//right column
                        if(j == 0) { //top right corner
                            aliveNeighbors = mat[i][j + 1] + mat[i - 1][j] + mat[i - 1][j + 1];
                        }
                        else if(j == mat.length-1) //bottom right corner
                        {
                            aliveNeighbors = mat[i-1][j] + mat[i-1][j-1] + mat[i][j-1];
                        }
                        else //middle of the right column
                        {
                            aliveNeighbors = mat[i][j-1] + mat[i][j+1] + mat[i-1][j-1]  + mat[i-1][j] + mat[i-1][j+1];
                        }
                    }
                    else //middle tile of the edge
                    {
                        if(j == 0){ //middle of the top row
                            aliveNeighbors = mat[i-1][j] + mat[i+1][j] + mat[i][j+1]  + mat[i-1][j+1] + mat[i+1][j+1];
                        } else if(j == mat.length-1) { //middle of bottom row
                            aliveNeighbors = mat[i-1][j] + mat[i+1][j] + mat[i-1][j-1]  + mat[i][j-1] + mat[i+1][j-1];
                        }
                    }
                }
                newMatrix[i][j] = paintTile(aliveNeighbors,mat[i][j]);
            }
        }
        mat=newMatrix;
    }

    public int paintTile ( int aliveNeighbors, int currentTile){
        if (currentTile == 0){
            return (aliveNeighbors == 3) ? 1 : 0;
        }else {
            return (aliveNeighbors < 2 || aliveNeighbors > 3) ? 0 : 1 ;
        }
    } 
}