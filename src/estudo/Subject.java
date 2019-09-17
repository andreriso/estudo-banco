package estudo;

public interface Subject {

    void registerObserver(Observer o);
    void notifyObservers(Movimentacao movimentacao);

}
