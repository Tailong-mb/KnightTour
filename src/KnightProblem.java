import java.util.Scanner;

public class KnightProblem {
    //Attributes
    private int knightX;
    private int knightY;
    private int tableLenght;
    private int [][] chessBoard;
    private int position;
    private int numberOfSolution;

    //Deplacement du cavalier possible
    private final static int[][] knightPossibleMove = {{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};

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

    }
    public static void main(String args[]) throws Exception{
        //Initialisation
        Scanner sc = new Scanner(System.in);
        int knightX = 0;
        int knightY = 0;
        boolean trueValues = false;

        // Saisie et validation des paramètres
        System.out.println("Veuillez saisir la taille de l'echiquier (si depasse 5 alors la valeur sera de 5):");
        int tablelenght = sc.nextInt();
        if(tablelenght > 5){
            tablelenght = 5;
        }

        while(!trueValues){
            System.out.println("Veuillez saisir l'abscisse puis l'ordonnee de du cavalier :");
            try{
                knightX = sc.nextInt();
                knightY = sc.nextInt();
            }catch(Exception e){
                throw new IllegalArgumentException("Valeurs saisies invalides");
            }
            System.out.print("\n\n");
            if((knightX > tablelenght) || (knightY > tablelenght)){
                System.out.println("Depasssement d'echiquier");
            }
            else{
                trueValues = true;
                sc.close();
            }
        }
        KnightProblem knight = new KnightProblem(knightX, knightY, tablelenght);
        //Trouver les cavaliers
        knight.findKnightSolution();
        System.out.println("Voici l'une des solutions trouvee :");
        knight.afficheChessBoard();
        System.out.println("Nombre de solution trouve : ");
        System.out.println(knight.getNumberOfSolution());
    }
}