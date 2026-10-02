public class Coelho {
    private int fome = 0;
    private int sono = 0;

    private State state = new Brincando(this);
    private Roomba roomba;

    public Coelho(Roomba roomba){
        this.roomba = roomba;
    }

    public Roomba getRoomba() {
        return roomba;
    }

    public int getFome() {
        return fome;
    }

    public void addFome(int fome){
        this.fome += fome;
        this.fome = Math.max(this.fome, 0);
    }

    public int getSono() {
        return sono;
    }

    public void addSono(int sono){
        this.sono += sono;
        this.sono = Math.max(this.sono, 0);
    }

    public void update(){state.execute();}

    public void setState(State state) {
        this.state.leave();
        this.state = state;
        state.enter();
    }
}
