public enum KnightMovePossibilities {
    MOVEUN(1,2),
    MOVEDEUX(2,1),
    MOVETROIS(1,-2),
    MOVEQUATRE(2,-1),
    MOVECINQ(-1,-2),
    MOVESIX(-2,-1),
    MOVESEPT(-1,2),
    MOVEHUIT(-2,1);

    private final int x;
    private final int y;

    KnightMovePossibilities(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}