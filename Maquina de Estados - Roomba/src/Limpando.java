public class Limpando extends AbstractState{
    private Roomba roomba;

    public Limpando(Roomba roomba){
        super("Limpando");
        this.roomba = roomba;
    }
    @Override
    public void enter(){ System.out.println("beep! sujeira encontrada!");}

    @Override
    public void leave(){ System.out.println(("beep! tudo limpo!")); }

    @Override
    public void execute(){
        roomba.addBateria(-5);
        roomba.addSujeira(-16);
        System.out.println("beep! limpando...");
        System.out.println("Bateria: " + roomba.getBateria());
        System.out.println(("Sujeira: " + roomba.getSujeira()));

        int chance = (int)(Math.random() * 101);

        if(chance <= 15){//bateu na parede
            roomba.setState(new Refazendo_Rota(roomba));
        } else if(roomba.getBateria() <= 30){
            roomba.setState(new Recarregando(roomba));
        } else if(roomba.getSujeira() <= 0){
            roomba.setState((new Andando(roomba)));
        }
    }
}
