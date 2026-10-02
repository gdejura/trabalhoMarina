void main() {
    Roomba roomba = new Roomba();
    Coelho coelho = new Coelho(roomba);

    while(true){
        coelho.update();
        roomba.update();

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
