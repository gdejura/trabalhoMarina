public class Recarregando extends AbstractState{
    private Roomba roomba;

    public Recarregando(Roomba roomba){
        super("Recarregando");
        this.roomba = roomba;
    }
    @Override
    public void enter(){ System.out.println("beep! o roomba precisa recarregar!");}

    @Override
    public void leave(){ System.out.println(("beep! energia cheia!!")); }

    @Override
    public void execute(){
        roomba.addBateria(6);
        System.out.println("beep! Recarregando bzzt");
        System.out.println("Bateria: " + roomba.getBateria());
        System.out.println(("Sujeira: " + roomba.getSujeira()));

        if(roomba.getBateria() >= 100){
            if(roomba.getSujeira() >= 50){
                roomba.setState(new Limpando(roomba));
            } else {
                roomba.setState(new Andando(roomba));
            }
        }
    }
}
