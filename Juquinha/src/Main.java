enum Estado
{
    TRABAIANDO,
    COMENDO,
    MIMINDO
}
void main()
{
    Juquinha juquinha = new Juquinha();
    Estado estado = Estado.TRABAIANDO;

    while(true)
    {
        switch(estado)
        {
            case TRABAIANDO:
                juquinha.trabaio();
                if(juquinha.getSono() > 50)
                {
                    estado = Estado.MIMINDO;
                    System.out.println("Q soninho...");
                }
                else if (juquinha.getFome() > 10)
                {
                    estado = Estado.COMENDO;
                    System.out.println("hmmm q fome...");
                }
                break;
            case COMENDO:
                juquinha.comida();
                if(juquinha.getFome() <= 0)
                {
                    juquinha.setFome(0);
                    System.out.println("nham nham buchinho cheio!");
                    estado = Estado.TRABAIANDO;
                    System.out.println("Hora de ir para o trabalho :(");
                }
                break;
            case MIMINDO:
                juquinha.mimir();
                if(juquinha.getSono() <= 0)
                {
                    juquinha.setSono(0);
                    if(juquinha.getFome() <= 10)
                    {
                        estado = Estado.TRABAIANDO;
                        System.out.println("Hora de ir para o trabalho :(");
                    } else {
                        estado = Estado.COMENDO;
                        System.out.println("hmmm q fome...");
                    }
                }
                break;
        }
        juquinha.printInfo();
        System.out.println("--------------------------\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
