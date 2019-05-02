public class Main {
    public static void main(String[] args) {
        Grid board = new Grid();
        String gameTurn;
        gameTurn=board.played(5,1);
        System.out.println(gameTurn);
        gameTurn=board.played(4,5);
        System.out.println(gameTurn);
        gameTurn=board.played(2,1);
        System.out.println(gameTurn);
    }
}
