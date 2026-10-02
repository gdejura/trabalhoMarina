public class Refazendo_Rota extends AbstractState{
    private Roomba roomba;
    private int ciclos = 0;

    public Refazendo_Rota(Roomba roomba){
        super("Refazendo_Rota");
        this.roomba = roomba;
    }
    @Override
    public void enter(){
        System.out.println("beeeeeeep! roomba bateu na parede");
        ciclos = 0;
    }

    @Override
    public void leave(){ System.out.println(("beep! continuando rota...")); }

    @Override
    public void execute(){
        ciclos++;
        roomba.addBateria(-1);
        System.out.println("beep! encontrando nova rota!");
        System.out.println("Bateria: " + roomba.getBateria());
        System.out.println(("Sujeira: " + roomba.getSujeira()));

        if(ciclos >= 3){
            roomba.setState(new Andando(roomba));
        } else if(roomba.getBateria() <= 30) {
            roomba.setState(new Recarregando(roomba));
        }
    }
}
