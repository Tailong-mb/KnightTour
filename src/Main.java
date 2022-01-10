import java.util.Scanner;

public class Main {
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
        Position position = new Position(knightY-1,knightX-1);
        KnightProblem knight = new KnightProblem(position, tablelenght);

        //Trouver les cavaliers
        knight.findKnightSolution();
        System.out.print(knight.getNumberOfSolution());

    }
}
