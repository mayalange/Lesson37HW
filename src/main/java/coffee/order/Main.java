package coffee.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();

        board.add("Marina");
        board.add("Vadim");
        board.add("Vanya");
        board.add("Dima");

        board.draw();

        Order delivered = board.deliver();

        delivered = board.deliver(4);

        board.draw();
    }
}