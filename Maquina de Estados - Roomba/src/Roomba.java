public class Roomba {
    private int bateria = 100;
    private int sujeira = 0;

    private State state = new Andando(this);

    public int getBateria() {return bateria;}

    public void addBateria(int bateria) {
        this.bateria += bateria;
        this.bateria = Math.min(this.bateria, 100);
    }

    public int getSujeira() {
        return sujeira;
    }

    public void addSujeira(int sujeira) {
        this.sujeira += sujeira;
        this.sujeira = Math.max(this.sujeira, 0);
    }

    public void update() { state.execute();}

    public void setState(State state) {
        this.state.leave();
        this.state = state;
        state.enter();
    }
}
