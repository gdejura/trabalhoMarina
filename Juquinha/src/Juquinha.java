public class Juquinha {
    private int fome = 0;
    private int sono = 0;

    public void trabaio()
    {
        System.out.println("trabaiando...");
        fome += 2;
        sono += 5;
    }

    public void comida()
    {
        System.out.println("comendo...");
        fome -= 5;
    }

    public void mimir()
    {
        System.out.println("mimindo...");
        fome += 1;
        sono -= 10;
    }

    public int getFome()
    {
        return fome;
    }

    public int getSono()
    {
        return sono;
    }

    public void setFome(int fome)
    {
        this.fome = fome;
    }

    public void setSono(int sono)
    {
        this.sono = sono;
    }

    public void printInfo()
    {
        System.out.println("Fome: " + fome);
        System.out.println("Cansaço: " + sono);
    }
}
