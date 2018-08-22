package pl.Marta.exercises.Threads.StatePattern;

public class Carriage {

    private Carriage() {

    }

    private int number;
    private String track;
    private int sidingNumber;
    private CarriageState state;

    public void report(){
        if(state != null){
            state.reportStatus(this);
        }else {
            System.out.println("the carriage state is unavailable");
        }
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public int getSidingNumber() {
        return sidingNumber;
    }

    public void setSidingNumber(int sidingNumber) {
        this.sidingNumber = sidingNumber;
    }

    public CarriageState getState() {
        return state;
    }

    public void setState(CarriageState state) {
        this.state = state;
    }


    public static class Builder {

        private int number;
        private String track;
        private int sidingNumber;
        private CarriageState state;

        public Builder exampleCarriage() {
            this.number = 3;
            this.sidingNumber = 12;
            this.track = "straight";
            return this;
        }

        public Builder(CarriageState state) {
            this.state = state;
        }

        public Carriage build() {
            Carriage carriage = new Carriage();
            this.number = number;
            this.track = track;
            this.sidingNumber = sidingNumber;
            this.state = state;
            return carriage;
        }

    }
}

