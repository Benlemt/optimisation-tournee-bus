import java.util.Objects;

public class Bus {

    private int passengers;
    private int passengersMax;
    private int score;

    public Bus(int passengersMax) {
        this.passengersMax = passengersMax;
        this.passengers = 0;
        this.score = 0;
    }


    // Getters

    public int getPassengers() {
        return this.passengers;
    }

    public int getScore() {
        return this.score;
    }

    public int getPassengersMax() {
        return this.passengersMax;
    }

    // Setters

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Passengers management

    public void addPassenger(int addedPassengers) {
        this.passengers += addedPassengers;
    }

    public void removePassenger(int removedPassengers) {
        this.passengers -= removedPassengers;
    }

    // Score management

    public void addScore(int addedScore) {
        this.score += addedScore;
    }

    // Place management

    public int getRemainingSeats() {
        return this.passengersMax - this.passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bus)) return false;
        Bus bus = (Bus) o;
        return getPassengers() == bus.getPassengers();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassengers());
    }

    public Bus getCopy() {
        Bus newBus = new Bus(this.passengersMax);
        newBus.setPassengers(this.passengers);
        return newBus;
    }
}
