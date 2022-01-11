import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class KnightProblem {
    //Attributes
    private Position position;
    private int tableLenght;
    private int [][] chessBoard;
    private int count;
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
    public KnightProblem(Position position, int tablelenght){
        this.position = new Position(position.getX(),position.getY());
        this.tableLenght = tablelenght;
        this.chessBoard = new int[tablelenght][tablelenght];
        for(int i = 0; i < this.tableLenght; i++){
            for(int j = 0; j < this.tableLenght; j++){
                this.chessBoard[i][j] = -1; 
            }
        }
        this.chessBoard[this.position.getY()][this.position.getX()] = 1;
        this.count = 1;
        this.numberOfSolution = 0;
    }

    //Methodes

    /**
     * Methode qui vérifie tous les mouvements possibles du cavalier.
     * @return a List with all possible positions
     */
    public List<Position> deplacementPossible(){
        List<Position> result = new ArrayList<Position>();
        int finalX;
        int finalY;
        for(KnightMovePossibilities test : this.possibleMoves){
            finalX = this.position.getX() + test.getX();
            finalY = this.position.getY() + test.getY();
            if(finalX < 0 || finalX >= this.tableLenght || finalY < 0 || finalY >= this.tableLenght || this.chessBoard[finalY][finalX] != -1){
                continue;
            }else{
                Position addPos = new Position(finalX,finalY);
                result.add(addPos);
            }
        }
        return result;
    }

    /**
     * Affiche toutes les valeurs du tableau
     */
    public void printChessBoard(){
        for(int i = this.tableLenght-1; i >= 0; i--){
            for(int j = 0; j < this.tableLenght; j++){
                System.out.print(this.chessBoard[i][j] + " ");
            }
                System.out.print("\n");
        }
    }
    
    /**
     * Cherche la dernière position du cavalier
     * @return une Position qui correspond à celle précédente du cavalier s'il n'y en a 
     * pas alors elle retourne une Position(-1,-1)
     */
    public Position lastPosition(){
        Position result = new Position(-1,-1);
        if(this.count == 1){
            return result;
        }else{
            for(int i = 0; i < this.tableLenght; i++){
                for(int j = 0; j < this.tableLenght; j++){
                    if(this.chessBoard[i][j] == (this.count-1)){
                        result.setX(j);
                        result.setY(i);
                    }
                }
            }
            return result;
        }
    }

    /**
     * Ne prend aucun paramètre, bouge le cavalier à sa position précédente.
     */
    public void backToLastPosition(){
        Position lastPosition = this.lastPosition();
        if(lastPosition.getX() != -1){
        this.chessBoard[this.position.getY()][this.position.getX()] = -1;
        this.position.setX(lastPosition.getX());
        this.position.setY(lastPosition.getY());
        this.count -= 1;
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
        if(this.count == this.tableLenght*this.tableLenght){
            this.numberOfSolution += 1;
            this.backToLastPosition();
        }else{
                List<Position> possibleMouvement = this.deplacementPossible();
                if(possibleMouvement.isEmpty()){
                    this.backToLastPosition();
                }else{
                    for(Position test : possibleMouvement){
                        this.position.setX(test.getX());
                        this.position.setY(test.getY());
                        this.count += 1;
                        this.chessBoard[this.position.getY()][this.position.getX()] = this.count;
                        this.findKnightSolution();
                    }
                    this.backToLastPosition();
            }
        }
    }
    
    /**
     * Trouve une solution du problème du cavalier
     */
    public boolean findOneKnightSolution(){
        if(this.count == this.tableLenght*this.tableLenght){
            return true;
        }else{
            List<Position> possibleMouvement = this.deplacementPossible();
                if(possibleMouvement.isEmpty()){
                    this.backToLastPosition();
                }else{
                    for(Position test : possibleMouvement){
                        this.position.setX(test.getX());
                        this.position.setY(test.getY());
                        this.count += 1;
                        this.chessBoard[this.position.getY()][this.position.getX()] = this.count;
                        boolean trouve = this.findOneKnightSolution();
                        if(trouve)
                            return true;
                    }
                    this.backToLastPosition();
            }
        }
        return false;
    }
}