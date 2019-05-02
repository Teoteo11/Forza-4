public class Cell {
    private int player=0;
    private boolean state=false;

    public int getPlayer(){
        return player;
    }

    public void setPlayer(int player) {
        if(player==1 || player==5)
        this.player = player;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        if(this.player==1) return "●";
        else return "○";
    }
    /*pallino pieno=player1
      pallino vuoto=player2*/
}





