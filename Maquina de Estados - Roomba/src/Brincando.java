public class Brincando extends AbstractState{
    private Coelho coelho;

    public Brincando(Coelho coelho) {
        super("Brincando");
        this.coelho = coelho;
    }

    @Override
    public void enter() {System.out.println("Eba! o coelho quer brincar!");}

    @Override
    public void execute() {
        coelho.getRoomba().addSujeira(10);
        coelho.addFome(3);
        coelho.addSono(5);
        System.out.println("iupiiii o coelho está brincando!");
        System.out.println("Sono: " + coelho.getSono());
        System.out.println("Fome: " + coelho.getFome());


        if(coelho.getSono() > 70){
            coelho.setState(new Dormindo(coelho));
        } else if (coelho.getFome() > 50){
            coelho.setState(new Comendo(coelho));
        }
    }
}
