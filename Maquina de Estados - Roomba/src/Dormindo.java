public class Dormindo extends AbstractState{
    private Coelho coelho;

    public Dormindo(Coelho coelho){
        super("Dormindo");
        this.coelho = coelho;
    }

    @Override
    public void enter() {System.out.println("o coelho está com soninho");}

    @Override
    public void leave() {System.out.println("Bom dia! O coelho acordou!!");}

    @Override
    public void execute() {
        coelho.addSono(-10);
        coelho.addFome(3);
        System.out.println("zZzZ o coelho está dormindo zZzZ");
        System.out.println("Sono: " + coelho.getSono());
        System.out.println("Fome: " + coelho.getFome());

        if(coelho.getSono() <= 0){
            if(coelho.getFome() > 50){
                coelho.setState(new Comendo(coelho));
            } else {
                coelho.setState(new Brincando(coelho));
            }
        }
    }
}
