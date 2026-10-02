public class Comendo extends AbstractState{
    private Coelho coelho;

    public Comendo(Coelho coelho){
        super("Comendo");
        this.coelho = coelho;
    }

    @Override
    public void enter() {System.out.println("o coelho esta com fome!");}

    @Override
    public void leave() {System.out.println("que delícia! o coelho está de buchinho cheio");}

    @Override
    public void execute() {
        coelho.getRoomba().addSujeira(5);
        coelho.addFome(-10);
        coelho.addSono(3);
        System.out.println("nham nham o coelho está comendo!");
        System.out.println("Fome: " + coelho.getFome());
        System.out.println("Sono: " + coelho.getSono());

        if(coelho.getFome() <= 0){
            if(coelho.getSono() > 70){
                coelho.setState(new Dormindo(coelho));
            } else {
                coelho.setState(new Brincando(coelho));
            }
        }
    }
}
