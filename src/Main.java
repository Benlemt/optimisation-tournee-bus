public class Main {

    public static void main(String[] args) {

        Engine engine = new Engine();

        Bus bus = new Bus(30);

        State state1 = new State(bus, new Node(1, 20, 20));
        State state2 = new State(bus, new Node(2, 20, 20));
        Bus bus2 = bus.getCopy();
        bus.addPassenger(2);
        State state3 = new State(bus, new Node(2, 20, 20));
        State state4 = new State(bus2, new Node(1, 20, 20));


        System.out.println(state1.equals(state2));
        System.out.println(state1.equals(state3));
        System.out.println(state1.equals(state4));


    }
}
