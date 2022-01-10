import java.util.Arrays;
import java.util.List;

public class KnightProblem {
    //Attributes
    private int knightX;
    private int knightY;
    private int tableLenght;
    private int [][] chessBoard;
    private int position;
    private int numberOfSolution;

    //Deplacement du cavalier possible
    private List<KnightMovePossibilities> possibleMoves = Arrays.asList(KnightMovePossibilities.MOVEUN, 
                                                                        KnightMovePossibilities.MOVEDEUX,
                                                                        KnightMovePossibilities.MOVETROIS,
                                                                        KnightMovePossibilities.MOVEQUATRE,
                                                                        KnightMovePossibilities.MOVECINQ,
                                                                        KnightMovePossibilities.MOVESIX,
                                                                        KnightMovePossibilities.MOVESEPT,
                                                                        KnightMovePossibilities.MOVEHUIT);
                                                                        
    //Constructeur
    public KnightProblem(int Xposition, int Yposition, int tablelenght){
        this.knightX = Xposition;
        this.knightY = Yposition;
        this.tableLenght = tablelenght;
        this.chessBoard = new int[tablelenght][tablelenght];
        for(int i = 0; i < this.tableLenght; i++){
            for(int j = 0; j < this.tableLenght; j++){
                this.chessBoard[i][j] = -1; 
            }
        }
        this.position = 1;
        this.numberOfSolution = 0;
    }

    /**
     * Affiche toutes les valeurs du tableau
     */
    public void afficheChessBoard(){
        for(int i = 0; i < this.tableLenght; i++){
            for(int j = 0; j < this.tableLenght; j++){
                System.out.print(this.chessBoard[i][j]);
            }
                System.out.print("\n");
        }
    }

    /**
     * @return La valeur de l'attribut numberOfSolution
     */
    public int getNumberOfSolution(){
        return this.numberOfSolution;
    }

    /**
     * Trouve les solutions du problème du cavalier
     */
    public void findKnightSolution(){
        //A remplir
    }
}