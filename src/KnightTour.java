import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class KnightTour {
    //Attributes
    private Position position;
    private int tableLenght;
    private int [][] chessBoard;
    private int count;
    private int numberOfSolution;

    //Displacement of the rider possible:
    public static final List<KnightMovePossibilities> possibleMoves = Arrays.asList(KnightMovePossibilities.MOVEUN, 
                                                                        KnightMovePossibilities.MOVEDEUX,
                                                                        KnightMovePossibilities.MOVETROIS,
                                                                        KnightMovePossibilities.MOVEQUATRE,
                                                                        KnightMovePossibilities.MOVECINQ,
                                                                        KnightMovePossibilities.MOVESIX,
                                                                        KnightMovePossibilities.MOVESEPT,
                                                                        KnightMovePossibilities.MOVEHUIT);                                                                       
    //Constructor
    public KnightTour(Position position, int tablelenght){
        if(position.getX() >= tablelenght || position.getY() >= tablelenght || position.getY() < 0 || position.getX() < 0){
            throw new IllegalArgumentException("Out of the chessboard");
        }
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

    /**
     * Method that checks all possible movements of the rider.
     * @return a List with all possible positions.
     */
    public List<Position> deplacementPossible(){
        List<Position> result = new ArrayList<>();
        int finalX;
        int finalY;
        for(KnightMovePossibilities futurePosition : possibleMoves){
            finalX = this.position.getX() + futurePosition.getX();
            finalY = this.position.getY() + futurePosition.getY();
            if(!(finalX < 0 || finalX >= this.tableLenght || finalY < 0 || finalY >= this.tableLenght || this.chessBoard[finalY][finalX] != -1)){
                Position addPos = new Position(finalX,finalY);
                result.add(addPos);
            }
        }
        return result;
    }

    /**
     * Finds the last position of the rider
     * @returns a Position that matches the previous one of the rider if there is none
     * If there is no position then it returns a Position(-1,-1).
     */
    public Position lastPosition(){
        Position result = new Position(-1,-1);
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

    /**
     * Does not take any parameters, moves the jumper to its previous position.
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
     * Move to the knight to a Position.
     * @param futurePosition the next position.
     */
    public void goToThisPosition(Position futurePosition){
        this.position.setX(futurePosition.getX());
        this.position.setY(futurePosition.getY());
        this.count += 1;
        this.chessBoard[this.position.getY()][this.position.getX()] = this.count;
    }

    /**
     * Find the solutions to the KnightTour problem.
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
                    for(Position futurePosition : possibleMouvement){
                        this.goToThisPosition(futurePosition);
                        this.findKnightSolution();
                    }
                    this.backToLastPosition();
            }
        }
    }
    
    /**
     * Find a solution to the KnightTour problem.
     * @return true when a solution is found.
     */
    public boolean findOneKnightSolution(){
        if(this.count == this.tableLenght*this.tableLenght){
            this.numberOfSolution = 1;
            return true;
        }else{
            List<Position> possibleMouvement = this.deplacementPossible();
                if(possibleMouvement.isEmpty()){
                    this.backToLastPosition();
                }else{
                    for(Position futurePosition : possibleMouvement){
                        this.goToThisPosition(futurePosition);
                        boolean findASolution = this.findOneKnightSolution();
                        if(findASolution)
                            return true;
                    }
                    this.backToLastPosition();
            }
        }
        return false;
    }

    /**
     * @return the value of numberOfSolution.
     */
    public int getNumberOfSolution(){
        return this.numberOfSolution;
    }
    
    /**
     * Print the chessBoard.
     */
    public void printChessBoard(){
        for(int i = this.tableLenght-1; i >= 0; i--){
            for(int j = 0; j < this.tableLenght; j++){
                System.out.print(String.format("%02d ",this.chessBoard[i][j]));
            }
                System.out.print("\n");
        }
    }

    /**
     * main class :
     * @param args , tree values, the position of the knight in x then in y and finally the size of the chessboard.
     * @throws Exception
     */
    public static void main (String[] args) throws Exception{
        if(args.length != 3){
            throw new IllegalArgumentException();
        } else {
            Position position = new Position(Integer.parseInt(args[0])-1,Integer.parseInt(args[1])-1);
            KnightTour knight = new KnightTour(position, Integer.parseInt(args[2]));
            knight.findKnightSolution();
            int result = knight.getNumberOfSolution();
            if(result == 0){
                System.out.println(" 0 solution");
            } else {
                System.out.println(String.format("Number of solutions : %d\nThis is one solution :",result));
                knight.findOneKnightSolution();
                knight.printChessBoard();
            }
        }

    }
}