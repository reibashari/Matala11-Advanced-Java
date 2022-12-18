import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

//MatrixController handle the graphics of the game
public class MatrixController {

    @FXML
    private Canvas canv;
    private GraphicsContext gc;
    
    private MatLogic matrix;
    final private int rectSize = 30;
    final private  int matrixSize=10;

    @FXML
    //button press function
    void pressed(ActionEvent event) {
    	matrix.changeMatrix();
    	int [][] mat= matrix.getMatrix();
    	fillMat(mat,0,0);
    }
    //initialize the game to start
    public void initialize() {
    	gc = canv.getGraphicsContext2D();
    	matrix= new MatLogic(matrixSize);
        int [][] mat= matrix.getMatrix();
        fillMat(mat,0,0);
    }
    //filling the squares according to the matrix changes
    public void fillMat(int[][] mat,int x,int y)
    {
    	for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (mat[i][j] == 1) {
                    gc.fillRect(x, y, rectSize, rectSize);
                } else {
                    gc.strokeRect(x, y, rectSize, rectSize);
                }
                x += rectSize;
            }
            y += rectSize;
            x = 0;
        }
    }
}
