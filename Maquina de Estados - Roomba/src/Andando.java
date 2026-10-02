public class Andando extends AbstractState{
    private Roomba roomba;

    public Andando(Roomba roomba){
        super("Andando");
        this.roomba = roomba;
    }
    @Override
    public void enter(){ System.out.println("beep! sem rotas no momento");}

    @Override
    public void execute(){
        roomba.addBateria(-2);
        System.out.println("beep! o roomba está passeando");
        System.out.println("Bateria: " + roomba.getBateria());
        System.out.println(("Sujeira: " + roomba.getSujeira()));

        int chance = (int)(Math.random() * 101);

        if(chance <= 15){ //bateu na parede
            roomba.setState(new Refazendo_Rota(roomba));
        } else if(roomba.getBateria() <= 30){
            roomba.setState(new Recarregando(roomba));
        } else if(roomba.getSujeira() >= 50){
            roomba.setState((new Limpando(roomba)));
        }


    }
}
